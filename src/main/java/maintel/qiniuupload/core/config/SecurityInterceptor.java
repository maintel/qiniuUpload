package maintel.qiniuupload.core.config;

import maintel.qiniuupload.core.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 未登录时过滤
 *
 * @author Maintel
 * @create 2017-08-19 23:19
 **/
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute(Constant.IS_SET_KEY) != null) {
                return true;
            }
        }
        response.sendRedirect("");

        return false;
    }
}
