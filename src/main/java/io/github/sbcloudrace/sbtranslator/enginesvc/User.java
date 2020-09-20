package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.GetPermanentSessionData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UserInfo;
import io.github.sbcloudrace.sbtranslator.jaxb.util.UnauthorizedException;
import io.github.sbcloudrace.sbtranslator.sbopenfireapi.SbOpenfireServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersona;
import io.github.sbcloudrace.sbtranslator.sbpersona.SbPersonaServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/User")
@AllArgsConstructor
public class User {

    private final SbSessionServiceProxy sbSessionServiceProxy;

    private final SbOpenfireServiceProxy sbOpenfireServiceProxy;

    private final SbPersonaServiceProxy sbPersonaServiceProxy;

    @RequestMapping(value = "/GetPermanentSession", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserInfo getPermanentSession(
            @RequestHeader("userId") Long userId,
            @RequestHeader("securityToken") String securityToken,
            @RequestBody GetPermanentSessionData permanentSessionData) {
        UserInfo userInfo = new UserInfo();
        userInfo.setDefaultPersonaIdx(0);

        List<Long> personasIds = new ArrayList<>();
        List<SbPersona> listSbPersona = sbPersonaServiceProxy.getPersonaByUserId(userId);
        ArrayOfProfileData arrayOfProfileData = new ArrayOfProfileData();
        listSbPersona.forEach(sbPersona -> {
            ProfileData profileData = new ProfileData();
            BeanUtils.copyProperties(sbPersona, profileData);
            arrayOfProfileData.getProfileData().add(profileData);
            personasIds.add(sbPersona.getPersonaId());
        });
        userInfo.setPersonas(arrayOfProfileData);


        io.github.sbcloudrace.sbtranslator.jaxb.http.User user = new io.github.sbcloudrace.sbtranslator.jaxb.http.User();
        user.setUserId(userId);
        userInfo.setUser(user);
        String permanentToken = sbSessionServiceProxy.createPermanentSession(userId, securityToken);
        if (permanentToken == null || permanentToken.isEmpty()) {
            throw new UnauthorizedException();
        }
        userInfo.getUser().setSecurityToken(permanentToken);
        sbOpenfireServiceProxy.createAllPersonasXmpp(personasIds, permanentToken.substring(0, 16));
        return userInfo;
    }

    @RequestMapping(value = "/SecureLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogout() {
    }

    @RequestMapping(value = "/SecureLoginPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLoginPersona(@RequestHeader("securityToken") String securityToken,
                                   @RequestParam("personaId") Long personaId) {
        sbSessionServiceProxy.setActivePersona(securityToken, personaId);
    }

    @RequestMapping(value = "/SecureLogoutPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogoutPersona() {
    }

}
