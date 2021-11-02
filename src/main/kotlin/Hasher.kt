import java.security.MessageDigest

class Hasher {
    fun sha256(input: ByteArray): ByteArray {
        return hashString(input, "SHA-256")
    }

    private fun hashString(input: ByteArray, algorithm: String): ByteArray {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input)
    }
}