package com.sist.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.vo.ChatMessage;

import lombok.RequiredArgsConstructor;
/*
 *     STOMP (Simple Text Oriented Messaging Protocol)
 *        실시간 알림 : 회원 / 예약 / 댓글
 *        메세지브로커 <=> 클라이언트 간 통신을 도와줌
 *     | 규칙을 정해서 사용
 *       => 내부 프로토콜 (약속)
 *         => 서버 == 클라이언트만 알수 있게 만듬
 *         ----------------
 *         LOGIN => 100, LOGOUT => 200
 *     | 동작 흐름
 *       connect : websocket 연결 => stomp로 요청
 *                 let socket=new SockJS('/chat-ws)
 *                                       --------- EndPoint
 *                 stompClient=Stomp.over(socket)
 *       send : 클라이언트가 특정 목적지 (topic) => 메세지 발행 (public)
 *       subscribe : 클라이언트에서 발행된 데이터를 읽기
 *       disconnect : 연결 종료
 *       
 *       목적지 : topic, queue
 *       -------------------
 *       
 *     | pinia에서 이용
 *       => 처리하는 기능 => store 안에 존재
 *       
 *     SockJS : 전화선
 *     Stomp : 통신 담당 => 송수신 => URI
 */

@Controller
@RequiredArgsConstructor
public class ChatController {
	// 1:1 채팅
	private final SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage chat_pub(ChatMessage message) {
		message.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return message;
	}
	
	@MessageMapping("/chat.private")
	// 알림 / 실시간 상담
	public ChatMessage chat_pri(ChatMessage message) {
		message.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		System.out.println("My:"+message.getSender());
		System.out.println("You:"+message.getReceiver());
		System.out.println("Msg:"+message.getMessage());
		messagingTemplate.convertAndSend(
			"/queue/private/"+message.getReceiver(),
			message
		);
		return message;
	}
	@GetMapping("/chat")
	public String chat_page() {
		return "chat";
	}
}
