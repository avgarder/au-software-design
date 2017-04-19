package ru.ifmo.rain.garder.cli.command

import org.junit.Assert
import org.junit.Test
import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by bronti on 19.04.17.
 */

class LsCommandTests {
    @Test
    fun testSimpleLs() {
        val cmd = LsCommand(listOf("testData"))
        val result = cmd.run(Environment(), null)
        Assert.assertNotNull(result)
        val res = BufferedReader(InputStreamReader(result)).readLine().split(' ').toSet()
        val exp = "file.txt dir".split(' ').toSet()
        Assert.assertEquals(exp, res)
    }
}