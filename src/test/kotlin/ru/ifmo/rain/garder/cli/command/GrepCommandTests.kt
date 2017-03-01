package ru.ifmo.rain.garder.cli.command

import org.junit.Test
import org.junit.Assert.*
import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.InputStreamUtils

class GrepCommandTests {
    @Test
    fun testSimple() {
        val text = "aa\nbaa\n\"aA\"\nz1\nz2"
        val cmd = GrepCommand(listOf("aa"))
        val res = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(res)
        assertTrue(InputStreamUtils.equals(res!!, "aa\nbaa".byteInputStream()))
    }

    @Test
    fun testCaseInsensitive() {
        val text = "aa\nbaa\n\"aA\"\nz1\nz2"
        val cmd = GrepCommand(listOf("-i", "aa"))
        val res = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(res)
        assertTrue(InputStreamUtils.equals(res!!, "aa\nbaa\n\"aA\"".byteInputStream()))
    }

    @Test
    fun testCaseInsensitiveWholeWord() {
        val text = "aa\nbaa\n\"aA\"\nz1\nz2"
        val cmd = GrepCommand(listOf("-i", "-w", "aa"))
        val res = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(res)
        assertTrue(InputStreamUtils.equals(res!!, "aa\n\"aA\"".byteInputStream()))
    }

    @Test
    fun testNextLines() {
        val text = "aa\nbaa\n\"aA\"\nz1\nz2"
        val cmd = GrepCommand(listOf("-A", "1", "aa"))
        val res = cmd.run(Environment(), text.byteInputStream())
        assertNotNull(res)
        assertTrue(InputStreamUtils.equals(res!!, "aa\nbaa\n\"aA\"".byteInputStream()))
    }
}