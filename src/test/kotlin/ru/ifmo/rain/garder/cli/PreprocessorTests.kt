package ru.ifmo.rain.garder.cli

import org.junit.Test
import org.junit.Assert.*

class PreprocessorTests {
    @Test
    fun testSimpleReplacement() {
        val env = Environment()
        env.setValue("aa", "bb")
        assertEquals(Preprocessor.preprocess(env, "some text \$aaa \$aa aa \$bb"), "some text \$aaa bb aa \$bb")
    }

    @Test
    fun testReplacementWithQuotes() {
        val env = Environment()
        env.setValue("x", "y")
        assertEquals(Preprocessor.preprocess(env, "\"123\$x\""), "\"123y\"")
        assertEquals(Preprocessor.preprocess(env, "'123\$x'"), "'123\$x'")
    }
}