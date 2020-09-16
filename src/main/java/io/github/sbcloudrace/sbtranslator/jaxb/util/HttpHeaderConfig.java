package io.github.sbcloudrace.sbtranslator.jaxb.util;

import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import lombok.AllArgsConstructor;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@AllArgsConstructor
public class HttpHeaderConfig implements Filter {

    private final SbSessionServiceProxy sbSessionServiceProxy;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Response response = (Response) servletResponse;
        Request request = (Request) servletRequest;
        response.addHeader("Connection", "close");
        sbSessionServiceProxy.keepAlive(request.getHeader("securityToken"));
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
    }
}
