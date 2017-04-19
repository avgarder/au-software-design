package ru.ifmo.rain.garder.cli.command

import org.junit.Assert
import org.junit.Test
import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import java.io.File
import java.nio.file.Paths

/**
 * Created by bronti on 19.04.17.
 */

class CdCommandTest {
    @Test
    fun testSimpleLs() {
        var cmd = CdCommand(listOf("testData/"))

        val pwd = File("").absolutePath
        var result = cmd.run(Environment(), null)

        Assert.assertNotNull(result)
        Assert.assertTrue(InputStreamUtils.equals(result!!, "".byteInputStream()))
        Assert.assertEquals(pwd + "/testData", File("").absolutePath)

        cmd = CdCommand(listOf("../"))
        result = cmd.run(Environment(), null)

        Assert.assertNotNull(result)
        Assert.assertTrue(InputStreamUtils.equals(result!!, "".byteInputStream()))
        Assert.assertEquals(pwd, File("").absolutePath)
    }
}