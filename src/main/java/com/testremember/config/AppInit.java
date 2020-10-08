package com.testremember.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 *  Сервлет, Класс для инициализации проекта.
 */
public final class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected final Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    @Override
    protected final Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { Config.class };
    }

    @Override
    protected final String[] getServletMappings() {
        return new String[]{"/"};
    }

}
