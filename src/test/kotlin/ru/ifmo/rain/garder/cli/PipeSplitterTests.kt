package ru.ifmo.rain.garder.cli

import org.junit.Test
import org.junit.Assert.*

class PipeSplitterTests {
    @Test
    fun testSimpleSplit() {
         assertEquals(PipeSplitter.splitPipes(listOf("cat", "file.txt", "|", "echo", "|", "cmd")),
                 listOf(listOf("cat", "file.txt"), listOf("echo"), listOf("cmd")))
    }
}