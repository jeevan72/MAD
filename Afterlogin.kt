import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loguserTxt: EditText
    private lateinit var logpassTxt: EditText
    private lateinit var signInBtn: Button

    private var user: String? = null
    private var pass: String? = null
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        loguserTxt = findViewById(R.id.etLoginUser)
        logpassTxt = findViewById(R.id.etLoginPass)
        signInBtn = findViewById(R.id.btnLogin)

        user = intent.getStringExtra("username")
        pass = intent.getStringExtra("password")

        signInBtn.setOnClickListener {

            val user1 = loguserTxt.text.toString()
            val pass1 = logpassTxt.text.toString()

            if (user == user1 && pass == pass1) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            } else {
                count++
                if (count == 3) {
                    signInBtn.isEnabled = false
                    Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Login Failed, Try Again ($count)", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
