import kotlin.system.exitProcess

class MainKt {
    companion object{
        @JvmStatic fun main(args: Array<String>) {
            if (args.size != 1) {
                println("Run: java -jar file-auth.jar C:\\FuncoesResumo - SHA1.mp4")
                exitProcess(1)
            }
            FileUtil().split(args[0])
        }
    }
}
