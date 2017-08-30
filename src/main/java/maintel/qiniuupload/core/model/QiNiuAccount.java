package maintel.qiniuupload.core.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Maintel
 * @version V1.0
 * @Title:
 * @Package maintel.bootstarptest.core.model
 * @Description: 七牛云账号信息
 * @date 2017/8/18 17:01
 */
@Configuration
@ConfigurationProperties(prefix = "qiniu.config")
@PropertySource(value = "file:qiniu.properties")
@Component
public class QiNiuAccount {

    /**
     * 私有订制 将这里的数据填写完成就可以了
     */

    public String accessKey;
    public String secretKey;
    public String cdn;   // cdn格式务必为 http://xxx.xx/
    public String bucket;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (accessKey == null || accessKey.equals("") ||
                secretKey == null || secretKey.equals("") ||
                cdn == null || cdn.equals("") ||
                bucket == null || bucket.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
