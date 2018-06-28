package com.barclay.unittest;

import static org.junit.Assert.*;
import com.barclay.util.Utility;

import org.junit.Test;
/**
 * This class is to run JUnit tests on the Utility().validRow() method.  
 * @author mchav
 *
 */
public class ValidRowTest {

	@Test
	public void test() {
		assertTrue(new Utility().validRow("123 123 123"));
	}

}
