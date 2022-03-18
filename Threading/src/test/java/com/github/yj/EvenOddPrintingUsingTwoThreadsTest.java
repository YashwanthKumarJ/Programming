package com.github.yj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenOddPrintingUsingTwoThreadsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldNotPrintAnythingForNegativeNumber() {
        EvenOddPrintingUsingTwoThreads printer = new EvenOddPrintingUsingTwoThreads(-1);
        printer.startPrinting();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("", outContent.toString());
    }

    @Test
    public void shouldPrintAnEntryForZero() {
        EvenOddPrintingUsingTwoThreads printer = new EvenOddPrintingUsingTwoThreads(0);
        printer.startPrinting();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("Even Thread 0\r\n", outContent.toString());
    }

    @Test
    public void shouldPrintEvenOddForEvenNumber() {
        EvenOddPrintingUsingTwoThreads printer = new EvenOddPrintingUsingTwoThreads(4);
        printer.startPrinting();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("""
                Even Thread 0\r
                Odd Thread 1\r
                Even Thread 2\r
                Odd Thread 3\r
                Even Thread 4\r
                """, outContent.toString());
    }

    @Test
    public void shouldPrintEvenOddForOddNumber() {
        EvenOddPrintingUsingTwoThreads printer = new EvenOddPrintingUsingTwoThreads(5);
        printer.startPrinting();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("""
                Even Thread 0\r
                Odd Thread 1\r
                Even Thread 2\r
                Odd Thread 3\r
                Even Thread 4\r
                Odd Thread 5\r
                """, outContent.toString());
    }
}