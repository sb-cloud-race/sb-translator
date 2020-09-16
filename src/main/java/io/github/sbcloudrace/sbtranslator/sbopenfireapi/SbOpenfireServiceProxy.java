package io.github.sbcloudrace.sbtranslator.sbopenfireapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sb-openfire-api", url = "localhost:8101/sb-openfire-api")
public interface SbOpenfireServiceProxy {

    @RequestMapping(value = "/users/{userId}/{securityToken}", method = RequestMethod.PUT)
    void createAllPersonasXmpp(@PathVariable Long userId, @PathVariable String securityToken);
}
