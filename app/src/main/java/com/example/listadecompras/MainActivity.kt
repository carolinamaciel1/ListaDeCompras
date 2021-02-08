package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

//        list_produtos.setOnLongClickListener { adapterView: Adapt
//            erView<*>, view: View, position: Int, id: Long -> }
//    }
    }
}