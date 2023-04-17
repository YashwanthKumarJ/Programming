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

        assertEquals("Even Thread 0\n", outContent.toString());
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
                Even Thread 0
                Odd Thread 1
                Even Thread 2
                Odd Thread 3
                Even Thread 4
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
                Even Thread 0
                Odd Thread 1
                Even Thread 2
                Odd Thread 3
                Even Thread 4
                Odd Thread 5
                """, outContent.toString());
    }
}
