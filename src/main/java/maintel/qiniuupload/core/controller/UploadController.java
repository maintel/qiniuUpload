package maintel.qiniuupload.core.controller;

import maintel.qiniuupload.core.Constant;
import maintel.qiniuupload.core.QiNiuErrorCode;
import maintel.qiniuupload.core.model.AjaxResponse;
import maintel.qiniuupload.core.model.QiNiuAccount;
import maintel.qiniuupload.core.utils.qiniu.QiNiuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 上传文件
 *
 * @author Maintel
 * @create 2017-08-18 0:26
 **/
@Controller
public class UploadController {
    // 接受方法一
//    @RequestMapping("/upload")
//    @ResponseBody
//    public Test upload(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, Object> json = new HashMap<String, Object>();
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        Map map = multipartRequest.getFileMap();
//        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
//            Object obj = i.next();
//            MultipartFile multipartFile = (MultipartFile) map.get(obj);
//            System.out.println(multipartFile.getOriginalFilename());  //文件全名
//        }
//        return new Test("123456");
//    }

    @Autowired
    QiNiuAccount qiNiuAccount;

    @RequestMapping("/upload")
    @ResponseBody
    public AjaxResponse upload(@RequestParam("multipartFile") MultipartFile[] multipartFiles, HttpSession httpSession) {
        // name="multipartFile"  @RequestParam("multipartFile")   要和input标签中的name保持一致
        String url;
        AjaxResponse response = new AjaxResponse();
        for (MultipartFile multipartFile :
                multipartFiles) {
            try {
                url = QiNiuUtil.upload(multipartFile.getBytes(), multipartFile.getOriginalFilename(), qiNiuAccount);
                if (!url.contains(qiNiuAccount.getCdn())) {
                    response.setError(QiNiuErrorCode.getMsgByCode(url));
                } else {
                    response.setRetCode("0000");
                }
                response.setData(url);
                return response;
            } catch (Exception e) {
                e.printStackTrace();
                response.setError(QiNiuErrorCode.getMsgByCode(""));

            }
        }
        return response;
    }
}
