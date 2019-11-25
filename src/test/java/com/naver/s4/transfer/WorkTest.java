package com.naver.s4.transfer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.naver.s4.TestAbstractCase;

public class WorkTest extends TestAbstractCase {

	@Inject
	private Work work;
	
	
	@Test
	public void test() {
		work.goWork();
	}
	
	//@Test
	public void taxi() {
		work.goTaxi();
	}

}
