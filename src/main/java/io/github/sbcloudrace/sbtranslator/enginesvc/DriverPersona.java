package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import io.github.sbcloudrace.sbtranslator.sbopenfireapi.SbOpenfireServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersona;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersonaServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/DriverPersona")
@AllArgsConstructor
public class DriverPersona {

    private final SbPersonaServiceProxy sbPersonaServiceProxy;

    private final SbOpenfireServiceProxy sbOpenfireServiceProxy;

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
    public ArrayOfPersonaBase getPersonaBaseFromList(@RequestBody PersonaIdArray personaIdArray) {
        ArrayOfPersonaBase arrayOfPersonaBase = new ArrayOfPersonaBase();
        ArrayOfLong personaIds = personaIdArray.getPersonaIds();
        personaIds.getLong().forEach(personaId -> {
            SbPersona persona = sbPersonaServiceProxy.getPersona(personaId);
            PersonaBase personaBase = new PersonaBase();
            personaBase.setBadges(new ArrayOfBadgePacket());
            personaBase.setIconIndex(persona.getIconIndex());
            personaBase.setLevel(persona.getLevel());
            personaBase.setMotto("" + persona.getMotto());
            personaBase.setName(persona.getName());
            personaBase.setPresence(2);
            personaBase.setPersonaId(persona.getPersonaId());
            personaBase.setScore(5);
            personaBase.setUserId(persona.getUserId());
            arrayOfPersonaBase.getPersonaBase().add(personaBase);
        });
        return arrayOfPersonaBase;
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
        SbPersona sbPersona = sbPersonaServiceProxy.getPersona(personaId);
        ProfileData profileData = new ProfileData();
        BeanUtils.copyProperties(sbPersona, profileData);
        profileData.setBadges(new ArrayOfBadgePacket());
        profileData.setMotto("");
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
//        arrayOfString.getString().add("NONE");
        return arrayOfString;
    }

    @RequestMapping(value = "/DeletePersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String deletePersona(@RequestParam("personaId") Long personaId) {
        sbPersonaServiceProxy.deletePersona(personaId);
        return "<long>0</long>";
    }

    //POST /soapbox/Engine.svc/DriverPersona/CreatePersona?userId=3&name=JOE&iconIndex=0&clan=1&clanIcon=clanIcon HTTP/1.1\r\n
    @RequestMapping(value = "/CreatePersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ProfileData createPersona(@RequestHeader("securityToken") String securityToken,
                                     @RequestHeader("userId") Long userId,
                                     @RequestParam("name") String name,
                                     @RequestParam("iconIndex") Integer iconIndex) {
        SbPersona sbPersona = new SbPersona();
        sbPersona.setName(name);
        sbPersona.setIconIndex(iconIndex);
        sbPersona.setUserId(userId);
        sbPersona.setLevel(60);
        SbPersona persona = sbPersonaServiceProxy.createPersona(sbPersona);
        ProfileData profileData = new ProfileData();
        BeanUtils.copyProperties(persona, profileData);
        List<Long> personaIds = new ArrayList<>();
        personaIds.add(persona.getPersonaId());
        sbOpenfireServiceProxy.createAllPersonasXmpp(personaIds, securityToken.substring(0, 16));
        return profileData;
    }

    @RequestMapping(value = "/UpdateStatusMessage", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void updateStatusMessage() {
    }

}
