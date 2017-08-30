package maintel.qiniuupload.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @author Maintel
 * @create 2017-08-17 23:07
 **/
@Controller
public class IndexController {


    @RequestMapping("/")
    public String home() {
        return "upload";
    }  //私有化首页改为上传页

    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "upload";
    }

}
