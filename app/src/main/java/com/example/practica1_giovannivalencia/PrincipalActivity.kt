package com.example.practica1_giovannivalencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.R
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.practica1_giovannivalencia.databinding.ActivityPrincipalBinding
import java.util.*


class PrincipalActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityPrincipalBinding
    private lateinit var aaFormulas: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        aaFormulas = ArrayAdapter<String>(this,
            R.layout.simple_spinner_dropdown_item)

        aaFormulas.addAll(Arrays.asList("Seleccione...","Área del Triángulo",
            "Área del Rectángulo", "Volumen del Cilindro" ))

        with(binding){

            spinnerFormulas.onItemSelectedListener = this@PrincipalActivity
            spinnerFormulas.adapter = aaFormulas
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        /***************************************************/
        ocultarFormulas()
        ocultarElementos()
        /***************************************************/

        /***************************************************/
        //Para seleccionar las formulas
        val formulaSelected = aaFormulas.getItem(position)
        binding.tvSelected.text = position.toString()
        val selecciona = Integer.parseInt(binding.tvSelected.text.toString())

        /***************************************************/

        /***************************************************/
        bandera(selecciona)
        /***************************************************/

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    /***************************************************/
    fun bandera(digito: Int){

        val digito = digito

        if (digito == 0){

            Toast.makeText(this@PrincipalActivity, "Por favor ingrese una formula.",
                Toast.LENGTH_SHORT).show()
            //Toast.makeText(this@PrincipalActivity, getString(R.string.), Toast.LENGTH_SHORT).show()

        }else if(digito == 1){

            Toast.makeText(this@PrincipalActivity, "Dato 1 es la base, Dato 2 es la altura.",
                Toast.LENGTH_SHORT).show()

            limpiarElementos()
            binding.imgvTriangulo.visibility = View.VISIBLE
            mostrarElementos()

        }else if(digito == 2){

            Toast.makeText(this@PrincipalActivity, "Dato 1 es la base, Dato 2 es la altura.",
                Toast.LENGTH_SHORT).show()

            limpiarElementos()
            binding.imgRectanfulo.visibility = View.VISIBLE
            mostrarElementos()
        }
        else if(digito == 3){

            Toast.makeText(this@PrincipalActivity, "Dato 1 es el radio, Dato 2 es la altura.",
                Toast.LENGTH_SHORT).show()

            limpiarElementos()
            binding.imgvcilindro.visibility = View.VISIBLE
            mostrarElementos()
        }

    }
    /***************************************************/

    /***************************************************/
    fun click(view: View) {

        if (validaCampos()){

            //Obtengo datos de los inputs
            val numero1 = Integer.parseInt(binding.etnumero1.text.toString())
            val numero2 = Integer.parseInt(binding.etnumero2.text.toString())
            val bandera = Integer.parseInt(binding.tvSelected.text.toString())


            /***************************************************/
            //Caso Triangulo
            if (bandera == 1){
                if (areaTriangulo(numero1,numero2)){
                    val areaT = (numero1 * numero2) / 2
                    binding.tvResultado.text = "El área del triángulo es:  $areaT"
                    return
                }else{
                    binding.tvResultado.text = "No se puede calcular su área"
                }
            }
            /***************************************************/

            /***************************************************/
            //Caso Rectangulo
            if (bandera == 2){
                if (areaRectangulo(numero1,numero2)){
                    val areaR = (numero1 * numero2)
                    binding.tvResultado.text = "El área del rectángulo es:  $areaR"
                    return
                }else{
                    binding.tvResultado.text = "No se puede calcular su área"
                }
            }
            /***************************************************/

            /***************************************************/
            //Caso Volumen del cilindro
            if (bandera == 3){
                if (volumenCilindro(numero1,numero2)){
                    val radio = 3.1416
                    val volumen = ((radio)*(numero1*numero1)*numero2)
                    binding.tvResultado.text = "El volumen del cilindro es:  $volumen"
                    return
                }else{
                    binding.tvResultado.text = "No se puede calcular su volumen"
                }
            }
            /***************************************************/

        }else{
            Toast.makeText(this, "Por favor ingrese un número.",
                Toast.LENGTH_SHORT).show()
        }

    }
    /***************************************************/

    /***************************************************/
    //Formulas
    private fun areaTriangulo(numero1: Int, numero2: Int): Boolean{

        if(numero1 ==0 && numero2 ==0) return false
        else{
            return true
        }

    }

    private fun areaRectangulo(numero1: Int, numero2: Int): Boolean{

        if(numero1 ==0 && numero2 ==0) return false
        else{
            return true
        }

    }

    //Cilindro
    private fun volumenCilindro(numero1: Int, numero2: Int): Boolean{

        if(numero1 ==0 && numero2 ==0) return false
        else{
            return true
        }

    }


    /***************************************************/

    /***************************************************/
    private  fun validaCampos(): Boolean{

        val num1 = binding.etnumero1.text.toString()
        val num2 = binding.etnumero2.text.toString()

        if (num1 == ""){
            binding.etnumero1.error = "Se requiere un número."
            binding.etnumero1.requestFocus()
            return false
        }else if(num2 == ""){
            binding.etnumero2.error = "Se requiere un número."
            binding.etnumero2.requestFocus()
            return false

        }else{
            return true
        }

    }
    /***************************************************/

    /***************************************************/
    fun mostrarElementos(){

        binding.dato1.visibility = View.VISIBLE
        binding.etnumero1.visibility = View.VISIBLE
        binding.dato2.visibility = View.VISIBLE
        binding.etnumero2.visibility = View.VISIBLE
        binding.tvResultado.visibility = View.VISIBLE
        binding.btnResultado.visibility = View.VISIBLE

    }
    /***************************************************/

    /***************************************************/
    fun ocultarElementos(){

        binding.tvSelected.visibility = View.INVISIBLE
        binding.dato1.visibility = View.INVISIBLE
        binding.etnumero1.visibility = View.INVISIBLE
        binding.dato2.visibility = View.INVISIBLE
        binding.etnumero2.visibility = View.INVISIBLE
        binding.tvResultado.visibility = View.INVISIBLE
        binding.btnResultado.visibility = View.INVISIBLE

    }
    /***************************************************/

    /***************************************************/
    fun ocultarFormulas(){

        binding.imgvTriangulo.visibility = View.INVISIBLE
        binding.imgRectanfulo.visibility = View.INVISIBLE
        binding.imgvcilindro.visibility = View.INVISIBLE

    }
    /***************************************************/

    /***************************************************/
    fun limpiarElementos(){

        binding.etnumero1.setText("")
        binding.etnumero2.setText("")
        binding.tvResultado.setText("")
        //binding.tvSelected.setText("")
    }
    /***************************************************/














}