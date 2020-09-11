package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.FraudConfig;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/security")
public class Security {

    @RequestMapping(value = "/fraudConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public FraudConfig fraudConfig(@RequestHeader("userId") Long userId) {
        FraudConfig fraudConfig = new FraudConfig();
        fraudConfig.setEnabledBitField(12);
        fraudConfig.setGameFileFreq(1000000);
        fraudConfig.setModuleFreq(360000);
        fraudConfig.setStartUpFreq(1000000);
        fraudConfig.setUserID(userId);
        return fraudConfig;
    }
}
