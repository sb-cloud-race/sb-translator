package io.github.sbcloudrace.sbtranslator.sbsession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SB-SESSION", path = "/sb-session")
public interface SbSessionServiceProxy {

    @RequestMapping(value = "/user/{userId}/{token}", method = RequestMethod.GET)
    String createPermanentSession(@PathVariable("userId") long userId, @PathVariable("token") String token);

    @RequestMapping(value = "/tokensession/keepalive/{securityToken}", method = RequestMethod.PUT)
    String keepAlive(@PathVariable("securityToken") String token);

    @RequestMapping(value = "/tokensession/active-persona-id/{securityToken}/{personaId}", method = RequestMethod.PUT)
    void putActivePersona(@PathVariable("securityToken") String securityToken, @PathVariable("personaId") Long personaId);

    @RequestMapping(value = "/tokensession/active-persona-id/{securityToken}", method = RequestMethod.GET)
    Long getActivePersonaId(@PathVariable("securityToken") String securityToken);

    @RequestMapping(value = "/lobby/event/{eventId}", method = RequestMethod.POST)
    Long createLobby(@PathVariable("eventId") Integer eventId);

    @RequestMapping(value = "/lobby/{lobbyId}", method = RequestMethod.GET)
    SbSessionLobby getLobbyById(@PathVariable("lobbyId") Long lobbyId);

    @RequestMapping(value = "/lobby/event/{eventId}", method = RequestMethod.GET)
    SbSessionLobby getActiveLobbyByEventId(@PathVariable("eventId") Integer eventId);

}
