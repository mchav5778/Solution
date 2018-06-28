package com.barclay.main;

import java.util.ArrayList;

import com.barclay.util.Utility;
import com.barclay.vo.RequestVo;
import com.barclay.vo.TheaterRequestsVo;
import com.barclay.vo.TheaterVo;

/**
 * @author mchav
 *
 */
public class TheaterSeating {

	/**
	 * @param args
	 *            This is the main class and method for my solution to the
	 *            theater seating problem.
	 * 
	 *            In the main method, we will only instantiate a new
	 *            TheatreSeating class and call its start() method.
	 */
	public static void main(String[] args) {
		try {
			TheaterSeating myTheaterSeating = new TheaterSeating();
			myTheaterSeating.start();
		} catch (Exception e) {
			// If there is an exception, we will print its stack trace.
			e.printStackTrace();
		}

	}

	/**
	 * The start method contains the main flow of the program
	 */
	private void start() {
		// First we will parse the theater layout by calling the
		// parseTheaterLayout function
		TheaterVo theaterVo = new Utility().parseTheaterLayout();
		
		//Then we parse the theater requests
		TheaterRequestsVo teatherRequests = new Utility().parseTheaterRequests();

		//After that, we start processing the requests and producing the output
		ArrayList<RequestVo> requestList = teatherRequests.getRequestList(); 
		for(RequestVo requestVo : requestList){
			//We get the name of the requester
			String name = requestVo.getName();
			//We get the number of tickets requested
			int requestedTickets = requestVo.getRequestedTickets();
			//We call the assignTickets from the theaterVo object to assign the tickets and collect the result 
			String result = theaterVo.assignTickets(requestedTickets);
			//We display the name and result of the assignment
            System.out.println(name + " " + result);		
		}
	}
}
