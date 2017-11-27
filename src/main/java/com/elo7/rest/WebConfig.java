package com.elo7.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.elo7.rest.infra.versioning.VersionRequestMappingHandlerMapping;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Value("${server.contextPath}")
	private String basePath;

	@Override
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new VersionRequestMappingHandlerMapping(basePath);
		handlerMapping.setOrder(0);
		handlerMapping.setInterceptors(getInterceptors());
		return handlerMapping;
	}
}
