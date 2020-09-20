package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfEventDefinition;
import io.github.sbcloudrace.sbtranslator.jaxb.http.EventDefinition;
import io.github.sbcloudrace.sbtranslator.jaxb.http.EventsPacket;
import io.github.sbcloudrace.sbtranslator.jaxb.http.TreasureHuntEventSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Controller
@RequestMapping("/events")
public class Events {

    @RequestMapping(value = "/availableatlevel", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public EventsPacket availableAtLevel() {
        EventsPacket eventsPacket = new EventsPacket();
        eventsPacket.setEvents(new ArrayOfEventDefinition());

        EventDefinition eventDefinition = new EventDefinition();
        eventDefinition.setEventId(43);
        eventsPacket.getEvents().getEventDefinition().add(eventDefinition);

        EventDefinition eventDefinition2 = new EventDefinition();
        eventDefinition2.setEventId(504);
        eventsPacket.getEvents().getEventDefinition().add(eventDefinition2);
        return eventsPacket;
    }

    @RequestMapping(value = "/gettreasurehunteventsession", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TreasureHuntEventSession getTreasureHuntEventSession() {
        TreasureHuntEventSession treasureHuntEventSession = new TreasureHuntEventSession();
        return treasureHuntEventSession;
    }

    @GET
    @RequestMapping(value = "/instancedaccolades", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void instancedAccolades(@RequestParam("eventSessionId") Long eventSessionId) {
    }
}
