// ArrayNumberSequence.java

import java.util.Arrays;

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

    // add code here
		//returns the number of elements in the sequence. 
	public int length() {
        return numbers.length;  
    }
	// upperBound returns an upper bound for this sequence.
	//The Stream interface provides two methods max() and min() 
	//that return the largest and the smallest item from the underlying stream.
    public double upperBound() {
        return Arrays.stream(numbers).max().orElseThrow(); 
    }
	// lowerBound returns a lower bound for this sequence.
	public double lowerBound() {
        return Arrays.stream(numbers).min().orElseThrow(); 
    }
    // numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
	public double numberAt(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= numbers.length)
            throw new IndexOutOfBoundsException("Invalid position");
        return numbers[position];
    }
    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.	
	public int positionOf(double number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }
    // isIncreasing returns true if this sequence is increasing,
    // else false is returned.	
	public boolean isIncreasing() {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] <= numbers[i - 1]) {
                return false;
            }
        }
        return true;
    }
    // isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
	public boolean isDecreasing() {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] >= numbers[i - 1]) {
                return false;
            }
        }
        return true;
    }
    // contains returns true if this sequence contains the
    // specified number, else false is returned.
	public boolean contains(double number) {
        for (double n : numbers) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }
	// add adds the specified number to the end of this sequence.
	public void add(double number) {
        double[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
        newNumbers[numbers.length] = number;
        numbers = newNumbers;
    }
	// insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
	public void insert(int position, double number) throws IndexOutOfBoundsException {
        if (position < 0 || position > numbers.length)
            throw new IndexOutOfBoundsException("Invalid position");

        double[] newNumbers = new double[numbers.length + 1];
		//0: The starting index in the numbers array from which to begin copying.
		//   The starting index in the newNumbers array where elements are copied.
		//ensures that the elements before the insertion point are preserved in the new array.
		//Basically, first part, from first element to new number(not included)
        System.arraycopy(numbers, 0, newNumbers, 0, position);
        newNumbers[position] = number;
		//second part, newnumber to end.
		//The "position + 1" is used to account for the space left for the inserted element.
        System.arraycopy(numbers, position, newNumbers, position + 1, numbers.length - position);

        numbers = newNumbers;
    }
	// removeAt removes the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    // The method throws IllegalStateException if there are
    // just two numbers in the sequence.
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException {
        if (position < 0 || position >= numbers.length)
            throw new IndexOutOfBoundsException("Invalid position");
        if (numbers.length == 2)
            throw new IllegalStateException("Cannot remove element when there are only two elements");

        double[] newNumbers = new double[numbers.length - 1];
        System.arraycopy(numbers, 0, newNumbers, 0, position);
        System.arraycopy(numbers, position + 1, newNumbers, position, numbers.length - position - 1);

        numbers = newNumbers;
    }
	// asArray returns an array containing all of the numbers in
    // this sequence, in the same order as in the sequence.
	public double[] asArray() {
        return Arrays.copyOf(numbers, numbers.length);
    }





}



	

