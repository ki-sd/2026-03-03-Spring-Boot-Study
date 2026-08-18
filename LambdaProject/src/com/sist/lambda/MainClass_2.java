package com.sist.lambda;

import java.util.List;

//  람다+컬렉션
/*
 *      for(String s:list){
 *      	System.out.println(s)
 *      }
 *      
 *      => list.forEach(s->System.out.println(s))
 */
public class MainClass_2 {
	public static void main(String[] args) {
		List<String> colors=List.of("blue","green","red","yellow","black");
		colors.forEach(s->System.out.println(s));
		
		// 주요 연산
		/*
		 *     중간 : filter , map , sort , distinct
		 *     최종 : forEach , collect , count
		 */
	}
}
