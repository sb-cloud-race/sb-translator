package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.EventsPacket;
import io.github.sbcloudrace.sbtranslator.jaxb.http.TreasureHuntEventSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/events")
public class Events {

    @RequestMapping(value = "/availableatlevel", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public EventsPacket availableAtLevel() {
        EventsPacket eventsPacket = new EventsPacket();
        return eventsPacket;
    }

    @RequestMapping(value = "/gettreasurehunteventsession", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TreasureHuntEventSession getTreasureHuntEventSession() {
        TreasureHuntEventSession treasureHuntEventSession = new TreasureHuntEventSession();
        return treasureHuntEventSession;
    }
}
