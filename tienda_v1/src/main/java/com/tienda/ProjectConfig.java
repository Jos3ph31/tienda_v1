package com.tienda;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import org.springframework.context.support.ResourceBundleMessageSource;import org.springframework.web.servlet.LocaleResolver;import org.springframework.web.servlet.config.annotation.InterceptorRegistry;import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class ProjectConfig implements WebMvcConfigurer {
    
    /*Los siguientes métodos son para incorporar el tema de internacionalización */
    /* localResolver se utiliza para crear una sesuón de cambio de idioma */ 
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.time");
        return slr;
    }
    
    /* localeChangeInterceptor se utiliza para crear un interceptor de idioma*/
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors (InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Bean ("messageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
