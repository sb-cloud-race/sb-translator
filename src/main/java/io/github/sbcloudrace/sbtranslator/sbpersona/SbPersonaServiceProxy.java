package io.github.sbcloudrace.sbtranslator.sbpersona;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sb-persona", url = "localhost:8501", path = "/sb-persona")
public interface SbPersonaServiceProxy {

    //http://localhost:8501/sb-persona/sbpersonas/100
    @RequestMapping(value = "/sbpersonas/{personaId}", method = RequestMethod.GET)
    SbPersona getPersonaById(@PathVariable Long personaId);
}
