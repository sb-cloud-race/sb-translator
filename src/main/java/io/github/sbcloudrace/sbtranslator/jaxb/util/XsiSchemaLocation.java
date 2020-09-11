package io.github.sbcloudrace.sbtranslator.jaxb.util;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface XsiSchemaLocation {

    public String schemaLocation();

}
