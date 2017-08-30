package maintel.qiniuupload.core.controller;

import maintel.qiniuupload.core.Constant;
import maintel.qiniuupload.core.model.AjaxResponse;
import maintel.qiniuupload.core.model.QiNiuAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Maintel
 * @version V1.0
 * @Title:
 * @Package maintel.bootstarptest.core.controller
 * @Description: 设置七牛云账号
 * @date 2017/8/18 16:49
 */
@Controller
public class AccountSetController {

    @RequestMapping(value = "/setAccount", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse setAccount(@ModelAttribute QiNiuAccount qiNiuAccount, HttpSession session) {
        AjaxResponse response = new AjaxResponse();
        if (!qiNiuAccount.isEmpty()) {
//            QiNiuUtil.getInstance().setQiNiuAccount(qiNiuAccount);
            //在session中设置标志表示已经设置了账号
            session.setAttribute(Constant.IS_SET_KEY, true);
            session.setAttribute(Constant.QINIU_CONFIG, qiNiuAccount);
            System.out.println(session.getAttribute(Constant.IS_SET_KEY));
            response.setRetCode("0000");
            return response;
        }
        return response;
    }
}
