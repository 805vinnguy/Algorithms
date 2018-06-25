/**
 * Main Driver.
 * Parses input from argument file and calls IndexValueMatch().
 *
 * @author Vinh Nguyen
 * @version 1.4, June 16 2018
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Integer[] A = parse(args[0]);
        output(IndexValueMatch(A, 0, A.length));
    }

    public static Integer[] parse(String arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(arg));
        ArrayList<Integer> AL = new ArrayList<Integer>();
        Integer[] A;

        while(sc.hasNextInt()) {
            AL.add(sc.nextInt());
        }
        sc.close();

        A = new Integer[AL.size()];
        A = AL.toArray(A);
        return A;
    }

    /**
     * Returns i such that arr[i] = i.
     * Else -1.
     */
    public static int IndexValueMatch(Integer[] A, int min, int max) {
        int i = (min + max) / 2;
        if(A[i] == i) {
            return i;
        }
        //if i has reached either end and
        //has is not an IndexValueMatch.
        else if(i == 0 || i == A.length-1) {
            return -1;
        }
        else if(A[i] < i) {
            return IndexValueMatch(A, min, i);
        }
        else if(A[i] > i) {
            return IndexValueMatch(A, i, max);
        }
        else {
            return -1;
        }
    }

    /**
     * Takes result from IndexValueMatch,
     * converts it to an output of the problem statement,
     * and outputs it.
     */
    public static void output(int result) {
        if(result > 0) {
            System.out.println("i = " + result + " such that A[i] = i.");
        }
        else {
            System.out.println("There is no such i such that A[i] = i.");
        }
    }
}