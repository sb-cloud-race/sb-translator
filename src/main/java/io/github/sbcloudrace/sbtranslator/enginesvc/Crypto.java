package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ClientServerCryptoTicket;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/crypto")
public class Crypto {

    @RequestMapping(value = "/cryptoticket", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ClientServerCryptoTicket cryptoticket() {
        ClientServerCryptoTicket clientServerCryptoTicket = new ClientServerCryptoTicket();
        clientServerCryptoTicket.setCryptoTicket("CgsMDQAAAGYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        clientServerCryptoTicket.setSessionKey("AAAAAAAAAAAAAAAAAAAAAA==");
        clientServerCryptoTicket.setTicketIv("AAAAAAAAAAAAAAAAAAAAAA==");
        return clientServerCryptoTicket;
    }
}
