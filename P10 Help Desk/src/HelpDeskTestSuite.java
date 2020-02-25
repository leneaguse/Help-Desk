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
 * A class that tests the implementation of the methods used in Help Desk and
 * SupportTicket
 */
public class HelpDeskTestSuite extends HelpDesk {
	public HelpDeskTestSuite(int arraySize) {
		super(arraySize);
	}

	public static void main(String[] args) {
		//System.out.println(testCompareTo());
		//System.out.println(testAddNew());
		//System.out.println(testRemove());
		//System.out.println(testCheckNextTicket());
		//System.out.println(testSwap());
		System.out.println(testGetParentOf());
		//System.out.println(testGetRightChildOf());
		//System.out.println(testGetLeftChildOf());

	}

	/**
	 * Tests the implementation of compareTo and if the results are as expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testCompareTo() {
		// initialize parameters
		boolean test1 = false;
		SupportTicket newTicket1 = new SupportTicket("AAA");
		SupportTicket newTicket2 = new SupportTicket("ZZZ");
		SupportTicket newTicket3 = new SupportTicket("hello");
		// compare if the same length
		int compared = newTicket1.compareTo(newTicket2);
		// check if AAA is less than ZZZ
		if (compared < 0) {
			test1 = true;
		}
		// compare with different lengths
		compared = newTicket1.compareTo(newTicket3);
		// check if AAA is less than hello
		if (compared < 0) {
			test1 = true;
		}
		return test1;
	}

	/**
	 * Tests the implementation of createNewTicket and if the results are as
	 * expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testAddNew() {
		// initialize parameters
		boolean test2 = true;
		HelpDesk newDesk = new HelpDesk(5);
		newDesk.createNewTicket("AAA");
		// check if the highest priority is AAA
		String s = newDesk.checkNextTicket();
		if (!s.equals("AAA")) {
			test2 = false;
		}
		// check if the new highest priority is hello
		newDesk.createNewTicket("hello");
		s = newDesk.checkNextTicket();
		if (!s.equals("hello")) {
			test2 = false;
		}
		// check if the new highest priority is time for a nap
		newDesk.createNewTicket("time for a nap");
		s = newDesk.checkNextTicket();
		if (!s.equals("time for a nap")) {
			test2 = false;
		}
		return test2;
	}

	public static boolean testRemove() {
		// initialize parameters
		boolean test3 = true;
		HelpDesk newDesk = new HelpDesk(5);
		newDesk.createNewTicket("AAA");
		newDesk.createNewTicket("hello");
		newDesk.createNewTicket("time for a nap");
		newDesk.createNewTicket("so tired");
		newDesk.createNewTicket("ahhhhhh");
		// remove highest priortiy ticket
		String s = newDesk.closeNextTicket();
		// check if the right node was removed
		if (!s.equals("time for a nap")) {
			test3 = false;
		}
		// check if the new top node is so tired
		s = newDesk.checkNextTicket();
		if (!s.equals("so tired")) {
			test3 = false;
		}
		return test3;
	}

	/**
	 * Tests the implementation of checkNextTicket and if the results are as
	 * expected
	 * 
	 * @return boolean true - if implemented correctly false - if not
	 */
	public static boolean testCheckNextTicket() {
		// initialize parameters
		boolean test4 = false;
		HelpDesk newDesk = new HelpDesk(5);
		newDesk.createNewTicket("AAA");
		newDesk.createNewTicket("hello");
		newDesk.createNewTicket("time for a nap");
		// check if the returned message is from the expected highest priority
		String s = newDesk.checkNextTicket();
		if (s.equals("time for a nap")) {
			test4 = true;
		}
		return test4;
	}

	/**
	 * Tests the implementation of swap and if the results are as expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testSwap() {
		// initialize parameters
		boolean test5 = false;
		HelpDesk newDesk = new HelpDesk(5);
		newDesk.createNewTicket("AAA");
		newDesk.createNewTicket("hello");
		newDesk.createNewTicket("time for a nap");
		// swap two of the nodes
		newDesk.swap(0, 2);
		// check if the priority is the one that was swapped
		String s = newDesk.checkNextTicket();
		if (s.equals("hello")) {
			test5 = true;
		}
		return test5;
	}

	/**
	 * Tests the implementation of getParentOf and if the results are as expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testGetParentOf() {
		// initialize parameters
		boolean test6 = true;
		HelpDesk newDesk = new HelpDesk(5);
		// get the parent index and check if correct
		int num = newDesk.getParentOf(2);
		System.out.println(num);
		if (num != 0) {
			test6 = false;
		}
		// get parent index and check if correct
		num = newDesk.getParentOf(20);
		System.out.println(num);
		if (num != 9) {
			test6 = false;
		}
		return test6;
	}

	/**
	 * Tests the implementation of rightChildOf and if the results are as expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testGetRightChildOf() {
		// initialize parameters
		boolean test7 = true;
		HelpDesk newDesk = new HelpDesk(5);
		// check the index of right child and if its correct
		int num = newDesk.rightChildOf(0);
		if (num != 2) {
			test7 = false;
		}
		return test7;
	}

	/**
	 * Tests the implementation of leftChildOf and if the results are as expected
	 * 
	 * @return boolean true - if implemented correctly, false - if not
	 */
	public static boolean testGetLeftChildOf() {
		// initialize parameters
		boolean test8 = true;
		HelpDesk newDesk = new HelpDesk(5);
		// check index of left child and if its correct
		int num = newDesk.leftChildOf(0);
		if (num != 1) {
			test8 = false;
		}
		return test8;
	}
}
