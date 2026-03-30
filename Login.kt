import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    private lateinit var unameTxt: EditText
    private lateinit var passTxt: EditText
    private lateinit var signupBtn: Button

    val p1 = Pattern.compile("[^a-zA-Z0-9]")
    val p2 = Pattern.compile("(?=.*[a-z])")
    val p3 = Pattern.compile("(?=.*[A-Z])")
    val p4 = Pattern.compile("(?=.*[0-9])")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        unameTxt = findViewById(R.id.etUsername)
        passTxt = findViewById(R.id.etPassword)
        signupBtn = findViewById(R.id.btnSignup)

        signupBtn.setOnClickListener {

            val uname = unameTxt.text.toString()
            val pass = passTxt.text.toString()

            val isValid = p1.matcher(pass).find() &&
                    p2.matcher(pass).find() &&
                    p3.matcher(pass).find() &&
                    p4.matcher(pass).find() &&
                    pass.length >= 8

            if (isValid) {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("username", uname)
                intent.putExtra("password", pass)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
