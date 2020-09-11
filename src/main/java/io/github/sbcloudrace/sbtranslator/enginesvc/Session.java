package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfChatRoom;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ChatRoom;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ChatServer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Session")
public class Session {

    @RequestMapping(value = "/GetChatInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ChatServer getChatInfo() {
        ChatServer chatServer = new ChatServer();
        chatServer.setIp("127.0.0.1");
        chatServer.setPort(5222);
        chatServer.setPrefix("sbrw");
        chatServer.setRooms(getAllChatRoom());
        return chatServer;
    }

    private ArrayOfChatRoom getAllChatRoom() {
        ArrayOfChatRoom arrayOfChatRoom = new ArrayOfChatRoom();
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setChannelCount(1);
        chatRoom.setLongName("TXT_CHAT_LANG_ENGLISH");
        chatRoom.setShortName("EN");
        arrayOfChatRoom.getChatRoom().add(chatRoom);
        return arrayOfChatRoom;
    }
}
