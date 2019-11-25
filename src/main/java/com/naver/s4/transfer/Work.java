package com.naver.s4.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {

	@Inject
	private Transfer transfer;
	
	
	public void goWork() {
		transfer.getBus("samsung");
		transfer.getSubWay("kakao");
	}

	public void goTaxi() {
		transfer.taxi();
	}
}

