/*
  Unit testing Pyramid Printing

  @author Yashwanth
 */

package com.solution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Unit testing of PrintPyramid")
public class PrintPyramidTest {

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private PrintPyramid printPyramidSolution;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        printPyramidSolution = new PrintPyramid();
    }

    @Test
    public void shouldResultExceptionForNullStringInUpright() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printUpright(null, 1));
    }

    @Test
    public void shouldResultExceptionForEmptyStringInUpright() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printUpright("", 1));
    }

    @Test
    public void shouldResultExceptionForInvalidRowsInUpright() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printUpright("abc", -4));
    }

    @Test
    public void shouldPrintUprightInCorrectOrder() {
        printPyramidSolution.printUpright("abc", 3);
        assertEquals("  a\n acb\nbcabc\n", outContent.toString());
    }

    @Test
    public void shouldPrintCorrectRowsInUpright() {
        printPyramidSolution.printUpright("abc", 4);
        assertEquals("   a\n  acb\n bcabc\nacbacba\n", outContent.toString());
    }

    @Test
    public void shouldPrintZeroSpaceInUprightForRowCountOne() {
        printPyramidSolution.printUpright("xyz", 1);
        assertEquals("x\n", outContent.toString());
    }

    @Test
    public void shouldPrintNothingInUprightForRowCountZero() {
        printPyramidSolution.printUpright("xyz", 0);
        assertEquals("", outContent.toString());
    }

    @Test
    public void shouldResultExceptionForNullStringInDownPrint() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printDown(null, 1));
    }

    @Test
    public void shouldResultExceptionForEmptyStringInDownPrint() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printDown("", 1));
    }

    @Test
    public void shouldResultExceptionForInvalidRowsInDownPrint() {
        assertThrows(IllegalArgumentException.class, () -> printPyramidSolution.printDown("abc", -4));
    }

    @Test
    public void shouldPrintUprightInCorrectOrderInDownPrint() {
        printPyramidSolution.printDown("abc", 3);
        assertEquals("abcab\n bac\n  c\n", outContent.toString());
    }

    @Test
    public void shouldPrintCorrectRowsInDownPrint() {
        printPyramidSolution.printDown("abc", 4);
        assertEquals("abcabca\n cbacb\n  abc\n   a\n", outContent.toString());
    }

    @Test
    public void shouldPrintZeroSpaceInDownPrintForRowCountOne() {
        printPyramidSolution.printDown("xyz", 1);
        assertEquals("x\n", outContent.toString());
    }

    @Test
    public void shouldPrintNothingInDownPrintForRowCountZero() {
        printPyramidSolution.printDown("xyz", 0);
        assertEquals("", outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
