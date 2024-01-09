// LinkedNumberSequence.java

import java.util.NoSuchElementException;

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	/*
	 * This is an inner class representing a node in the linked list.
	 * Each node contains a number field to store the value and
	 *  a next field pointing to the next node in the sequence.
	 * The constructor initializes a node with a given number and sets next to null.
	 */
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
	//The constructor takes an array of numbers and 
	//initializes the linked list based on the values in the array.
	//It creates the first node with the value of the first element in the array
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here
	public int length() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

	public double upperBound() {
        if (first == null)
            throw new NoSuchElementException("Empty sequence");

        double max = first.number;
        Node current = first.next;
        while (current != null) {
            if (current.number > max) {
                max = current.number;
            }
            current = current.next;
        }
        return max;
    }
	public double lowerBound() {
        if (first == null)
            throw new NoSuchElementException("Empty sequence");

        double min = first.number;
        Node current = first.next;
        while (current != null) {
            if (current.number < min) {
                min = current.number;
            }
            current = current.next;
        }
        return min;
    }
	public double numberAt(int position) throws IndexOutOfBoundsException {
        if (position < 0)
            throw new IndexOutOfBoundsException("Negative position");

        Node current = first;
        for (int i = 0; i < position; i++) {
            if (current == null)
                throw new IndexOutOfBoundsException("Invalid position");
            current = current.next;
        }

        if (current == null)
            throw new IndexOutOfBoundsException("Invalid position");

        return current.number;
    }
	public int positionOf(double number) {
        int position = 0;
        Node current = first;
        while (current != null) {
            if (current.number == number) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }
	public boolean isIncreasing() {
        Node current = first;
        while (current != null && current.next != null) {
            if (current.number > current.next.number) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
	public boolean isDecreasing() {
        Node current = first;
        while (current != null && current.next != null) {
            if (current.number < current.next.number) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
	public boolean contains(double number) {
        Node current = first;
        while (current != null) {
            if (current.number == number) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
	public void add(double number) {
        Node newNode = new Node(number);
        if (first == null) {
            first = newNode;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
	public void insert(int position, double number) throws IndexOutOfBoundsException {
        if (position < 0)
            throw new IndexOutOfBoundsException("Negative position");

        Node newNode = new Node(number);
        if (position == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node current = first;
            for (int i = 0; i < position - 1; i++) {
                if (current == null)
                    throw new IndexOutOfBoundsException("Invalid position");
                current = current.next;
            }

            if (current == null)
                throw new IndexOutOfBoundsException("Invalid position");

            newNode.next = current.next;
            current.next = newNode;
        }
    }
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException {
        if (position < 0)
            throw new IndexOutOfBoundsException("Negative position");

        if (position == 0) {
            if (first == null)
                throw new IndexOutOfBoundsException("Invalid position");
            first = first.next;
        } else {
            Node current = first;
            for (int i = 0; i < position - 1; i++) {
                if (current == null)
                    throw new IndexOutOfBoundsException("Invalid position");
                current = current.next;
            }

            if (current == null || current.next == null)
                throw new IndexOutOfBoundsException("Invalid position");

            current.next = current.next.next;
        }
    }
	public double[] asArray() {
        int len = length();
        double[] array = new double[len];
        Node current = first;
        for (int i = 0; i < len; i++) {
            array[i] = current.number;
            current = current.next;
        }
        return array;
    }




}