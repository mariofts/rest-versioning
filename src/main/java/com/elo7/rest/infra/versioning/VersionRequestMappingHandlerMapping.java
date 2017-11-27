package com.elo7.rest.infra.versioning;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping{
	
	private String basePath;
	
	public VersionRequestMappingHandlerMapping(String basePath) {
		this.basePath = basePath;
	}

	@Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        Version typeAnnotation = AnnotationUtils.findAnnotation(handlerType, Version.class);
        return createCondition(typeAnnotation);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        Version methodAnnotation = AnnotationUtils.findAnnotation(method, Version.class);
        return createCondition(methodAnnotation);
    }
    
    @Override
    protected RequestMappingInfo createRequestMappingInfo(RequestMapping requestMapping,
    		RequestCondition<?> customCondition) {
    	if(customCondition == null) 
    		return super.createRequestMappingInfo(requestMapping, customCondition);
    	
		String[] paths = getPathWithVersion(requestMapping, customCondition);
		
		return RequestMappingInfo
				.paths(paths)
				.methods(requestMapping.method())
				.params(requestMapping.params())
				.headers(requestMapping.headers())
				.consumes(requestMapping.consumes())
				.produces(requestMapping.produces())
				.mappingName(requestMapping.name())
				.customCondition(customCondition)
				.build();
    }

	private String[] getPathWithVersion(RequestMapping requestMapping, RequestCondition<?> customCondition) {
		String[] paths = resolveEmbeddedValuesInPatterns(requestMapping.path());
		VersionRequestCondition condition = (VersionRequestCondition) customCondition;
		
		for (int i = 0; i < paths.length; i++) {
			paths[i] = condition.getVersionPath() + paths[i]; 
		}
		return paths;
	}

    private RequestCondition<?> createCondition(Version version) {
        return (version != null) ? 
        		new VersionRequestCondition(version, basePath) 
        		: null;
    }

}
