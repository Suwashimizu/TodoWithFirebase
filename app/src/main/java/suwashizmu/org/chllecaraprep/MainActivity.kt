package suwashizmu.org.chllecaraprep

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Userの取得
        val currentUser = FirebaseAuth.getInstance().currentUser

        //登録画面の表示
        if (savedInstanceState == null) {
            if (currentUser == null) {
                //ログイン・登録画面を表示
                gotoSignUp()
            } else {
                //TODO画面を表示
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.container, TodoListFragment.newInstance())
                        .commit()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {

                val user = FirebaseAuth.getInstance().currentUser

                Log.d("MainActivity", user.toString())

                finish()

                //ログイン成功後もう一度MainActivityを起動する
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    fun gotoSignUp() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(listOf(AuthUI.IdpConfig.EmailBuilder().build()))
                        .build(), RC_SIGN_IN)
    }
}
