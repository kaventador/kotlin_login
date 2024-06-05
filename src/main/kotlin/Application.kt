import java.util.*

class Application(private val userManager: UserManager) {
    private val scanner = Scanner(System.`in`)
    private var currentUser: User? = null

    fun run() {
        while (true) {
            if (currentUser == null) {
                showInitialMenu()
            } else {
                showLoggedInMenu()
            }
        }
    }

    private fun showInitialMenu() {
        println("1. ثبت‌نام")
        println("2. لاگین")
        //println("3. خروج")

        when (scanner.nextLine()) {
            "1" -> handleRegister()
            "2" -> handleLogin()
            "3" -> {
                println("خروج از برنامه")
                System.exit(0)
            }
            else -> println("گزینه نامعتبر است. لطفا دوباره تلاش کنید.")
        }
    }

    private fun showLoggedInMenu() {
        println("خوش آمدید، ${currentUser!!.username}")
        println("1. خروج از حساب کاربری")
        println("2. خروج از برنامه")

        when (scanner.nextLine()) {
            "1" -> logout()
            "2" -> {
                println("خروج از برنامه")
                System.exit(0)
            }
            else -> println("گزینه نامعتبر است. لطفا دوباره تلاش کنید.")
        }
    }

    private fun handleRegister() {
        println("لطفا نام کاربری خود را وارد کنید:")
        val username = scanner.nextLine()
        println("لطفا رمز عبور خود را وارد کنید:")
        val password = scanner.nextLine()
        userManager.register(username, password)
    }

    private fun handleLogin() {
        println("لطفا نام کاربری خود را وارد کنید:")
        val username = scanner.nextLine()
        println("لطفا رمز عبور خود را وارد کنید:")
        val password = scanner.nextLine()
        currentUser = userManager.login(username, password)
    }

    private fun logout() {
        currentUser = null
        println("شما از حساب کاربری خود خارج شدید.")
    }
}