/**
 * 
 */
package com.barclay.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.barclay.util.Utility;
import com.barclay.vo.TheaterRequestsVo;

/**
 * @author mchav
 * This class is a JUnit test for the Utility().parseTheaterRequests() method
 */
public class ParseTheaterRequestsTest {

	@Test
	public void test() {
		try{
			TheaterRequestsVo theaterRequestsVo = new Utility().parseTheaterRequests();
			assertTrue(theaterRequestsVo.getRequestList().size()>0);
		}catch(Exception e){
			e.printStackTrace();
			fail("An error occurred: " + e.getMessage());
		}
	}

}
