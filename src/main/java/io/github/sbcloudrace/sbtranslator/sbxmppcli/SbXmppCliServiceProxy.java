package io.github.sbcloudrace.sbtranslator.sbxmppcli;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SB-XMPP-CLI", path = "/sb-xmpp-cli")
public interface SbXmppCliServiceProxy {

    @RequestMapping(value = "/powerups/activated/{personaId}/{targetId}/{powerupHash}/{receivers}",
            method = RequestMethod.PUT)
    void powerupActivated(@PathVariable("personaId") Long personaId,
                          @PathVariable("targetId") Long targetId,
                          @PathVariable("powerupHash") Integer powerupHash,
                          @PathVariable("receivers") String receivers);

    @RequestMapping(value = "/lobby/send-join-event/{lobbyInviteId}/{eventId}/{personaId}",
                method = RequestMethod.PUT)
    void lobbySendJoinEvent(@PathVariable("lobbyInviteId") Long lobbyId,
                            @PathVariable("eventId") Integer eventId,
                            @PathVariable("personaId") Long personaId);
}
