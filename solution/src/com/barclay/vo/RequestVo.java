/**
 * 
 */
package com.barclay.vo;

/**
 * @author mchav
 * This class represent a request for tieckts in the theater sitting program
 */
public class RequestVo {
	//Name of the requester
	public String name = "";
	//requested number of tickets, we initialize it to -1 by default. 
	public int requestedTickets = -1;

	@Override
	public String toString() {
		return "RequestVo [name=" + name + ", requestedTickets=" + requestedTickets + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the requestedTickets
	 */
	public int getRequestedTickets() {
		return requestedTickets;
	}
	/**
	 * @param requestedTickets the requestedTickets to set
	 */
	public void setRequestedTickets(int requestedTickets) {
		this.requestedTickets = requestedTickets;
	}
}
