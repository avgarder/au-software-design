package cli.command

import cli.Environment
import cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class CatCommandTests {
    @Test
    fun test1() {
        val cmd = CatCommand(Collections.emptyList())
        val text = "some\ntext"
        val result = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, text.byteInputStream()))
    }
}