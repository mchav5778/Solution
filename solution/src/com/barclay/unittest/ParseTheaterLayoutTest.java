package com.barclay.unittest;

import static org.junit.Assert.*;
import com.barclay.util.Utility;

import org.junit.Test;
/**
 * This class is to run JUnit tests on the Utility().parseTheaterLayout() method.  
 * @author mchav
 *
 */

public class ParseTheaterLayoutTest {

	@Test
	public void test() {
		assertTrue(new Utility().parseTheaterLayout().getTheaterLayout().size()>0);
	}

}
