import java.util.Scanner
import UserManager

data class User(val username: String, val password: String)

fun main() {
    val userManager = UserManager()
    val app = Application(userManager)
    app.run()
}
