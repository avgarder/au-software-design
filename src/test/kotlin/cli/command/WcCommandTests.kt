package cli.command

import cli.Environment
import cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class WcCommandTests {
    @Test
    fun test1() {
        val text = "word1\nword2   word3   \"word4   word5\"\nword6"
        val cmd = WcCommand(Collections.emptyList())
        val result = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, "3 6 ${text.length}".byteInputStream()))
    }
}