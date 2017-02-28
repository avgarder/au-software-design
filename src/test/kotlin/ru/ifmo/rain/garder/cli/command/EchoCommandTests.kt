package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*

class EchoCommandTests {
    @Test
    fun testSimpleEcho() {
        val cmd = EchoCommand(listOf("abaca", "badaba", "caba"))
        val result = cmd.run(Environment(), null)
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, "abaca badaba caba".byteInputStream()))
    }
}