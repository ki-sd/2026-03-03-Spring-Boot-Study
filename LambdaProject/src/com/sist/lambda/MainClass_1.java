package com.sist.lambda;
/*
 *     함수형 인터페이스
 *        => 람다식은 함수형 인터페이스만 사용가능
 *        => 추상메서드 1개만 존재
 *        => @FunctionalInterface 반드시 설정
 *           => 이 인터페이스는 람다전용임을 표시
 */
@FunctionalInterface
interface Calc{
	int sum(int a,int b);
}
public class MainClass_1 {
	public static void main(String[] args) {
		Calc c=(a,b)->a+b;
		System.out.println(c.sum(10,20));
	}
}
