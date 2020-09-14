package io.github.sbcloudrace.sbtranslator.enginesvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
