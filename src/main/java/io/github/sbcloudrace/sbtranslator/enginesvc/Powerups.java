package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbxmppcli.SbXmppCliServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/powerups")
@AllArgsConstructor
public class Powerups {

    private final SbXmppCliServiceProxy sbXmppCliServiceProxy;

    private final SbSessionServiceProxy sbSessionServiceProxy;

    @RequestMapping(value = "/activated/{powerupHash}", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void activated(@RequestHeader("securityToken") String securityToken,
                          @PathVariable Integer powerupHash,
                          @RequestParam("targetId") Long targetId,
                          @RequestParam("receivers") String receivers) {
        Long activePersonaId = sbSessionServiceProxy.activePersonaId(securityToken);
        sbXmppCliServiceProxy.activated(activePersonaId, targetId, powerupHash, receivers);
    }
}
