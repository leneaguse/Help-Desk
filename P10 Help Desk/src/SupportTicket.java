//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (descriptive title of the program making use of this file)
// Files:           (a list of all source files used by that program)
// Course:          (course number, term, and year)
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
   * This class allows for new instances of SupportTickets to be created
   * Each support ticket has a priority that is associated with its message
   * length and order in the alphabet if two messages have the same length
   * 
   */
public class SupportTicket implements Comparable<SupportTicket> {
	private String message;
	
	/**
	   * Creates a new Support Ticket Instance with the message that's passed in
	   * @param message - the message that determines its priority
	   */
	public SupportTicket (String message) {
		this.message = message;
	}
	
	/**
	   * Returns the message of the SupportTicket instance
	   * @return message
	   * @throws NullPointerException when the String message argument is null.
	   */
	public String toString() {
		if (this.message == null) {
			throw new NullPointerException("Invalid message");
		}
		return this.message;
	}
	/**
	   * Returns the message of the SupportTicket instance
	   * @return message
	   */
	public String getMessage() {
		return this.message;
	}
	
	/**
	   * Compares two messages and determines which has a higher priority
	   * longer length = higher priority
	   * same length, alphabetic order is lower priority
	   * @param instance of SupportTicket
	   * @return int - -1 if its shorter in length
	   * 		 		1 if its longer in length
	   * 				> 0 if its farther in the alphabet
	   * 				< 0 if its earlier in the alphabet
	   * 				0 if theyre the same string
	   */
	@Override
	public int compareTo(SupportTicket arg0) {
		//if this instance message is larger than the argument node
		if (this.message.length() > arg0.getMessage().length()) {
			return 1;
		}
		// if this message is smaller than the argument node
		if (this.message.length() < arg0.getMessage().length()) {
			return -1;
		}
		//else compare it alphabetically
		int compared = this.message.compareTo(arg0.getMessage());
		return compared;
	}
	

}
