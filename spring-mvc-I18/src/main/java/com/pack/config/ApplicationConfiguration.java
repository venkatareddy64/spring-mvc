package com.pack.config;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.pack")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/test");
		dmds.setUsername("root");
		dmds.setPassword("system");
		return dmds;
	}
	@Bean
	public JdbcTemplate jTemplate()
	{
		return new JdbcTemplate(datasource());
	}
@Bean
public ViewResolver viewResolver() {
	InternalResourceViewResolver irvr=new InternalResourceViewResolver();
    irvr.setPrefix("/WEB-INF/views/");
    irvr.setSuffix(".jsp");
    return irvr;
    }
@Bean
public LocaleChangeInterceptor interceptor()
{
	LocaleChangeInterceptor changeInterceptor=new LocaleChangeInterceptor();
    changeInterceptor.setParamName("lang");
    return changeInterceptor;
    }
@Override
public void addInterceptors(InterceptorRegistry registry)
{
	registry.addInterceptor(interceptor());
}

@Bean
public SessionLocaleResolver localeResolver() {
	return new SessionLocaleResolver();
}
@Bean
public MessageSource messageSource()
{
ReloadableResourceBundleMessageSource rbms=new ReloadableResourceBundleMessageSource ();
rbms.setBasename("classpath:i18n");
return rbms;

}
}

