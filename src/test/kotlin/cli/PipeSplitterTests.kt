package cli

import org.junit.Test
import org.junit.Assert.*

class PipeSplitterTests {
    @Test
    fun test1() {
         assertEquals(PipeSplitter.splitPipes(listOf("cat", "file.txt", "|", "echo", "|", "cmd")),
                 listOf(listOf("cat", "file.txt"), listOf("echo"), listOf("cmd")))
    }
}