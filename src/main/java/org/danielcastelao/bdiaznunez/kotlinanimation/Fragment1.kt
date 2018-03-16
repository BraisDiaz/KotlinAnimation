package org.danielcastelao.bdiaznunez.kotlinanimation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_full_screen.*

class Fragment1 : Fragment() {

    companion object {

        var fragmentInicial = Fragment1()

        // definimos los argumentos, son los datos para usar entre el fragment y la activity

        fun nuevaInstance(key: String = "Inicio"): Fragment1 {

            // Recibimos variables en el companion

            Log.d("Mensajes", "En el fragmentInicial recibimos: ${key}")

            return fragmentInicial

        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,

                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.activity_full_screen, container, false)

    }

    override fun onDestroyView() {

        super.onDestroyView()

    }

}