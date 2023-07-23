package xyz.slkagura.reg.wrapper

import java.nio.file.FileSystems

class JNI {
    companion object {
        init {
            System.load(
                FileSystems.getDefault().getPath("libreg/build/shared/libreg.debug.dll").normalize().toAbsolutePath().toString()
            )
        }
        
        @JvmStatic
        external fun setUserPath(value:String):Long
        
        @JvmStatic
        external fun getUserPath():String
    }
}
