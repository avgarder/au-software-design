package cli.command

import cli.Environment
import cli.exception.InvalidUsageException
import cli.exception.RunException
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream

abstract class Command(protected val args: List<String>) {

    /**
     * runs command
     * @return output of the command
     */
    abstract fun run(env: Environment, input: InputStream?): InputStream?

    open fun getUsage(): String {
        throw UnsupportedOperationException()
    }

    open fun getInput(file: String?, input: InputStream?): InputStream? {
        if (file == null && input == null) {
            throw InvalidUsageException(this)
        }
        if (file != null) {
            try {
                return FileInputStream(file)
            } catch (e: FileNotFoundException) {
                throw RunException("file not found: $file")
            }
        }
        return input
    }
}