package EAGLE04.demo.common.config;

import EAGLE04.demo.common.annotation.AuthenticationMemberIdArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthenticationMemberIdArgumentResolver authenticationMemberIdArgumentResolver;

    public WebConfig(AuthenticationMemberIdArgumentResolver authenticationMemberIdArgumentResolver) {
        this.authenticationMemberIdArgumentResolver = authenticationMemberIdArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(0, authenticationMemberIdArgumentResolver); // 우선 순위를 높이기 위해 0번째에 추가
    }
}
