package io.github.sbcloudrace.sbtranslator.enginesvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

@Controller
@RequestMapping
public class SystemInfo {

    @RequestMapping(value = "/systeminfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public io.github.sbcloudrace.sbtranslator.jaxb.http.SystemInfo systemInfo() {
        io.github.sbcloudrace.sbtranslator.jaxb.http.SystemInfo systemInfo =
                new io.github.sbcloudrace.sbtranslator.jaxb.http.SystemInfo();
        systemInfo.setBranch("production");
        systemInfo.setChangeList("620384");
        systemInfo.setClientVersion("637");
        systemInfo.setClientVersionCheck(true);
        systemInfo.setDeployed("08/20/2013 11:24:40");
        systemInfo.setEntitlementsToDownload(true);
        systemInfo.setForcePermanentSession(true);
        systemInfo.setJidPrepender("sbrw");
        systemInfo.setLauncherServiceUrl("http://127.0.0.1");
        systemInfo.setNucleusNamespace("sbrw-live");
        systemInfo.setNucleusNamespaceWeb("sbr_web");
        systemInfo.setPersonaCacheTimeout(900);
        systemInfo.setPortalDomain("soapboxraceworld.com");
        systemInfo.setPortalStoreFailurePage("soapboxraceworld.com/fail");
        systemInfo.setPortalTimeOut("6000");
        systemInfo.setShardName("CORE");
        GregorianCalendar c = new GregorianCalendar();
        try {
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            systemInfo.setTime(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        systemInfo.setVersion("1599");
        return systemInfo;
    }
}
