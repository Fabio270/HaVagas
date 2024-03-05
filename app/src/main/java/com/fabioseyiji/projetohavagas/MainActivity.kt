package com.fabioseyiji.projetohavagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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
                femininoRb.isChecked = true
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

        with(amb){
            salvarBt.setOnClickListener{
                val mensagem = buildString {
                    append("Nome completo: ${nomeEt.text}\n")
                    append("Email: ${emailEt.text}\n")
                    append("Cadastrado na lista de emails: ${if (emailCb.isChecked) "Sim" else "Não"}\n")
                    append("Telefone: ${telefoneEt.text}\n")
                    append("Tipo de telefone: ${if (comercial.isChecked) "Comercial" else "Residencial"}\n")

                    if (adicionarCelularCb.isChecked) {
                        append("Celular: ${celularEt.text}\n")
                    }

                    append("Sexo: ${if (masculinoRb.isChecked) "Masculino" else "Feminino"}\n")
                    append("Data de nascimento: ${dataNascEt.text}\n")
                    append("Formação: ${formacaoSp.selectedItem}\n")

                    when (formacaoSp.selectedItemPosition) {
                        in 0..3 -> append("Ano de conclusão: ${anoConclusaoEt.text}\n")
                        in 4..5 -> {
                            append("Ano de conclusão: ${anoConclusaoEt.text}\n")
                            append("Instituição: ${instituicaoEt.text}\n")
                            if (formacaoSp.selectedItemPosition == 5) {
                                append("Título de monografia: ${monografiaEt.text}\n")
                                append("Orientador: ${orientadorEt.text}\n")
                            }
                        }
                    }

                    append("Vagas de interesse: ${vagasEt.text}")
                }

                Toast.makeText(this@MainActivity, mensagem, Toast.LENGTH_LONG).show()
            }
        }
    }
}