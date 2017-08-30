package maintel.qiniuupload.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 验证是否设置了账号
 *
 * @author Maintel
 * @create 2017-08-19 23:17
 **/
//@Configuration // 在私有化中取消拦截
public class WebLoginConfig extends WebMvcConfigurerAdapter {

    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getSecurityInterceptor());

        registration.excludePathPatterns("/");
        registration.excludePathPatterns("/setAccount");

        registration.addPathPatterns("/**");
    }
}
