package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArbitrationPacket;
import io.github.sbcloudrace.sbtranslator.jaxb.http.DragEventResult;
import io.github.sbcloudrace.sbtranslator.jaxb.http.EventResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/event")
public class Event {

    @RequestMapping(value = "/launched", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void launched() {
    }

    @RequestMapping(value = "/arbitration", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public EventResult arbitration(@RequestBody ArbitrationPacket arbitrationPacket) {
        return new EventResult();
    }
}
