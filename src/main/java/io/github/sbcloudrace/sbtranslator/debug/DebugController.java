package io.github.sbcloudrace.sbtranslator.debug;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * to use this, start with -Dserver.servlet.context-path="/debug"
 * soapbox offline xml files must be inside resources/debug
 */

@Controller
@RequestMapping("/Engine.svc")
public class DebugController {

    @RequestMapping(value = "/**", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    String allRequests(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Connection", "close");

        String categoryName = request.getParameter("categoryName");
        if (categoryName != null && "STORE_POWERUPS".equals(categoryName)) {
            System.out.println(categoryName);
            return readFile(request.getRequestURI().substring(1).concat("_").concat(categoryName).concat(".xml"));
        }

        System.out.println(request.getMethod() + " -> " + request.getRequestURL() + " ? " + request.getQueryString());

        return readFile(request.getRequestURI().substring(1).concat(".xml"));
    }

    public String readFile(String resourcePath) {
        Resource resource = new ClassPathResource(resourcePath);
        try (InputStream inputStream = resource.getInputStream()) {
            try (Reader reader = new InputStreamReader(inputStream, UTF_8)) {
                return FileCopyUtils.copyToString(reader);
            }
        } catch (IOException e) {
            System.out.println(resourcePath + " not found");
//            throw new UncheckedIOException(e);
            return "";
        }
    }

}
