package xyz.slkagura.reg

import xyz.slkagura.reg.wrapper.JNI

fun main() {
    val userPath = JNI.getUserPath()
    val pathList = userPath.split(";") as MutableList
    pathList.forEachIndexed { index, path ->
        println("$index: $path")
    }
    val builder = StringBuilder()
    pathList.forEach {
        if (it.isNotEmpty()) {
            builder.append(it).append(";")
        }
    }
    println(builder)
}
