package io.github.sbcloudrace.sbtranslator.jaxb.util;

import org.eclipse.jetty.server.Response;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class HttpHeaderConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Response response = (Response) servletResponse;
        response.addHeader("Connection", "close");
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
    }
}
