package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들 활성화 시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()// h2-console 화면 사용하기 위해서 해당 옵션 disable
                .and()
                .authorizeRequests()// URL별 권한 관리 설정 옵션의 시작점. 이게 있어야 antMachers 사용 가능
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()// permitAll: 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // User권한 있는 사람만
                .anyRequest().authenticated()// 나머지 URL의 경우에는 로그인한 사용자만
                .and()
                .logout()
                .logoutSuccessUrl("/")// 로그아웃 성공시 /로 이동
                .and()
                .oauth2Login()// OAuth 2 로그인 기능에 대한 설정의 진입점
                .userInfoEndpoint()// OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                .userService(customOAuth2UserService);// 소셜 로그인 성공 후 후속 조치 진행할 UserService의 구현체 등록
    }
}