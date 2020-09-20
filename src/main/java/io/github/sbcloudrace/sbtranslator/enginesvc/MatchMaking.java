package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.SecurityChallenge;
import io.github.sbcloudrace.sbtranslator.jaxb.http.SessionInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matchmaking")
public class MatchMaking {

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

}
