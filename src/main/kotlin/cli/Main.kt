package cli

import cli.command.ExitCommand
import cli.exception.InvalidUsageException
import cli.exception.RunException
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

fun main(args: Array<String>) {
    mainLoop@while (true) {
        print("> ")
        System.out.flush()
        val s = Shell.readString() ?: break
        val commands = CommandsBuilder.buildCommands(Shell.getEnvironment(), s)
        var lastStream: InputStream? = System.`in`
        for (command in commands) {
            if (command is ExitCommand) {
                return
            }
            try {
                lastStream = command.run(Shell.getEnvironment(), lastStream)
            } catch (e: InvalidUsageException) {
                println(e.message)
                continue@mainLoop
            } catch (e: RunException) {
                println(e.message)
                continue@mainLoop
            }
        }
        if (lastStream == null || lastStream == System.`in`) {
            continue
        }
        val reader = BufferedReader(InputStreamReader(lastStream))
        while (true) {
            val line = reader.readLine() ?: break
            println(line)
        }
    }
}