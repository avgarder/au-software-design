package ru.ifmo.rain.garder.cli.command

import org.junit.Assert
import org.junit.Test
import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils
import java.io.File
import java.nio.file.Paths

class CdCommandTest {
    @Test
    fun testSimpleCd() {
        var cmd = CdCommand(listOf("testData" + File.separator))

        val pwd = File("").absolutePath
        var result = cmd.run(Environment(), null)

        Assert.assertNotNull(result)
        Assert.assertTrue(InputStreamUtils.equals(result!!, "".byteInputStream()))
        Assert.assertEquals(pwd + File.separator + "testData", File("").absolutePath)

        CdCommand(listOf(".." + File.separator)).run(Environment(), null)
    }

    @Test
    fun testReturnCd() {
        val pwd = File("").absolutePath
        CdCommand(listOf("testData" + File.separator)).run(Environment(), null)

        val cmd = CdCommand(listOf(".." + File.separator))
        val result = cmd.run(Environment(), null)

        Assert.assertNotNull(result)
        Assert.assertTrue(InputStreamUtils.equals(result!!, "".byteInputStream()))
        Assert.assertEquals(pwd, File("").absolutePath)
    }
}