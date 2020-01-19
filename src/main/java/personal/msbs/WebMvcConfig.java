package personal.msbs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ling
 * 开启跨源支持
 * 以往使用的WebMvcConfigurerAdapter在新的版本中已经要被取消掉
 * 使用继承推荐的WebMvcConfigurationSupport类会导致因版本问题而警告
 * 故这里选择实现WebMvcConfigurer接口
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedOrigins("*");
    }
}
