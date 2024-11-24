package com.ll.chatting.domian.chat.chatMessage.controller;

import com.ll.chatting.domian.chat.chatMessage.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/chat/rooms/{chatRoomId}/messages")
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatMessageController {
    private final Map<Integer, List<ChatMessage>> chatMessagesByRoomId = new HashMap<>() {{
        put(1, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(1)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(1)
                            .writerName("김철수")
                            .content("풋살하실 분 계신가요?")
                            .build()
            );
            add(
                    ChatMessage
                            .builder()
                            .id(2)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(1)
                            .writerName("이영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
        put(2, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(3)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(2)
                            .writerName("박철수")
                            .content("농구하실 분 계신가요?")
                            .build()
            );
            add(
                    ChatMessage
                            .builder()
                            .id(4)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(2)
                            .writerName("김영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
        put(3, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(5)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(3)
                            .writerName("이철수")
                            .content("야구하실 분 계신가요?")
                            .build()
            );
            add(
                    ChatMessage
                            .builder()
                            .id(6)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(3)
                            .writerName("박영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
    }};
    @GetMapping
    public List<ChatMessage> getChatMessages(
            @PathVariable int chatRoomId
    ) {
        return chatMessagesByRoomId.getOrDefault(chatRoomId, List.of());
    }

    @AllArgsConstructor
    @Getter
    public static class ChatMessageWriteReqBody{
        private String writerName;
        private String content;
    }

    @PostMapping
    public ChatMessage writeChatMessage(
            @PathVariable int chatRoomId,
            @RequestBody ChatMessageWriteReqBody reqBody
    ) {
        return writeChatMessage(chatRoomId, reqBody.writerName, reqBody.content);
    }

    private ChatMessage writeChatMessage(
            int chatRoomId,
            String writerName,
            String content
    ) {
        List<ChatMessage> chatMessages = chatMessagesByRoomId.get(chatRoomId);
        if (chatMessages == null) {
            chatMessages = new ArrayList<>();
            chatMessagesByRoomId.put(chatRoomId, chatMessages);
        }
        ChatMessage chatMessage = ChatMessage
                .builder()
                .id(chatMessages.size() + 1)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .chatRoomId(chatRoomId)
                .writerName(writerName)
                .content(content)
                .build();
        chatMessages.add(chatMessage);
        return chatMessage;
    }
}