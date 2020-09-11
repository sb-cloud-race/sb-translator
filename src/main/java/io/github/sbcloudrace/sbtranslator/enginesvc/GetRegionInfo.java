package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.RegionInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class GetRegionInfo {

    @RequestMapping(value = "/getregioninfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public RegionInfo getRegionInfo() {
        RegionInfo regionInfo = new RegionInfo();
        regionInfo.setCountdownProposalInMilliseconds(3000);
        regionInfo.setDirectConnectTimeoutInMilliseconds(1000);
        regionInfo.setDropOutTimeInMilliseconds(15000);
        regionInfo.setEventLoadTimeoutInMilliseconds(30000);
        regionInfo.setHeartbeatIntervalInMilliseconds(1000);
        regionInfo.setUdpRelayBandwidthInBps(9600);
        regionInfo.setUdpRelayTimeoutInMilliseconds(60000);
        return regionInfo;
    }
}
