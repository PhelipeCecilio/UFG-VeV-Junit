package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class IdentifierTest {

    Identifier identifier = new Identifier();

    @Test
    public void testValidIdentifier() {
        assertTrue(identifier.validateIdentifier("ValidID12"));
    }

    @Test
    public void testInvalidIdentifierStartWithNumber() {
        assertFalse(identifier.validateIdentifier("1InvalidID"));
    }

    @Test
    public void testInvalidIdentifierTooShort() {
        assertFalse(identifier.validateIdentifier("Short"));
    }

    @Test
    public void testInvalidIdentifierTooLong() {
        assertFalse(identifier.validateIdentifier("ThisIsTooLongIdentifier"));
    }

    @Test
    public void testInvalidIdentifierSpecialCharacter() {
        assertFalse(identifier.validateIdentifier("Invalid#ID"));
    }

    @Test
    public void testNullIdentifier() {
        try {
            identifier.validateIdentifier(null);
            fail("Expected a NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testValidIdentifierAllLowercase() {
        assertTrue(identifier.validateIdentifier("validid"));
    }

    @Test
    public void testValidIdentifierAllUppercase() {
        assertTrue(identifier.validateIdentifier("VALIDID"));
    }

    @Test
    public void testValidIdentifierMixedCase() {
        assertTrue(identifier.validateIdentifier("ValidId"));
    }

    @Test
    public void testValidIdentifierAllNumbers() {
        assertFalse(identifier.validateIdentifier("1234567890"));
    }

}