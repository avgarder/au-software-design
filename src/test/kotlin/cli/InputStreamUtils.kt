package cli

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class InputStreamUtils {
    companion object {
        fun equals(a: InputStream, b: InputStream): Boolean {
            val readerA = BufferedReader(InputStreamReader(a))
            val readerB = BufferedReader(InputStreamReader(b))

            while (true) {
                val byteA = readerA.read()
                val byteB = readerB.read()
                if (byteA != byteB) {
                    return false
                }
                if (byteA == -1) {
                    break
                }
            }
            return true
        }
    }
}