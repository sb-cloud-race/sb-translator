package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.HardwareInfo;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UserSettings;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Reporting")
public class Reporting {

    @RequestMapping(value = "/SendHardwareInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void sendHardwareInfo(@RequestBody HardwareInfo hardwareInfo) {
    }

    @RequestMapping(value = "/SendUserSettings", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void sendUserSettings(@RequestBody UserSettings userSettings) {
    }
}
