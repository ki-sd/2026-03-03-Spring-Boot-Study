package com.sist.stream;
import java.util.*;
public class MainClass1 {
	public static void main(String[] args) {
		EmpDAO dao=new EmpDAO();
		List<EmpVO> list=dao.empAllData();
		list.stream()
			.sorted((a,b)->a.getEmpno()-b.getEmpno())
			.forEach(vo->System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getEname()+" "+vo.getSal()+" "+vo.getJob()+" "+vo.getHiredate().toString()));
		System.out.println("===== filter =====");
		list.stream()
			.filter(vo->vo.getSal()>=3000)
			.forEach(vo->System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getEname()+" "+vo.getSal()+" "+vo.getJob()+" "+vo.getHiredate().toString()));
		System.out.println("==================");
		list.stream()
			.filter(vo->vo.getEmpno()%2==0)
			.sorted((a,b)->a.getEmpno()-b.getEmpno())
			.forEach(vo->System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getEname()+" "+vo.getSal()+" "+vo.getJob()+" "+vo.getHiredate().toString()));
		System.out.println("===== sorted =====");
		list.stream()
			.sorted(Comparator.comparing(EmpVO::getSal))
			.forEach(vo->System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getEname()+" "+vo.getSal()+" "+vo.getJob()+" "+vo.getHiredate().toString()));
		System.out.println("====== DESC ======");
		list.stream()
			.sorted(Comparator.comparing(EmpVO::getSal).reversed())
			.forEach(vo->System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getEname()+" "+vo.getSal()+" "+vo.getJob()+" "+vo.getHiredate().toString()));
		System.out.println("===== 중복제거 (distinct) =====");
		List<String> kList=List.of("java","spring","html","css","javascript","html","css","vuejs");
		kList.stream()
			.distinct()
			.forEach(System.out::println);
		System.out.println("===== 통계 (reduce) =====");
		int total=list.stream()
					.map(EmpVO::getSal)
					.reduce(0, Integer::sum);
		System.out.println(total);
		System.out.println("===== 통계 (average) =====");
		double avg=list.stream()
					.mapToInt(EmpVO::getSal)
					.average()
					.orElse(0);
		System.out.println(avg);
	}
}
