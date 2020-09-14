package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfLevelGiftDefinition;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Gifts")
public class Gifts {

    @RequestMapping(value = "/GetAndTriggerAvailableLevelGifts", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfLevelGiftDefinition getAndTriggerAvailableLevelGifts() {
        return new ArrayOfLevelGiftDefinition();
    }

}
