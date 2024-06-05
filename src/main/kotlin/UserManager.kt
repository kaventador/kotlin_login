import java.util.Scanner

class UserManager {
    private val users = mutableMapOf<String, User>()

    fun register(username: String, password: String): Boolean {
        if (users.containsKey(username)) {
            println("این نام کاربری قبلا ثبت شده است.")
            return false
        }
        users[username] = User(username, password)
        println("ثبت‌نام با موفقیت انجام شد.")
        return true
    }

    fun login(username: String, password: String): User? {
        val user = users[username]
        if (user != null && user.password == password) {
            println("ورود با موفقیت انجام شد.")
            return user
        }
        println("نام کاربری یا رمز عبور اشتباه است.")
        return null
    }
}