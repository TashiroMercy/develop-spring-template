package jp.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.template.service.UserDetailsServiceImpl;
/**
 * Spring Security�ݒ�N���X.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // �Z�L�����e�B�ݒ�𖳎����郊�N�G�X�g�ݒ�
        // �ÓI���\�[�X(images�Acss�Ajavascript)�ɑ΂���A�N�Z�X�̓Z�L�����e�B�ݒ�𖳎�����
        web.ignoring().antMatchers(
        					"/static/**",
                            "/images/**",
                            "/css/**",
                            "/javascript/**",
                            "/webjars/**",
                            "/test");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        // �F�̐ݒ�
        http.authorizeRequests()
            .antMatchers("/", "/login","test").permitAll() // �S���[�U�[�A�N�Z�X����
            .anyRequest().authenticated();  // ����ȊO�͑S�ĔF�ؖ����̏ꍇ�A�N�Z�X�s����

        // ���O�C���ݒ�
        http.formLogin()
            .loginProcessingUrl("/login")   // �F�؏����̃p�X
            .loginPage("/login")            // ���O�C���t�H�[���̃p�X
//            .failureHandler(new SampleAuthenticationFailureHandler())       // �F�؎��s���ɌĂ΂��n���h���N���X
            .failureUrl("/login-error")
            .defaultSuccessUrl("/menu")     // �F�ؐ������̑J�ڐ�
            .usernameParameter("login_id").passwordParameter("login_password")  // ���[�U�[���A�p�X���[�h�̃p�����[�^��
            .and();

        // ���O�A�E�g�ݒ�
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))       // ���O�A�E�g�����̃p�X
            .logoutSuccessUrl("/login");                                        // ���O�A�E�g�������̃p�X
*/
    	
    	
    	
    	   http.authorizeRequests()
           // �A�N�Z�X�����̐ݒ�
           // static�f�B���N�g���ɂ���A'/css/','fonts','/js/'�͐����Ȃ�
           .antMatchers("/css/**", "/fonts/**", "/js/**","/test").permitAll()
           // '/admin/'�Ŏn�܂�URL�ɂ́A'ADMIN'���[���̂݃A�N�Z�X��
           //.antMatchers("/admin/**").hasRole("ADMIN")
           // ���͐����Ȃ�
           .anyRequest().authenticated()
         .and()
           // ���O�C�������̐ݒ�
           .formLogin()
             // ���O�C��������URL
             .loginPage("/login")
             .failureUrl("/login?error=authentication")
             .defaultSuccessUrl("/menu")
             // username�̃p�����^��
             .usernameParameter("username")
             // password�̃p�����^��
             .passwordParameter("password")
             
             .permitAll()
         .and()
           // ���O�A�E�g�����̐ݒ�
           .logout()
             // ���O�A�E�g������URL
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             // ���O�A�E�g�������̑J�ڐ�URL
             .logoutSuccessUrl("/login")
             // ���O�A�E�g���ɍ폜����N�b�L�[��
             .deleteCookies("JSESSIONID")
             // ���O�A�E�g���̃Z�b�V�����j����L����
             .invalidateHttpSession(true)
             .permitAll()
         ;
    }

    @Configuration
    protected static class AuthenticationConfiguration  extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        UserDetailsServiceImpl userDetailsService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            // �F�؂��郆�[�U�[��ݒ肷��
            auth.userDetailsService(userDetailsService)
            // ���͒l��bcrypt�Ńn�b�V���������l�Ńp�X���[�h�F�؂��s��
            //.passwordEncoder(new BCryptPasswordEncoder())
            ;

        }
    }
}
