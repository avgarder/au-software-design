package cli.command

import cli.Environment
import cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*

class SetVariableCommandTests {
    @Test
    fun test1() {
        val env = Environment()
        val cmd = SetVariableCommand(listOf("key", "value"))
        val text = "passed text"
        val result = cmd.run(env, text.byteInputStream())
        assertEquals(env.getValue("key"), "value")
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, text.byteInputStream()))
    }
}