package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.GetPermanentSessionData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ProfileData;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class User {

    @RequestMapping(value = "/GetPermanentSession", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserInfo getPermanentSession(
            @RequestHeader("userId") Long userId,
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
        return userInfo;
    }

    @RequestMapping(value = "/SecureLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogout() {
    }

    @RequestMapping(value = "/SecureLoginPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLoginPersona(){
    }

    @RequestMapping(value = "/SecureLogoutPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void secureLogoutPersona(){
    }

}
