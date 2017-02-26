package cli

import org.junit.Test
import org.junit.Assert.*

class TokenizerTests {
    @Test
    fun test1() {
        assertEquals(Tokenizer.tokenize("  ababa   \"aa'a\" zz 'b\"bb' | aa   "),
                listOf("ababa", "aa'a", "zz", "b\"bb", "|", "aa"))
    }
}