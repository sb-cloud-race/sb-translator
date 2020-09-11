package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfLong;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfString;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UserSettings;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class GetUserSettings {

    @RequestMapping(value = "/getusersettings", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserSettings getUserSettingsGet(@RequestHeader("userId") Long userId) {
        UserSettings userSettings = new UserSettings();
        userSettings.setCarCacheAgeLimit(600);
        userSettings.setIsRaceNowEnabled(true);
        userSettings.setMaxCarCacheSize(250);
        userSettings.setMinRaceNowLevel(2);
        userSettings.setVoipAvailable(false);
        ArrayOfString arrayOfString = new ArrayOfString();
        arrayOfString.getString().add("SCENERY_GROUP_NORMAL");
        userSettings.setActivatedHolidaySceneryGroups(arrayOfString);
        ArrayOfLong arrayOfLong = new ArrayOfLong();
        arrayOfLong.getLong().add(0L);
        userSettings.setActiveHolidayIds(arrayOfLong);
        ArrayOfString arrayOfString2 = new ArrayOfString();
        arrayOfString2.getString().add("SCENERY_GROUP_NORMAL_DISABLE");
        userSettings.setDisactivatedHolidaySceneryGroups(arrayOfString2);
        userSettings.setFirstTimeLogin(false);
        userSettings.setMaxLevel(60);
        userSettings.setStarterPackApplied(false);
        userSettings.setUserId(userId);
        return userSettings;
    }
}
