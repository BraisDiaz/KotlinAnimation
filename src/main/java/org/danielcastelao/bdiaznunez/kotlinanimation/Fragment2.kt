package org.danielcastelao.bdiaznunez.kotlinanimation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity2_full_screen.*
import kotlinx.android.synthetic.main.fragment2.*


class Fragment2 : Fragment() {

    var datos : String = "Variable para datos"

    companion object {

        fun newInstance(): Fragment2 {

            var fragmentSecundario = Fragment2()

            return fragmentSecundario

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,

                              savedInstanceState: Bundle?): View? {


        // recogemos lo que nos manda la Activity

        datos = arguments.getString("datos", "Variable para datos")

        // Inflate the layout for this fragment

        val vistaFragment = inflater!!.inflate(R.layout.fragment2, container, false)

        return vistaFragment

    }


    override fun onResume() {

        super.onResume()

        editTextFragment2.setText(datos)

    }

}