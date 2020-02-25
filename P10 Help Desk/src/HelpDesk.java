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
 * Creates a new instance of HelpDesk Allows for new tickets to be addded with
 * priortity and take those tickets off in the priority order
 */
public class HelpDesk implements HelpDeskInterface {
	protected SupportTicket[] array; // zero-indexed max-heap
	protected int size;

	/**
	 * Creates a new instance of HelpDesk
	 * 
	 * @param int capacity of the array
	 */
	public HelpDesk(int arraySize) {
		array = new SupportTicket[arraySize];
		size = 0;
	}

	/**
	 * Creates a new Ticket to be added to the HelpDesk
	 * 
	 * @param message determines priority of ticket
	 */
	@Override
	public void createNewTicket(String message) {
		// create a new ticket instance
		SupportTicket newTicket = new SupportTicket(message);
		// check if array is full
		if (size == array.length) {
			System.out.println("Cannot add another ticket");
			return;
		}
		// add to array with priority
		// if array is null, add it to the first position
		if (array[0] == null) {
			array[0] = newTicket;
			size++;
			return;
		}
		// add the node in according to priority
		array[size] = newTicket;
		propagateUp(size);
		size++;
	}

	/**
	 * A helper method that propagates a ticket up to the correct position, so the
	 * highest priority is on top
	 * 
	 * @param index of the parent node to be propagated up
	 */
	protected void propagateUp(int index) {
		// get the parent index to check the node above it
		int parentIndex = getParentOf(index);
		// if at top, stop
		if (index == 0) {
			return;
		}
		// if smaller than parent node, stop
		if (array[parentIndex].getMessage().compareTo(array[index].getMessage()) > 0) {
			return;
		}
		// if nodes are equal, stop
		if (array[parentIndex].getMessage().compareTo(array[index].getMessage()) == 0) {
			return;
		}
		// else, swap the parent node and current node
		swap(index, parentIndex);
		// recursive call with the new index
		propagateUp(parentIndex);
	}

	/**
	 * Retrieves the parent node of the current index
	 * 
	 * @param index - child node index
	 * @return int - index of parent node
	 */
	protected int getParentOf(int index) {
		// check if its even
		if (index % 2 == 0) {
			// calculate the parent index
			index = index / 2;
			index -= 1;
		}
		// if odd
		else {
			// calculate the parent index
			index = index / 2;
		}
		return index;

	}

	/**
	 * Retrieves the right child node of the current index
	 * 
	 * @param index - parent index
	 * @return int - index of the right child node
	 */
	protected int rightChildOf(int index) {
		// calculate the right child index
		return (index + 1) * 2;
	}

	/**
	 * Retrieves the left child node of the current index
	 * 
	 * @param index - parent index
	 * @return int - index of the left child node
	 */
	protected int leftChildOf(int index) {
		// calculate the left child index
		return (index * 2) + 1;
	}

	/**
	 * Swaps two indexes in order to assist with propagation
	 * 
	 * @param indexA - first index indexB - second index
	 */
	protected void swap(int indexA, int indexB) {
		// temp save the nodes
		SupportTicket nodeOne = array[indexA];
		SupportTicket nodeTwo = array[indexB];
		// swap the nodes at each others indexes
		array[indexA] = nodeTwo;
		array[indexB] = nodeOne;

	}

	/**
	 * Retrieves the message of the top priority
	 * 
	 * @return String - message from top priortiy node
	 */
	@Override
	public String checkNextTicket() {
		// return the message at index 0
		return array[0].getMessage();
	}

	/**
	 * Removes the top priority ticket
	 * 
	 * @param index - parent index
	 * @return int - index of the right child node
	 */
	@Override
	public String closeNextTicket() {
		// temp save the highest priority node
		SupportTicket highestNode = array[0];
		// grab the last node in the array
		array[0] = array[size - 1];
		// set that spot to null
		array[size - 1] = null;
		size--;
		// propagate the node down the correct position
		propagateDown(0);
		// return the message of the node removed
		return highestNode.getMessage();
	}

	/**
	 * A helper method that propagates a ticket down to the correct position, so the
	 * highest priority is on top
	 * 
	 * @param index of the node to be propagated down
	 */
	protected void propagateDown(int index) {
		// get the right and left child indicies
		int rightIndex = rightChildOf(index);
		int leftIndex = leftChildOf(index);
		// check if either the right or left index is null and swap with the one that is
		// not null
		if (array[rightIndex] == null) {
			swap(index, leftIndex);
			return;
		}
		if (array[leftIndex] == null) {
			swap(index, rightIndex);
			return;
		}
		// check if the node is less than the right and left child
		if (array[index].getMessage().compareTo(array[rightIndex].getMessage()) < 0
				&& array[index].getMessage().compareTo(array[leftIndex].getMessage()) < 0) {
			// swap with the index that is larger
			if (array[rightIndex].getMessage().compareTo(array[leftIndex].getMessage()) > 0) {
				swap(index, rightIndex);
			} else {
				swap(index, leftIndex);
			}
		} else {
			// swap with the right index if it's smaller than the right index
			if (array[index].getMessage().compareTo(array[rightIndex].getMessage()) < 0) {
				swap(index, rightIndex);
			} else {
				// swap with the left index if it's smaller than the left index
				swap(index, leftIndex);
			}
		}

	}

}
