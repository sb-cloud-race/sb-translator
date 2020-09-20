package io.github.sbcloudrace.sbtranslator.sbpersona;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "SB-PERSONA", path = "/sb-persona")
public interface SbPersonaServiceProxy {

    @RequestMapping(value = "/sbpersonas/{personaId}", method = RequestMethod.GET)
    SbPersona getPersona(@PathVariable Long personaId);

    @RequestMapping(value = "/personasByUser/{userId}", method = RequestMethod.GET)
    List<SbPersona> getPersonasByUserId(@PathVariable Long userId);

    @RequestMapping(value = "/sbpersonas", method = RequestMethod.POST)
    SbPersona createPersona(@RequestBody SbPersona sbPersona);

    @RequestMapping(value = "/sbpersonas/{personaId}", method = RequestMethod.DELETE)
    void deletePersona(@PathVariable Long personaId);

}
