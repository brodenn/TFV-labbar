package search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {

	public static Random rand = new Random();

	 /**
	   * requires: - 'array' is not null.
	   *           - the array is sorted by increasing value, i.e. for each index
	   *             'i' and index 'j', if 'i' < 'j' then 'array[i]' <= 'array[j]'.
	   * ensures:  - if there is an index 'i' such that 'array[i] == value', the
	   *             method returns true.
	   *           - otherwise, it returns false.
	   *           - in either case, 'array' is left unchanged.
	   **/
	public static boolean search(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int index = (right + left) / 2;
			if (array[index] == value)
				return true;
			if (array[index] < value)
				left = index + 1;
			else
				right = index - 1;
		}
		return false;
	}

	public static boolean contains(int[] array, int value) {
		for (int a : array)
			if (a == value)
				return true;
		return false;
	}

	public static int[] generateArray(int length) {
		int[] generatedArray = new int[length];
		for (int i = 0; i < length; i++) {
			generatedArray[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		Arrays.sort(generatedArray);
		return generatedArray;
	}

	public static int pickElementFrom(int[] array) {
		return array[rand.nextInt(array.length)];
	}

	public static int pickElementOutside(int[] array) {
		int randomValue = 0;
		do {
			randomValue = rand.nextInt(Integer.MAX_VALUE);
		} while (contains(array, randomValue));
		return randomValue;
	}

	public static boolean test(int[] array, int value) {
		try {
			return search(array, value) == contains(array, value);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] arg) {
		for (int i = 0; i < 1000; i++) {
			int[] array = generateArray(rand.nextInt(20) + 1);
			int value = rand.nextBoolean() ? pickElementFrom(array) : pickElementOutside(array);
			if (!test(array, value)) {
				System.out.println("Value: " + value);
				System.out.println("Array: " + Arrays.toString(array));
				System.exit(0);
			}
		}
		System.out.println("Done.");
	}
}
