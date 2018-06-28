package com.barclay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.barclay.vo.RequestVo;
import com.barclay.vo.TheaterRequestsVo;
import com.barclay.vo.TheaterVo;

/**
 * @author mchav . This class contains the utility methods used to solve the
 *         theater seating problem
 */
public class Utility {

	/**
	 * This function validates a row layout string to see if it contains
	 * positive integer numbers separated by one space using the regular
	 * expression (\d+\s{1})+ meaning the string should only contain digits
	 * followed by one space
	 * 
	 * @param row
	 *            The row layout to validate
	 * 
	 * @return true if the string contains a valid row layout, false otherwise
	 */
	public boolean validRow(String row) {
		if (row != null) {
			return (row.trim() + " ").matches("(\\d+\\s{1})+");
		} else {
			return false;
		}
	}

    /**
     * The parseTheaterLayout() method parses a theater layout from System.in .
     * The program makes the following assumptions: 
     * 1.-The front of the theater is next to the first row entered. 
     * 2.-The numbers entered between the spaces in each row, represent the 
     *    number of available spaces in that section. 
     * 3.-The first number entered at the beginning of the row represents the 
     *    number available spaces in section 1, the next number entered 
     *    represent the number of available spaces in section 2 and so on.
     *    For example, for the provided sample layout:
     *    
     *    6 6
     *    3 5 5 3
     *    4 6 6 4
     *    2 8 8 2
     *    6 6 
     *
     *    The program will create the following layout:
     *    
     *                                               Theater Front
     *         ---------------------------------------------                
     *         |  row 1, section 1   |  row 1, section 2   |
     *         | available spaces: 6 | available spaces: 6 |
     *         -----------------------------------------------------------------------------------------
     *         |  row 2, section 1   |  row 2, section 2   |  row 2, section 3   |  row 2, section 4   |
     *         | available spaces: 3 | available spaces: 5 | available spaces: 5 | available spaces: 3 |
     *         -----------------------------------------------------------------------------------------
     *         |  row 3, section 1   |  row 3, section 2   |  row 3, section 3   |  row 3, section 4   |
     *         | available spaces: 4 | available spaces: 6 | available spaces: 6 | available spaces: 4 |
     *         -----------------------------------------------------------------------------------------
     *         |  row 4, section 1   |  row 4, section 2   |  row 4, section 3   |  row 4, section 4   |
     *         | available spaces: 2 | available spaces: 8 | available spaces: 8 | available spaces: 2 |
     *         -----------------------------------------------------------------------------------------
     *         |  row 5, section 1   |  row 5, section 2   |
     *         | available spaces: 6 | available spaces: 6 |
     *         ---------------------------------------------
     * 
     * @return a TheaterVo object with the parsed theater layout
     */
	public TheaterVo parseTheaterLayout() {
		TheaterVo theaterVo = new TheaterVo();
		ArrayList<ArrayList<Integer>> theaterLayout = new ArrayList<ArrayList<Integer>>();
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			String rowInputLayout = "";
			do {
				ArrayList<Integer> rowLayout = new ArrayList<Integer>();
				// We read the rowInputLayout string
				rowInputLayout = buffer.readLine();
				// We check if the length of the entered string is greater than
				// zero
				if (rowInputLayout.length() > 0) {
					// We check if it contains valid row information
					if (validRow(rowInputLayout)) {
						// if it is we use the StringTokenizer class to retrieve
						// the capacities of each section
						StringTokenizer rowTokenizer = new StringTokenizer(rowInputLayout, " ");
						do {
							Integer sectionAvailableSpace = Integer.parseInt(rowTokenizer.nextToken());
							rowLayout.add(sectionAvailableSpace);
						} while (rowTokenizer.hasMoreTokens());
					} else {
						// else, we exit the program providing the user with a
						// description of the problem
						exit("Invalid row layout entered");
					}
					theaterLayout.add(rowLayout);
				}
				// we will repeat while the length of the entered string is
				// greater then zero
			} while (rowInputLayout.length() > 0);

			theaterVo.setTheaterLayout(theaterLayout);

		} catch (Exception e) {
			// If there is an exception, we will print its stack trace.
			e.printStackTrace();
		}

		return theaterVo;
	}

	/**
	 * This method exits the program, it receives a string containing the cause
	 * for which the program is exiting and it prints it to the default output
	 * before calling Sistem.exit(-1)
	 */
	public void exit(String s) {
		System.out.println(s);
		System.exit(-1);
	}

	/**
	 * This method parses the theater requests from System.in
	 * 
	 * @return a TheaterRequestsVo object with the theater requests ordered by
	 *         the place in which they were entered
	 */
	public TheaterRequestsVo parseTheaterRequests() {
		TheaterRequestsVo theaterRequests = new TheaterRequestsVo();
		ArrayList<RequestVo> requestList = new ArrayList<RequestVo>();
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			String requestString = "";
			do {

				// We read the requestString
				requestString = buffer.readLine();
				// We check if the length of the entered string is greater than
				// zero
				if (requestString.length() > 0) {
					// We check if it contains valid request information
					if (validRequest(requestString)) {
						// if it is, we use the StringTokenizer class to
						// retrieve the name and the number of requested tickets
						StringTokenizer requestTokenizer = new StringTokenizer(requestString, " ");
						RequestVo requestVo = new RequestVo();
						// the first token is the name of the requester
						requestVo.setName(requestTokenizer.nextToken());
						// the second token is the number of requested tickets
						requestVo.setRequestedTickets(Integer.parseInt(requestTokenizer.nextToken()));
						requestList.add(requestVo);
					} else {
						// else, we exit the program providing the user with a
						// description of the problem
						exit("Invalid request entered");
					}
				}
				// we will repeat while the length of the entered string is
				// greater then zero
			} while (requestString.length() > 0);

			theaterRequests.setRequestList(requestList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return theaterRequests;
	}

	/**
	 * This function validates a row layout string to see if it contains
	 * positive integer numbers separated by one space using the regular
	 * expression \w+\s{1}\d+ meaning the string should only contain one word
	 * followed followed by one space and a number
	 * 
	 * @param row
	 *            The row layout to validate
	 * 
	 * @return true if the string contains a valid row layout, false otherwise
	 */
	public boolean validRequest(String request) {
		if (request != null) {
			return request.trim().matches("\\w+\\s{1}\\d+");
		} else {
			return false;
		}
	}

}
