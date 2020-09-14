package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.SocialSettings;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class GetSocialSettings {

    @RequestMapping(value = "/getsocialsettings", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public SocialSettings getSocialSettings() {
        SocialSettings socialSettings = new SocialSettings();
        socialSettings.setAppearOffline(false);
        socialSettings.setDeclineGroupInvite(0);
        socialSettings.setDeclineIncommingFriendRequests(false);
        socialSettings.setDeclinePrivateInvite(0);
        socialSettings.setHideOfflineFriends(false);
        socialSettings.setShowNewsOnSignIn(false);
        socialSettings.setShowOnlyPlayersInSameChatChannel(false);
        return socialSettings;
    }
}
