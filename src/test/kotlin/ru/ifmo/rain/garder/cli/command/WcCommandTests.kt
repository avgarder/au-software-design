package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class WcCommandTests {
    @Test
    fun testSimpleCounting() {
        val text = "word1\nword2   word3   \"word4   word5\"\nword6"
        val cmd = WcCommand(Collections.emptyList())
        val result = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, "3 6 ${text.length}".byteInputStream()))
    }
}