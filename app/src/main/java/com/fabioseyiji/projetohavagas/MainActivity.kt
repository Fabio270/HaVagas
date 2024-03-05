package com.fabioseyiji.projetohavagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.fabioseyiji.projetohavagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        with(amb) {
            adicionarCelularCb.setOnClickListener {
                if (adicionarCelularCb.isChecked) celularLl.visibility = View.VISIBLE
                else celularLl.visibility = View.GONE
            }
        }

        with(amb) {
            formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    gradEspecializacaoLl.visibility = when (position) {
                        0, 1 -> View.GONE
                        else -> View.VISIBLE
                    }
                    mestradoDoutoradoLl.visibility = when (position) {
                        in 0..2 -> View.GONE
                        else -> View.VISIBLE
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Não é necessário fazer nada aqui, a menos que seja necessário algum comportamento específico.
                }
            }
        }

        with(amb){
            limparBt.setOnClickListener {
                nomeEt.text.clear()
                emailEt.text.clear()
                emailCb.isChecked = false
                telefoneEt.text.clear()
                telefoneRg.clearCheck()
                adicionarCelularCb.isChecked = false
                celularLl.visibility = View.GONE
                celularEt.text.clear()
                femininoBt.isChecked = true
                dataNascEt.text.clear()
                formacaoSp.setSelection(0)
                anoConclusaoEt.text.clear()
                gradEspecializacaoLl.visibility = View.GONE
                instituicaoEt.text.clear()
                mestradoDoutoradoLl.visibility = View.GONE
                monografiaEt.text.clear()
                orientadorEt.text.clear()
                vagasEt.text.clear()
            }
        }
    }
}