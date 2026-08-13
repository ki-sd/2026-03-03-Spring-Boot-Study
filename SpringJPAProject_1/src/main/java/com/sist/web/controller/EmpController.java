package com.sist.web.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.Emp;
import com.sist.web.repository.EmpJpqlRepository;
import com.sist.web.repository.EmpRepository;

import jakarta.persistence.EntityManager;

import java.util.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {
	private final EmpRepository eRepo;
	private final EmpJpqlRepository jRepo;
	private final EntityManager em;
	@GetMapping("/emp")
	public void emp() {
		String jpql="SELECT DISTINCT e.job FROM emp e";
		/*String jpql="SELECT e FROM Emp e "
	      +"ORDER BY e.sal DESC";
			List<Emp> list=em.createQuery(jpql,Emp.class)
	          .setMaxResults(3)
	          .getResultList();*/
//		Emp emp=eRepo.findByEmpno(7788);
//		List<Emp> list=eRepo.findByEnameStartsWith("A");
//		List<Emp> list=eRepo.findByEnameEndsWith("N");
//		List<Emp> list=eRepo.findByEnameContains("K");
//		List<Emp> list=eRepo.findByOrderBySalDesc();
//		List<Emp> list=eRepo.findTop3ByOrderBySalDesc();
//		List<Emp> list=eRepo.findByJobAndSalGreaterThanEqual("ANALYST", 1000);
//		List<Emp> list=eRepo.findByDeptDnameContains("인");
//		List<Emp> list=jRepo.empListData();
//		List<Emp> list=jRepo.empEnameFind("SCOTT");
//		List<Emp> list=jRepo.empEnameEndsLike("N");
//		List<Emp> list=jRepo.empLikeData("A");
//		List<Emp> list=jRepo.empGreater(1000);
//		List<Emp> list=jRepo.empDnameData("개발팀");
//		List<Emp> list=jRepo.empDnameContain("개");
//		List<Emp> list=jRepo.empTop3Data();
//		List<String> list=em.createQuery(jpql,String.class).getResultList();
		List<Integer> deptnos=List.of(10,20,30,40);
		List<Emp> list=jRepo.empDeptnoIn(deptnos);
		for(Emp emp:list) {
		System.out.println(emp.getEmpno()+" "+emp.getEname()+" "+emp.getJob()+" "+emp.getHiredate()+" "+emp.getSal());
		}
	}
}
