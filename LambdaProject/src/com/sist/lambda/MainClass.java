package com.sist.lambda;
/*
 *     람다식
 *       1. 익명 함수 (함수명이 없다)
 *       2. 메서드를 값처럼 전달
 *       3. 코드 간결화
 *       4. 함수형 프로그램 스타일
 *       5. 기본 문법
 *          (매개변수)->{실행문}
 *       6. 타입 생략 가능
 *          (int a) X
 *          (a)
 *          매개변수 => (a)->a
 *          한줄수행   {return a+1} ==> a+1
 *          ex) (a,b)->a+b
 *          
 *          member->
 *       7. 인터페이스 / 클래스 => 메서드가 1개인 경우에만 적용
 */
public class MainClass {
	public static void main(String[] args) {
		// 쓰레드
//		Runnable r=new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Thread 실행");
//			}
//		};
		Runnable r=()->System.out.println("Thread 실행");
		new Thread(r).start();
	}
}
