package cli.command

import org.junit.Test
import org.junit.Assert.*

class CommandFactoryTests {
    @Test
    fun testCat() {
        assertTrue(CommandFactory.getCommand(listOf("cat", "abacaba.txt")) is CatCommand)
    }

    @Test
    fun testSetVariable() {
        assertTrue(CommandFactory.getCommand(listOf("var=\"complex value\"")) is SetVariableCommand)
    }
}