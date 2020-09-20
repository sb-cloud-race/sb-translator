package io.github.sbcloudrace.sbtranslator.sbopenfireapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "SB-OPENFIRE-API", path = "/sb-openfire-api")
public interface SbOpenfireServiceProxy {

    @RequestMapping(value = "/users/{password}", method = RequestMethod.PUT)
    void createAllPersonasXmpp(@RequestBody List<Long> personaIds,
                               @PathVariable String password);

}
