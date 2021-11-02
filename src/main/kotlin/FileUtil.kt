import java.nio.file.Files
import java.nio.file.Path

class FileUtil {
    fun split(path: String) {
        val bytes = Files.readAllBytes(Path.of(path)).toList()
        val chunks = bytes.chunked(1024)
        val lastChunk = chunks.last()
        var hash = Hasher().sha256(lastChunk.toByteArray())
        println("""Chunk[n-1]: ${byteArrayToString(hash)}""")
        for (i in chunks.indices.reversed()) {
            if (i < chunks.size -1 )
                hash = Hasher().sha256(concat(chunks[i].toByteArray(), hash))
        }
        println("""Chunk[0]: ${byteArrayToString(hash)}""")
    }

    private fun byteArrayToString(byteArray: ByteArray): String {
        return byteArray.fold("") { str, it -> str + "%02x".format(it) }
    }

    private fun concat(a: ByteArray, b: ByteArray): ByteArray {
        val c = ByteArray(a.size + b.size);
        System.arraycopy(a, 0, c, 0, a.size);
        System.arraycopy(b, 0, c, a.size, b.size);
        return c;
    }
}
