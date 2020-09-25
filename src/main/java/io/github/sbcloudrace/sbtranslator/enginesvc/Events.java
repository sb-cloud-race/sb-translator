package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;

@Controller
@RequestMapping("/events")
public class Events {

    @RequestMapping(value = "/availableatlevel", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public EventsPacket availableAtLevel() {
        EventsPacket eventsPacket = new EventsPacket();
        eventsPacket.setEvents(new ArrayOfEventDefinition());

//        EventDefinition eventDefinition = new EventDefinition();
//        eventDefinition.setEventId(43);
//        eventsPacket.getEvents().getEventDefinition().add(eventDefinition);

        eventsPacket.getEvents().getEventDefinition().add(getEventDefinitionWithId());

//        EventDefinition eventDefinition3 = new EventDefinition();
//        eventDefinition3.setEventId(385);
//        eventsPacket.getEvents().getEventDefinition().add(eventDefinition3);
        return eventsPacket;
    }

    private EventDefinition getEventDefinitionWithId() {
        EventDefinition eventDefinition = new EventDefinition();
        eventDefinition.setCarClassHash(607077938);
        eventDefinition.setCoins(0);
        Vector3 vector3 = new Vector3();
        vector3.setX(0);
        vector3.setY(0);
        vector3.setZ(0);
        eventDefinition.setEngagePoint(vector3);
        eventDefinition.setEventId(504);
        eventDefinition.setEventLocalization(953954317);
        eventDefinition.setEventModeDescriptionLocalization(1298130000);
        eventDefinition.setEventModeIcon("GameModeIcon_Drag");
        eventDefinition.setEventModeId(19);
        eventDefinition.setEventModeLocalization(1990101845);
        eventDefinition.setIsEnabled(true);
        eventDefinition.setIsLocked(false);
        eventDefinition.setLaps(0);
        eventDefinition.setLength(0);
        eventDefinition.setMaxClassRating(999);
        eventDefinition.setMaxEntrants(4);
        eventDefinition.setMaxLevel(60);
        eventDefinition.setMinClassRating(0);
        eventDefinition.setMinEntrants(2);
        eventDefinition.setMinLevel(2);
        eventDefinition.setRegionLocalization(0);
        eventDefinition.setRewardModes(new ArrayOfInt());
        eventDefinition.setTimeLimit(0);
        eventDefinition.setTrackLayoutMap("NeonCrossroads_128");
        eventDefinition.setTrackLocalization(0);
        return eventDefinition;
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
