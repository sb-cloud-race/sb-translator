package io.github.sbcloudrace.sbtranslator.sbpersona;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "sb-persona", url = "localhost:8501", path = "/sb-persona")
public interface SbPersonaServiceProxy {

    //http://localhost:8501/sb-persona/sbpersonas/100
   SbPersona getPersonaById();
}
