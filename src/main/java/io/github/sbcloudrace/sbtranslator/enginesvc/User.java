package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.GetPermanentSessionData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UserInfo;
import io.github.sbcloudrace.sbtranslator.jaxb.util.UnauthorizedException;
import io.github.sbcloudrace.sbtranslator.sbopenfireapi.SbOpenfireServiceProxy;
import io.github.sbcloudrace.sbtranslator.sbsession.SbSessionServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
@AllArgsConstructor
public class User {

    private final SbSessionServiceProxy userSessionServiceProxy;

    private final SbOpenfireServiceProxy sbOpenfireServiceProxy;

    @RequestMapping(value = "/GetPermanentSession", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserInfo getPermanentSession(
            @RequestHeader("userId") Long userId,
            @RequestHeader("securityToken") String securityToken,
            @RequestBody GetPermanentSessionData permanentSessionData
    ) {
        UserInfo userInfo = new UserInfo();
        userInfo.setDefaultPersonaIdx(0);

        ArrayOfProfileData arrayOfProfileData = new ArrayOfProfileData();
        ProfileData profileData = new ProfileData();
        profileData.setName("SPRING");
        profileData.setCash(733550D);
        profileData.setIconIndex(26);
        profileData.setPersonaId(100);
        profileData.setLevel(3);
        arrayOfProfileData.getProfileData().add(profileData);
        userInfo.setPersonas(arrayOfProfileData);

        io.github.sbcloudrace.sbtranslator.jaxb.http.User user = new io.github.sbcloudrace.sbtranslator.jaxb.http.User();
        user.setUserId(userId);
        userInfo.setUser(user);
        String permanentToken = userSessionServiceProxy.createPermanentSession(userId, securityToken);
        if (permanentToken == null || permanentToken.isEmpty()) {
            throw new UnauthorizedException();
        }
        userInfo.getUser().setSecurityToken(permanentToken);
        sbOpenfireServiceProxy.createAllPersonasXmpp(userId, permanentToken);
        return userInfo;
    }

    @RequestMapping(value = "/SecureLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogout() {
    }

    @RequestMapping(value = "/SecureLoginPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLoginPersona() {
    }

    @RequestMapping(value = "/SecureLogoutPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogoutPersona() {
    }

}
