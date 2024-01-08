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
	//checks if the queue is empty by verifying if its elements array has a length of 0.
	public boolean isEmpty ()
	{
		return numbers.length == 0;

	}
	//returns the number of elements
	public int size ()
	{
		return numbers.length;
	}
	//adds a new element to the end of the queue
	/***by creating a new array (a) with a length one greater than the current elements array, 
	 * copying the elements from the current array, 
	 * and adding the new element to the end */
	public void put (double number)
	{
		double[] temp = new double[numbers.length + 1];
		for (int i = 0; i < numbers.length; i++)
		{
			temp[i] = numbers[i];
			temp[temp.length - 1] = number;
			numbers = temp;

		}


	}
	/**removes and returns the front element of the queue. 
	 * It checks if the queue is empty and throws an IllegalStateException  */
	public double take () throws IllegalStateException
	{
		if (this.isEmpty())
		{
			throw new IllegalStateException(
								"take called on empty number sequence"
			);

		}
		double n = numbers[0];
		double[] temp = new double[numbers.length - 1];
		for (int i = 0; i < numbers.length; i++)
		{
			temp[i] = numbers[i + 1];
		}
		numbers = temp;
		return n;
	}
	//return the upper bound of the numbers in the sequence.
	public double upperBound()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Sequence is empty");

		}
		double max = numbers[0];
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] > max) 
			{
				max = numbers[i];

			}

		}
		return max;
	}
	//return the sequence as an array
	public double[] asArray(){
		//Arrays.copyOf() to create a copy of numbers array
		return Arrays.copyOf(numbers, numbers.length);
	}
	//to find the position (index) of a given number in the sequence.
	public int positionOf(double number) 
	{
        for (int i = 0; i < numbers.length; i++) 
		{
            if (numbers[i] == number)
			 {
                return i;
            }
        }
        return -1;  // Return -1 if the number is not found in the sequence
    }
	//to check whether a given number is present in the sequence.
	public boolean contains(double number) 
	{
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
			}
		}
		return false;
	}
	//returns the number of elements in the sequence. 
	public int length() {
        return numbers.length;  // Return the length of the numbers array
    }
}



	

