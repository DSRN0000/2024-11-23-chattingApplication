package com.ll.chatting.domian.chat.chatRoom.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
    /**
     * 번호, 이름, 날짜, 수정날짜
     */
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String name;

}
