package com.elo7.rest.infra.versioning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows you to choose a endpoint version.
 * 
 * Valid formats:
 * 
 * - Version("v1")
 * - Version("v2")
 * - Version("v1.3")
 * 
 * @author mario
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
	
	/**
	 * Supported version
	 */
	String value() default "v1"; 

}
