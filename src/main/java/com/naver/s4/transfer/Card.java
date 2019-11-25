package com.naver.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import oracle.net.aso.a;

@Component
public class Card {
	
	
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
	
	
	public void cash() {
		System.out.println("=== 현금지출 ===");
	}

}
