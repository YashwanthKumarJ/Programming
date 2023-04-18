package com.github.yashwanth.programming.general;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Unit testing FindFirstRepetitiveOccurrenceOfCharacter Solution")
class FindFirstRepetitiveOccurrenceOfCharacterTest
{
    @Test
    public void shouldReturnNullIfNoDuplicateChar() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abc");
        assertEquals(null, resultStr);
    }

    @Test
    public void shouldReturnFirstOccurrenceOfDuplicateChar() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abca");
        assertEquals('a', resultStr);
    }

    @Test
    public void testStringWithMoreCharactersWithoutOccurrence() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abcdefghijklmnopqrstuvwxyz1234567890");
        assertEquals(null, resultStr);
    }

    @Test
    public void testStringWithMoreCharactersWithOccurrence() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abcdefghijklmnopqrstuvwxyz12345678904");
        assertEquals('4', resultStr);
    }

    @Test
    public void testStringWithNonAlphabets() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abcdefghijklmnopqrstuvwxyz!1234567890~4");
        assertEquals('4', resultStr);
    }

    @Test
    public void testStringWithNonAlphabetsOccurrence() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("abcdefghijklmnopqrstuvwxyz~1234567890~4");
        assertEquals('~', resultStr);
    }

    @Test
    public void testEmptyString() {
        Character resultStr = FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence("");
        assertEquals(null , resultStr);
    }

    @Test
    public void testNullString() {
        assertThrows(NullPointerException.class , () -> {
            FindFirstRepetitiveOccurrenceOfCharacter.findFirstRepetitiveOccurrence(null);
        });
    }
}
