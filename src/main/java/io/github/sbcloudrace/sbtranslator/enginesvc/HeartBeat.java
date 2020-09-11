package io.github.sbcloudrace.sbtranslator.enginesvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HeartBeat {

    @RequestMapping(value = "/heartbeat", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public io.github.sbcloudrace.sbtranslator.jaxb.http.HeartBeat heartBeat() {
        io.github.sbcloudrace.sbtranslator.jaxb.http.HeartBeat heartBeat =
                new io.github.sbcloudrace.sbtranslator.jaxb.http.HeartBeat();
        heartBeat.setEnabledBitField(0);
        heartBeat.setMetagameFlags(2);
        return heartBeat;
    }
}
