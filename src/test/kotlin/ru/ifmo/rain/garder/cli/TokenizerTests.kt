package ru.ifmo.rain.garder.cli

import org.junit.Test
import org.junit.Assert.*

class TokenizerTests {
    @Test
    fun testSimpleTokenization() {
        assertEquals(Tokenizer.tokenize("  ababa   \"aa'a\" zz 'b\"bb' | aa   "),
                listOf("ababa", "aa'a", "zz", "b\"bb", "|", "aa"))
    }
}