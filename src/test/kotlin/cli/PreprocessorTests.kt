package cli

import org.junit.Test
import org.junit.Assert.*

class PreprocessorTests {
    @Test
    fun test1() {
        val env = Environment()
        env.setValue("aa", "bb")
        assertEquals(Preprocessor.preprocess(env, "some text \$aaa \$aa aa \$bb"), "some text \$aaa bb aa \$bb")
    }
}