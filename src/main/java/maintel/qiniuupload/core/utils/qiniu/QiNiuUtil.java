package maintel.qiniuupload.core.utils.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import maintel.qiniuupload.core.Constant;
import maintel.qiniuupload.core.model.QiNiuAccount;

/**
 * Created by cjy on 2017/6/23.
 */
public class QiNiuUtil {

    public String getImgUrl(String accessKey, String secretKey, String imgUrl) {
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600 * 24 * 365 * 50;//1小时，可以自定义链接过期时间
        return auth.privateDownloadUrl(imgUrl, expireInSeconds);
    }

    public String getToken(String accessKey, String secretKey, String bucket) {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    public static String upload(byte[] file, String key, QiNiuAccount qiNiuAccount) {

        if (qiNiuAccount == null || qiNiuAccount.isEmpty()) {
            return Constant.QINIU_ACCOUNT_NULL;
        }

        Configuration cfg = new Configuration(Zone.autoZone());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);


        Auth auth = Auth.create(qiNiuAccount.getAccessKey(), qiNiuAccount.getSecretKey());
        String upToken = auth.uploadToken(qiNiuAccount.getBucket(), key);
        try {
            Response response = uploadManager.put(file, key, upToken);
            System.out.println(response.bodyString());
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            long expireInSeconds = 3600 * 24 * 365 * 50;//50年有效期 可以自定义链接过期时间
            return auth.privateDownloadUrl(qiNiuAccount.getCdn() + putRet.key, expireInSeconds);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(ex.error());
            try {
                System.err.println(ex.code() + " :  " + r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return ex.code() + "";
        }
    }

    public String getToken(String accessKey, String secretKey, String bucket, String key) {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket, key);
    }
}
