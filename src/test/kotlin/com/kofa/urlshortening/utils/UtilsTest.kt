package com.kofa.urlshortening.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
class UtilsTest{
    @Test
    fun `should return true for valid URLs`() {
        assertTrue(isUrlValid("http://www.google.com"))
        assertTrue(isUrlValid("https://example.com"))
        assertTrue(isUrlValid("https://www.example.org"))
    }

    @Test
    fun `should return false for invalid URLs`() {
        assertFalse(isUrlValid("NotValidURL"))
        assertFalse(isUrlValid("http//invalid.com"))
        assertFalse(isUrlValid("ftp://example.com"))
    }

}