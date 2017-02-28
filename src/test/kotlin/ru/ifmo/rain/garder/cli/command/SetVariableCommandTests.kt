package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*

class SetVariableCommandTests {
    @Test
    fun testSimpleVariablesSetting() {
        val env = Environment()
        val cmd = SetVariableCommand(listOf("key", "value"))
        val text = "passed text"
        val result = cmd.run(env, text.byteInputStream())
        assertEquals(env.getValue("key"), "value")
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, text.byteInputStream()))
    }
}