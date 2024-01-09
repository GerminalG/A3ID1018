// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

import java.util.Arrays;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        // creates a new instance of the ArrayNumberSequence class, 
        //using the realNumbers array as its initial set of numbers. 
        sequence = new ArrayNumberSequence(realNumbers);
        // sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here

        //test out some method that doesn't need to give a value
        out.println("Length: " + sequence.length());
        out.println("Upper Bound: " + sequence.upperBound());
        out.println("Lower Bound: " + sequence.lowerBound());
        
        int positionToTest = 2;
        out.println("Number at position " + positionToTest + ": " + sequence.numberAt(positionToTest));

        double numberToFind = 5.0;
        out.println("Position of " + numberToFind + ": " + sequence.positionOf(numberToFind));

        out.println("Is Increasing? " + sequence.isIncreasing());
        out.println("Is Decreasing? " + sequence.isDecreasing());

        double numberToCheck = 12.0;
        out.println("Contains " + numberToCheck + "? " + sequence.contains(numberToCheck));

        double numberToAdd = 20.0;
        sequence.add(numberToAdd);
        out.println("After adding " + numberToAdd + ":");
        out.println(sequence);

        int positionToInsert = 3;
        double numberToInsert = 7.0;
        sequence.insert(positionToInsert, numberToInsert);
        out.println("After inserting " + numberToInsert + " at position " + positionToInsert + ":");
        out.println(sequence);

        int positionToRemove = 2;
        sequence.removeAt(positionToRemove);
        out.println("After removing element at position " + positionToRemove + ":");
        out.println(sequence);

        out.println("As Array: " + Arrays.toString(sequence.asArray()));
        out.println();

        // Test with LinkedNumberSequence
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("The sequence:");
        out.println(sequence);
        out.println("Length: " + sequence.length());
        out.println("Upper Bound: " + sequence.upperBound());
        out.println("Lower Bound: " + sequence.lowerBound());

        positionToTest = 2;
        out.println("Number at position " + positionToTest + ": " + sequence.numberAt(positionToTest));

        numberToFind = 5.0;
        out.println("Position of " + numberToFind + ": " + sequence.positionOf(numberToFind));

        out.println("Is Increasing? " + sequence.isIncreasing());
        out.println("Is Decreasing? " + sequence.isDecreasing());

        numberToCheck = 12.0;
        out.println("Contains " + numberToCheck + "? " + sequence.contains(numberToCheck));

        numberToAdd = 20.0;
        sequence.add(numberToAdd);
        out.println("After adding " + numberToAdd + ":");
        out.println(sequence);

        positionToInsert = 3;
        numberToInsert = 7.0;
        sequence.insert(positionToInsert, numberToInsert);
        out.println("After inserting " + numberToInsert + " at position " + positionToInsert + ":");
        out.println(sequence);

        positionToRemove = 2;
        sequence.removeAt(positionToRemove);
        out.println("After removing element at position " + positionToRemove + ":");
        out.println(sequence);

        out.println("As Array: " + Arrays.toString(sequence.asArray()));
    
        
    }
}