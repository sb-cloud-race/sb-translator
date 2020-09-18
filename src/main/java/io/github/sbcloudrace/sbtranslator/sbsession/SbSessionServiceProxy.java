package io.github.sbcloudrace.sbtranslator.sbsession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "sb-session", url = "localhost:8001", path = "/sb-session")
public interface SbSessionServiceProxy {

    @RequestMapping(value = "/user/{userId}/{token}", method = RequestMethod.GET)
    String createPermanentSession(@PathVariable("userId") long userId, @PathVariable("token") String token);

    @RequestMapping(value = "/tokensession/keepalive/{securityToken}", method = RequestMethod.PUT)
    String keepAlive(@PathVariable("securityToken") String token);

    @RequestMapping(value = "/tokensession/active-persona-id/{securityToken}/{personaId}", method = RequestMethod.PUT)
    void setActivePersona(@PathVariable("securityToken") String securityToken, @PathVariable("personaId") Long personaId);
}
