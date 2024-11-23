package com.ll.chatting.domian.chat.chatRoom.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 창구역할
@RequestMapping("/api/v1/chat/rooms")
public class ApiV1ChatControllers {

    @GetMapping
    public String getChatRooms() {
        return "채팅방 목록";
    }
}
