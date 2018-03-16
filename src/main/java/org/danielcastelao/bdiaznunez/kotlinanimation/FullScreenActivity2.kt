package org.danielcastelao.bdiaznunez.kotlinanimation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity2_full_screen.*

class FullScreenActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity2_full_screen)

        botonVolver.setOnClickListener{

            val activity1 = Intent(this,FullScreenActivity::class.java)

            startActivity(activity1)

        }

    }

}