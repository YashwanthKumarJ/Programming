package com.solution;

/**
 * Pyramid Printing
 * 
 * @author Yashwanth
 *
 */
public class PrintPyramid {
	public static void main(String[] args) {
		new PrintPyramid().printUpright("abc", 1);
	}

	public void printUpright(String inputStr, int noOfRows) {
		if (inputStr == null || inputStr.length() == 0 || noOfRows < 0) {
			throw new IllegalArgumentException();
		}

		int index = 0;
		int ln = inputStr.length();
		boolean dirBool = true;

		for (int i = 1; i <= noOfRows; i++) {
			String space = "";
			String toPrint = "";

			for (int j = 0, l = (noOfRows - i); j < l; j++) {
				space += " ";
			}

			for (int k = 1, l = (i * 2); k < l; k++) {
				if (dirBool) {
					toPrint += inputStr.charAt(index % ln);
				} else {
					toPrint = inputStr.charAt(index % ln) + toPrint;
				}

				index++;
			}

			System.out.println(space + toPrint);

			dirBool = !dirBool;
		}
	}

	public void printDown(String inputStr, int noOfRows) {
		if (inputStr == null || inputStr.length() == 0 || noOfRows < 0) {
			throw new IllegalArgumentException();
		}

		int index = 0;
		int ln = inputStr.length();
		boolean dirBool = true;

		String space = "";

		for (int i = 0; i < noOfRows; i++) {
			String toPrint = "";

			for (int k = 1, l = ((noOfRows - i) * 2 - 1); k <= l; k++) {
				if (dirBool) {
					toPrint += inputStr.charAt(index % ln);
				} else {
					toPrint = inputStr.charAt(index % ln) + toPrint;
				}

				index++;
			}

			System.out.println(space + toPrint);

			dirBool = !dirBool;
			space += " ";
		}
	}
}
