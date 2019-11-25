package com.naver.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Card {
	
	@Around("execution(* com.naver.s4.transfer.Transfer.get*(..))")
	public Object cardCheck(ProceedingJoinPoint join) {
		System.out.println("=== CARD in ===");
		Object obj = null;
		
		try {
			Object[] args = join.getArgs();
			
			for(Object object : args) {
				System.out.println(object);
			}
			
			obj = join.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("=== CARD out ===");
		
		return obj;
	}
	
	
	
	//@After("execution(* com.naver.s4.transfer.Transfer.taxi())")
	@AfterReturning("execution(* com.naver.s4.transfer.Transfer.taxi())")
	public void cash() {
		System.out.println("=== 현금지출 ===");
	}

}
