package org.danielcastelao.bdiaznunez.kotlinanimation

import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_full_screen.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.*
import kotlin.coroutines.experimental.CoroutineContext


class FullScreenActivity : AppCompatActivity() {

    private val uiContext: CoroutineContext = UI
    private val bgContext: CoroutineContext = CommonPool

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        val activity2 = Intent(this, FullScreenActivity2::class.java)

        val numero : Int = valorRandom(1..3)

        btnNewGame.setOnClickListener {

            esconderBola()

        }

        vaso1.setOnClickListener {

            animarVaso1()

            if(numero == 1){
            startActivity(activity2)
            }
        }

        // evento click en el vaso2

        vaso2.setOnClickListener {

            animarVaso2()

            if(numero == 2) {
                startActivity(activity2)
            }
        }

        // evento click en el vaso3

        vaso3.setOnClickListener {
            animarVaso3()

            if(numero == 3) {
                startActivity(activity2)
            }
        }

    }

    // para cambiar los sentidos de las animaciones

    var j : Int = 1

    // tarea en segundo plano del vaso3


    private fun esconderBola() = launch(uiContext){

        // aumentamos o disminuimos alternadamente

        j *= 1

        // animacion: escalamos en la direccion X

        val objectAnimator1 = ObjectAnimator.ofFloat(

                vaso1,

                "translationY",

                1000f * j)

        objectAnimator1.duration = 500L

        objectAnimator1.interpolator

        objectAnimator1.start()

        val objectAnimator2 = ObjectAnimator.ofFloat(

                vaso2,

                "translationY",

                1000f * j)

        objectAnimator2.duration = 500L

        objectAnimator2.interpolator

        objectAnimator2.start()

        val objectAnimator3 = ObjectAnimator.ofFloat(

                vaso3,

                "translationY",

                1000f * j)

        objectAnimator3.duration = 500L

        objectAnimator3.interpolator

        objectAnimator3.start()

    }

    private fun valorRandom(valores: IntRange) : Int {
        var r = Random()
        var valorRandom = r.nextInt(valores.last - valores.first) + valores.first
        return valorRandom
    }

    private fun animarVaso3() = launch(uiContext) {

        // aumentamos o disminuimos alternadamente

        j *= -1

        // animacion: escalamos en la direccion X

        val objectAnimator = ObjectAnimator.ofFloat(

                vaso3,

                "translationX",

                 100f * j)

        objectAnimator.duration = 1000L

        objectAnimator.interpolator

        objectAnimator.start()

    }

    // tarea en segundo plano del vaso2

    private fun animarVaso2() = launch(uiContext) {

        // izquierda o derecha alternadamente

        j *= -1

        // animacion: trasladamos en la direccion X

        val objectAnimator = ObjectAnimator.ofFloat(

                vaso2,

                "translationX",

                100f * j)

        objectAnimator.duration = 3000L

        objectAnimator.interpolator

        objectAnimator.start()

    }

    // tarea en segundo plano del vaso1

    private fun animarVaso1() = launch(uiContext) {

        //arriba o abajo alternadamente

        j *= -1

        // animacion: trasladamos en la direccion Y

        val objectAnimator = ObjectAnimator.ofFloat(

                vaso1,

                "translationX",

                100f * j)

        //objectAnimator.duration = 3000L

        objectAnimator.interpolator

        objectAnimator.start()

    }

}
