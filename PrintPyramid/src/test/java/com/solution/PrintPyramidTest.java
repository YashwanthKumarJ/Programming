package com.solution;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintPyramidTest {

	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private PrintPyramid printPyramidSolution;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));

		printPyramidSolution = new PrintPyramid();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForNullStringInUpright() {
		printPyramidSolution.printUpright(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForEmptyStringInUpright() {
		printPyramidSolution.printUpright("", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForInvalidRowsInUpright() {
		printPyramidSolution.printUpright("abc", -4);
	}

	@Test
	public void shouldPrintUprightInCorrectOrder() {
		printPyramidSolution.printUpright("abc", 3);
		assertEquals("  a\r\n acb\r\nbcabc\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintCorrectRowsInUpright() {
		printPyramidSolution.printUpright("abc", 4);
		assertEquals("   a\r\n  acb\r\n bcabc\r\nacbacba\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintZeroSpaceInUprightForRowCountOne() {
		printPyramidSolution.printUpright("xyz", 1);
		assertEquals("x\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintNothingInUprightForRowCountZero() {
		printPyramidSolution.printUpright("xyz", 0);
		assertEquals("", outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForNullStringInDownPrint() {
		printPyramidSolution.printDown(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForEmptyStringInDownPrint() {
		printPyramidSolution.printDown("", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldResultExceptionForInvalidRowsInDownPrint() {
		printPyramidSolution.printDown("abc", -4);
	}

	@Test
	public void shouldPrintUprightInCorrectOrderInDownPrint() {
		printPyramidSolution.printDown("abc", 3);
		assertEquals("abcab\r\n bac\r\n  c\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintCorrectRowsInDownPrint() {
		printPyramidSolution.printDown("abc", 4);
		assertEquals("abcabca\r\n cbacb\r\n  abc\r\n   a\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintZeroSpaceInDownPrintForRowCountOne() {
		printPyramidSolution.printDown("xyz", 1);
		assertEquals("x\r\n", outContent.toString());
	}

	@Test
	public void shouldPrintNothingInDownPrintForRowCountZero() {
		printPyramidSolution.printDown("xyz", 0);
		assertEquals("", outContent.toString());
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
}
