package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class CatCommandTests {
    @Test
    fun testSimpleCat() {
        val cmd = CatCommand(Collections.emptyList())
        val text = "some\ntext"
        val result = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, text.byteInputStream()))
    }
}