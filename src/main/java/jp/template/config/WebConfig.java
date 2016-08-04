package jp.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;

import jp.template.component.CustomHandlerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}

	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**") // �K�p�Ώۂ̃p�X(�p�^�[��)���w�肷��
				.excludePathPatterns("/static/**","/webjars/**"); // ���O����p�X(�p�^�[��)���w�肷��
	}

	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.resourceChain(false) // ������WebJarsResourceResolver���L���������
				.addResolver(new GzipResourceResolver());
	}

}
