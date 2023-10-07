package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity() : AppCompatActivity(), View.OnClickListener, Parcelable {

    private lateinit var etName : EditText
    private lateinit var etUsername : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etName = findViewById(R.id.edt_name)
        etUsername = findViewById(R.id.edt_username)
        etEmail = findViewById(R.id.edt_Email)
        etPassword = findViewById(R.id.edt_password)

        val btnRegister: Button =findViewById(R.id.btn_Register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn_Register -> {

                    val bundle = Bundle()
                    bundle.putString("username", etUsername.text.toString())
                    bundle.putString("password", etPassword.text.toString())

                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra(bundle)
                    startActivity(intent)
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterActivity> {
        override fun createFromParcel(parcel: Parcel): RegisterActivity {
            return RegisterActivity(parcel)
        }

        override fun newArray(size: Int): Array<RegisterActivity?> {
            return arrayOfNulls(size)
        }
    }
}

private fun Intent.putExtra(bundle: Bundle) {

}
