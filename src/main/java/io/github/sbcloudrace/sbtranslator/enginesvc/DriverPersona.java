package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersona;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersonaServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/DriverPersona")
@AllArgsConstructor
public class DriverPersona {

    private final SbPersonaServiceProxy sbPersonaServiceProxy;

    @RequestMapping(value = "/GetExpLevelPointsMap", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfInt getExpLevelPointsMap() {
        ArrayOfInt arrayOfInt = new ArrayOfInt();
        arrayOfInt.getInt().add(100);
        arrayOfInt.getInt().add(975);
        arrayOfInt.getInt().add(2025);
        arrayOfInt.getInt().add(3625);
        arrayOfInt.getInt().add(5875);
        arrayOfInt.getInt().add(8875);
        arrayOfInt.getInt().add(12725);
        arrayOfInt.getInt().add(17525);
        arrayOfInt.getInt().add(23375);
        arrayOfInt.getInt().add(30375);
        arrayOfInt.getInt().add(39375);
        arrayOfInt.getInt().add(50575);
        arrayOfInt.getInt().add(64175);
        arrayOfInt.getInt().add(80375);
        arrayOfInt.getInt().add(99375);
        arrayOfInt.getInt().add(121375);
        arrayOfInt.getInt().add(146575);
        arrayOfInt.getInt().add(175175);
        arrayOfInt.getInt().add(207375);
        arrayOfInt.getInt().add(243375);
        arrayOfInt.getInt().add(283375);
        arrayOfInt.getInt().add(327575);
        arrayOfInt.getInt().add(376175);
        arrayOfInt.getInt().add(429375);
        arrayOfInt.getInt().add(487375);
        arrayOfInt.getInt().add(550375);
        arrayOfInt.getInt().add(618575);
        arrayOfInt.getInt().add(692175);
        arrayOfInt.getInt().add(771375);
        arrayOfInt.getInt().add(856375);
        arrayOfInt.getInt().add(950875);
        arrayOfInt.getInt().add(1055275);
        arrayOfInt.getInt().add(1169975);
        arrayOfInt.getInt().add(1295375);
        arrayOfInt.getInt().add(1431875);
        arrayOfInt.getInt().add(1579875);
        arrayOfInt.getInt().add(1739775);
        arrayOfInt.getInt().add(1911975);
        arrayOfInt.getInt().add(2096875);
        arrayOfInt.getInt().add(2294875);
        arrayOfInt.getInt().add(2506375);
        arrayOfInt.getInt().add(2731775);
        arrayOfInt.getInt().add(2971475);
        arrayOfInt.getInt().add(3225875);
        arrayOfInt.getInt().add(3495375);
        arrayOfInt.getInt().add(3780375);
        arrayOfInt.getInt().add(4081275);
        arrayOfInt.getInt().add(4398475);
        arrayOfInt.getInt().add(4732375);
        arrayOfInt.getInt().add(5083375);
        arrayOfInt.getInt().add(5481355);
        arrayOfInt.getInt().add(5898805);
        arrayOfInt.getInt().add(6336165);
        arrayOfInt.getInt().add(6793875);
        arrayOfInt.getInt().add(7272375);
        arrayOfInt.getInt().add(7772105);
        arrayOfInt.getInt().add(8293505);
        arrayOfInt.getInt().add(8837015);
        arrayOfInt.getInt().add(9403075);
        arrayOfInt.getInt().add(9992125);
        return arrayOfInt;
    }

    @RequestMapping(value = "/GetPersonaBaseFromList", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void getPersonaBaseFromList() {
    }

    @RequestMapping(value = "/UpdatePersonaPresence", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void updatePersonaPresence() {
    }

    @RequestMapping(value = "/GetPersonaInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ProfileData getPersonaInfo(
            @RequestHeader("userId") Long userId,
            @RequestHeader("securityToken") String securityToken,
            @RequestParam("personaId") Long personaId) {
        // TODO get data from microservice sb-persona by personaId to fill ProfileData object
        SbPersona sbPersona = sbPersonaServiceProxy.getPersonaById(personaId);
        ProfileData profileData = new ProfileData();
        profileData.setName("SPRING");//sbPersona.getName();
        profileData.setCash(0);
        profileData.setIconIndex(0);
        profileData.setPersonaId(100L);
        profileData.setLevel(3);
        profileData.setBadges(new ArrayOfBadgePacket());
        profileData.setMotto("THERE'S NO END, UNTIL WE SAY SO!");
        profileData.setPercentToLevel(0);
        profileData.setRating(0);
        profileData.setRep(0);
        profileData.setRepAtCurrentLevel(0);
        profileData.setScore(0);
        return profileData;
    }

    @RequestMapping(value = "/GetPersonaPresenceByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public PersonaPresence GetPersonaPresenceByName() {
        return new PersonaPresence();
    }

    @RequestMapping(value = "/ReserveName", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfString reserveName() {
        ArrayOfString arrayOfString = new ArrayOfString();
        arrayOfString.getString().add("NONE");
        return arrayOfString;
    }

    @RequestMapping(value = "/DeletePersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String deletePersona() {
        return "<long>0</long>";
    }

}
