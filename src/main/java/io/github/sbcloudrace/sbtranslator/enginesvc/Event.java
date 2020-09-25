package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/event")
@AllArgsConstructor
public class Event {

    private final SbSessionServiceProxy sbSessionServiceProxy;

    @RequestMapping(value = "/launched", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void launched() {
    }

    @RequestMapping(value = "/arbitration", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public EventResult arbitration(
            @RequestHeader("securityToken") String securityToken,
            @RequestBody ArbitrationPacket arbitrationPacket,
            @RequestParam("eventSessionId") Long eventSessionId) {
        return new EventResult();
    }

    @RequestMapping(value = "/bust", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public PursuitEventResult bust(
            @RequestHeader("securityToken") String securityToken,
            @RequestBody PursuitArbitrationPacket pursuitArbitrationPacket,
            @RequestParam("eventSessionId") Long eventSessionId) {
        PursuitEventResult pursuitEventResult = new PursuitEventResult();

        pursuitEventResult.setDurability(100);
        pursuitEventResult.setEventId(384);
        pursuitEventResult.setEventSessionId(eventSessionId);
        pursuitEventResult.setExitPath(ExitPath.EXIT_TO_FREEROAM);
        pursuitEventResult.setInviteLifetimeInMilliseconds(0);
        pursuitEventResult.setPersonaId(sbSessionServiceProxy.getActivePersonaId(securityToken));
        pursuitEventResult.setHeat(1F);

        return pursuitEventResult;
    }

    @RequestMapping(value = "/abort", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void abort() {
    }

}
