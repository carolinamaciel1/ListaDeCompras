package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

//A classe AppCompatActivity herda de Activity porém ela atinge uma quantidade maior de
// aparelhos e SO's
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produto = findViewById<EditText>(R.id.txt_produto)
        val list_produtos = findViewById<ListView>(R.id.list_view_produtos)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)

        val produtos_adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //definindo o adaptador da lista
        list_produtos.adapter = produtos_adapter

        btn_inserir.setOnClickListener {
            if (produto.text.isNotEmpty()) {
                //adicionando elemento na lista
                produtos_adapter.add(produto.text.toString())

                //limpando o elemento do editText
                produto.text.clear()
            } else {
                produto.error = "Preencha um valor"
            }

        }


        list_produtos.setOnItemLongClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            //buscando o item clicado
            val item = produtos_adapter.getItem(position)

            //removendo o item clicado da lista
            produtos_adapter.remove(item)

            Toast.makeText(this, "Item excluído!", Toast.LENGTH_SHORT).show()
            //retorno indicando que o click foi realizado com sucesso

            true
        }
    }
}
