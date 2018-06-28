/**
 * 
 */
package com.barclay.vo;

import java.util.ArrayList;

/**
 * @author mchav This class contains the list of available rows and sections for
 *         the theater seating program
 */
public class TheaterVo {
	// The ArrayList object with the available seats per row and section
	public ArrayList<ArrayList<Integer>> theaterLayout = new ArrayList<ArrayList<Integer>>();

	/**
	 * @return the theaterLayout
	 */
	public ArrayList<ArrayList<Integer>> getTheaterLayout() {
		return theaterLayout;
	}

	/**
	 * @param theaterLayout
	 *            the theaterLayout to set
	 */
	public void setTheaterLayout(ArrayList<ArrayList<Integer>> theaterLayout) {
		this.theaterLayout = theaterLayout;
	}

	/**
	 * This function iterates over the list of rows and sections to determine
	 * the number of available spaces in the whole theater
	 * 
	 * @return the number of available spaces in the whole theater
	 */
	public int getTotalAvailableSpace() {
		int totalAvailableSpace = 0;
		for (ArrayList<Integer> rowLayout : theaterLayout) {
			for (Integer sectionCapacity : rowLayout) {
				totalAvailableSpace += sectionCapacity;
			}
		}
		return totalAvailableSpace;
	}

	/**
	 * This method validates if there is enough space in the theater to handle the number of 
	 * requested tickets it also validates if the party can be seated in the same row and section
	 * or if we need to split a party into different sections.  
	 * @param requestedTickets - the number of requested tickets
	 * @return a string containing one of the following messages:
	 * "Sorry, we can't handle your party." if there is no space in the theater to handle a party
	 * "Call to split party." if a party can not be seated in the same row and section
	 * "Row x Section y" with the row and section number where the party was assigned.
	 */
	public String assignTickets(int requestedTickets) {
		String result = "";
		try{
			if(requestedTickets>getTotalAvailableSpace()){
				return "Sorry, we can't handle your party.";
			}
			else{
				ArrayList<ArrayList<Integer>> tmpTheaterLayout = new ArrayList<ArrayList<Integer>>();
				boolean partyHasBeenAssigned = false;
				int row =1;
				int section = 1;
				for(ArrayList<Integer> rowLayout : theaterLayout){
					ArrayList<Integer> tmpRowLayout = new ArrayList<Integer>();
					for(Integer sectionCapacity : rowLayout){
						if(!partyHasBeenAssigned && requestedTickets<=sectionCapacity){
							sectionCapacity-=requestedTickets;
							result = "Row " + row + " Section " + section;
							partyHasBeenAssigned = true;
						}
						tmpRowLayout.add(sectionCapacity);
						section++;
					}
					tmpTheaterLayout.add(tmpRowLayout);
					section=1;
					row++;
				}
				if(partyHasBeenAssigned){
					theaterLayout = tmpTheaterLayout;
					return result;
				}else{
					return "Call to split party.";
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	public void displayTheater(){
		int row =1;
		int section = 1;
		for(ArrayList<Integer> rowLayout : theaterLayout){
			for(Integer sectionCapacity : rowLayout){
				System.out.print("row:"+row+",section:"+section+",capacity="+sectionCapacity+" ");
				section++;
			}
			System.out.println("");
			section=1;
			row++;
		}
	}
}
