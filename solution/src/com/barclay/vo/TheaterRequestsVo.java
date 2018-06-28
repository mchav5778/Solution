/**
 * 
 */
package com.barclay.vo;

import java.util.ArrayList;

/**
 * @author mchav
 *
 * This class represent the list of requests for the theater sitting program
 */
public class TheaterRequestsVo {
	//ArrayList of RequestVo objects
	ArrayList<RequestVo> requestList = new ArrayList<RequestVo>();

	/**
	 * @return the requestList
	 */
	public ArrayList<RequestVo> getRequestList() {
		return requestList;
	}

	/**
	 * @param requestList the requestList to set
	 */
	public void setRequestList(ArrayList<RequestVo> requestList) {
		this.requestList = requestList;
	}
}
