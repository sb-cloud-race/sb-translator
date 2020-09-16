package io.github.sbcloudrace.sbtranslator.jaxb.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.annotation.XmlRootElement;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "To show an example of a custom message")
@ResponseBody
@XmlRootElement
public class UnauthorizedException extends RuntimeException {
}