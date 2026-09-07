package com.sist.web.manager;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
/*
 *     kafka
 *       => 서버와 서버로 대량의 이벤트/메세지 => 안정적으로 전달하는 분산
 *     예)
 *        사용자 A가 주문
 *            |
 *        주문 서버
 *            |
 *         주문 완료 이벤트
 *            |
 *         Kafka
 *            |
 *      ----------------------
 *      |       |            |
 *    재고서비스  결제서비스      알림서비스
 *    
 *    => Producer
 *          |
 *          | - 메세지 전송
 *        Topic
 *          |
 *        Partition
 *          |
 *        Consumer
 *        -------
 *          Producer
 *            |
 *          Topic
 *            |
 *     -----------------
 *     |       |       |
 *    P1      P2      P2
 *    ------------------
 *         |
 *       Consumer => Kafka로부터 메세지를 읽어서 처리
 */
@Component
public class KafkaManager {
	@KafkaListener(
		topics="test-topic",
		groupId="test-group"
	)
	public void receive(String message) {
		System.out.println("==================");
		System.out.println("Kafka 메세지 수신:"+message);
		System.out.println("==================");
	}
}
