package com.example.aula01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val inputPeso = edtPeso.text.toString()
            val inputAltura = edtAltura.text.toString()

            if (inputPeso.isNotEmpty() && inputAltura.isNotEmpty()) {
                try {
                    val peso = inputPeso.toFloat()
                    val altura = inputAltura.toFloat()

                    if (altura > 0 && peso > 0) {
                        val imc = peso / (altura * altura)
                        txtResultado.text = "Seu IMC é: %.2f".format(imc)

                        if (imc < 16) {
                            txtResultado.append("\nClassificação: Magreza grave")
                        } else if (imc >= 16.0 && imc < 17.0) {
                            txtResultado.append("\nClassificação: Magreza moderada")
                        } else if (imc >= 17.0 && imc < 18.5) {
                            txtResultado.append("\nClassificação: Magreza leve")
                        } else if (imc >= 18.5 && imc < 25.0) {
                            txtResultado.append("\nClassificação: Peso normal")
                        } else if (imc >= 25.0 && imc < 30.0) {
                            txtResultado.append("\nClassificação: Sobrepeso")
                        } else if (imc >= 30.0 && imc < 35.0) {
                            txtResultado.append("\nClassificação: Obesidade grau I")
                        } else if (imc >= 35.0 && imc < 40.0) {
                            txtResultado.append("\nClassificação: Obesidade grau II")
                        } else if (imc >= 40.0) {
                            txtResultado.append("\nClassificação: Obesidade grau III (mórbida)")
                        }

                    } else {
                        Toast.makeText(this, "Valores devem ser maior que zero", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, insira valores numéricos válidos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}