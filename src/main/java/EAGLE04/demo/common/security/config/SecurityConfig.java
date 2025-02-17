package EAGLE04.demo.common.security.config;

import EAGLE04.demo.common.security.domain.JwtManager;
import EAGLE04.demo.common.security.domain.JwtResolver;
import EAGLE04.demo.common.exception.auth.JwtAccessDeniedHandler;
import EAGLE04.demo.common.exception.auth.JwtAuthenticationPoint;
import EAGLE04.demo.common.security.filter.JwtAuthenticationFilter;
import EAGLE04.demo.common.security.service.CustomOauth2UserService;
import EAGLE04.demo.common.security.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtManager jwtManager;
    private final JwtResolver jwtResolver;
    private final MemberDetailService memberDetailService;
    private final JwtAuthenticationPoint jwtAuthenticationPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CustomOauth2UserService customOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .exceptionHandling(exceptions -> {
                    exceptions.authenticationEntryPoint(jwtAuthenticationPoint);
                    exceptions.accessDeniedHandler(jwtAccessDeniedHandler);
                })
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .authorizationEndpoint(authorization -> authorization
//                                .baseUri("/oauth2/authorization"))
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(customOauth2UserService))
//                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                        .requestMatchers(HttpMethod.GET, "/login", "/oauth2/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login/**", "/login").permitAll()
                        .anyRequest().authenticated()
                );

        // jwt filter 설정
        http.addFilterBefore(
                new JwtAuthenticationFilter(jwtManager, jwtResolver, memberDetailService),
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("https://eagle-04-fe.vercel.app/", "http://localhost:5173"));
        configuration.setAllowedMethods(
                Arrays.asList("HEAD", "POST", "GET", "DELETE", "PUT", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(
                Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setMaxAge(3600L);
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/docs/api-doc.html")
                .requestMatchers("/favicon.*", "/*/icon-*")
                .requestMatchers(
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/v3/api-docs",
                        "/api-docs/**",
                        "/api-docs","/error",
                        "/static/**", "/resources/**",
                        "*.jpeg", "*.jpg", "*.png", "*.gif", "*.svg", "*.ico")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
