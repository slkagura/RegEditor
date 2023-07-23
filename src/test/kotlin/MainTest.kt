import org.junit.Test
import xyz.slkagura.reg.wrapper.JNI

class MainTest {
    @Test
    fun getUserPath() {
        println(JNI.getUserPath())
    }
    
    @Test
    fun setUserPath() {
        val userPath = JNI.getUserPath()
        JNI.setUserPath(userPath)
    }
}
