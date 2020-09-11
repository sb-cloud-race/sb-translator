package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfUdpRelayInfo;
import io.github.sbcloudrace.sbtranslator.jaxb.http.UdpRelayInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class GetRebroadcasters {

    @RequestMapping(value = "/getrebroadcasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfUdpRelayInfo getRebroadcasters() {
        ArrayOfUdpRelayInfo arrayOfUdpRelayInfo = new ArrayOfUdpRelayInfo();
        UdpRelayInfo udpRelayInfo = new UdpRelayInfo();
        udpRelayInfo.setHost("127.0.0.1");
        udpRelayInfo.setPort(9999);
        arrayOfUdpRelayInfo.getUdpRelayInfo().add(udpRelayInfo);
        return arrayOfUdpRelayInfo;
    }
}
