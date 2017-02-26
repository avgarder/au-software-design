package cli.command

import cli.Environment
import cli.InputStreamUtils
import org.junit.Test
import org.junit.Assert.*

class EchoCommandTests {
    @Test
    fun test1() {
        val cmd = EchoCommand(listOf("abaca", "badaba", "caba"))
        val result = cmd.run(Environment(), null)
        assertNotNull(result)
        assertTrue(InputStreamUtils.equals(result!!, "abaca badaba caba".byteInputStream()))
    }
}