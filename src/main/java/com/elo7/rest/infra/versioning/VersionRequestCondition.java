package com.elo7.rest.infra.versioning;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.mvc.condition.RequestCondition;


public class VersionRequestCondition implements RequestCondition<VersionRequestCondition> {
	
	private String pattern;
	private String versionPath;
	
	public VersionRequestCondition(Version version, String basePath) {
		this.versionPath = "/" + version.value();
		this.pattern = basePath + versionPath + "/**";
	}
	
	public String getVersionPath() {
		return versionPath;
	}

	@Override
	public VersionRequestCondition combine(VersionRequestCondition other) {
		//TODO how to combine?
		return this;
	}

	@Override
	public VersionRequestCondition getMatchingCondition(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		boolean match = new AntPathMatcher().match(pattern, requestURI);
		return match ? this : null;
	}

	@Override
	public int compareTo(VersionRequestCondition other, HttpServletRequest request) {
		//TODO how to compare?
		return 0;
	}
}
