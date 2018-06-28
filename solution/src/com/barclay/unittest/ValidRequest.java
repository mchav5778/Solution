package com.barclay.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.barclay.util.Utility;

/**
 * This class is to run JUnit tests on the Utility().validRequest() method.  
 * @author mchav
 *
 */

public class ValidRequest {

	@Test
	public void test() {
		assertTrue(new Utility().validRequest("Smith 2"));
		assertTrue(new Utility().validRequest("Jones 5"));
	}

}
