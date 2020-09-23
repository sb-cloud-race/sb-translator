package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbxmppcli.SbXmppCliServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matchmaking")
@AllArgsConstructor
public class MatchMaking {

    private final SbXmppCliServiceProxy sbXmppCliServiceProxy;

    private final SbSessionServiceProxy sbSessionServiceProxy;

    @RequestMapping(value = "/joinqueueracenow", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void joinqueueracenow() {
    }

    @RequestMapping(value = "/leavequeue", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void leavequeue() {
    }

    @ResponseBody
    @RequestMapping(value = "/launchevent/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public SessionInfo launchEvent(@RequestHeader("securityToken") String securityToken, @PathVariable("eventId") int eventId) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setEventId(eventId);
        sessionInfo.setSessionId(1L);
        return sessionInfo;
    }

    @RequestMapping(value = "/makeprivatelobby/{eventId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void makeprivatelobby(@PathVariable("eventId") Integer eventId) {
    }

    @RequestMapping(value = "/joinqueueevent/{eventId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void joinqueueevent(@RequestHeader("securityToken") String securityToken,
                               @PathVariable("eventId") Integer eventId) {
        Long activePersonaId = sbSessionServiceProxy.getActivePersonaId(securityToken);
        Long lobbyId = 1L;
        sbXmppCliServiceProxy.lobbySendJoinEvent(lobbyId, eventId, activePersonaId);
    }

    @RequestMapping(value = "/acceptinvite", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public LobbyInfo acceptinvite(@RequestHeader("securityToken") String securityToken,
                                  @RequestParam("lobbyInviteId") Long lobbyInviteId) {
        Long activePersonaId = sbSessionServiceProxy.getActivePersonaId(securityToken);
        LobbyCountdown lobbyCountdown = new LobbyCountdown();
        lobbyCountdown.setLobbyId(lobbyInviteId);
        lobbyCountdown.setEventId(504);
        lobbyCountdown.setLobbyCountdownInMilliseconds(50000);
        lobbyCountdown.setLobbyStuckDurationInMilliseconds(10000);

        ArrayOfLobbyEntrantInfo arrayOfLobbyEntrantInfo = new ArrayOfLobbyEntrantInfo();
        List<LobbyEntrantInfo> lobbyEntrantInfoList = arrayOfLobbyEntrantInfo.getLobbyEntrantInfo();
        LobbyEntrantInfo lobbyEntrantInfo = new LobbyEntrantInfo();
        lobbyEntrantInfo.setPersonaId(activePersonaId);
        lobbyEntrantInfo.setLevel(60);
        lobbyEntrantInfo.setGridIndex(0);
        lobbyEntrantInfo.setHeat(1);
        lobbyEntrantInfo.setState(LobbyEntrantState.IN_LOBBY);
        lobbyEntrantInfoList.add(lobbyEntrantInfo);

        LobbyInfo lobbyInfo = new LobbyInfo();
        lobbyInfo.setCountdown(lobbyCountdown);
        lobbyInfo.setEntrants(arrayOfLobbyEntrantInfo);
        lobbyInfo.setEventId(504);
        lobbyInfo.setLobbyId(lobbyInviteId);
        lobbyInfo.setLobbyInviteId(lobbyInviteId);
        return lobbyInfo;
    }

    @RequestMapping(value = "/declineinvite", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void declineinvite() {
    }

    @RequestMapping(value = "/leavelobby", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void leavelobby() {
    }
}
