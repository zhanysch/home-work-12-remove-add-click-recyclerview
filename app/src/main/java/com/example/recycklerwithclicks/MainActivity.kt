package com.example.recycklerwithclicks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recl: RecyclerView?=null
    val adapter1 = showAdapter()
    private var edt: EditText?=null
    private var btn: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SView()
        sRecycler()
        Listener()
    }

    private fun SView() {
        recl = findViewById(R.id.recl)
        edt=findViewById(R.id.edt)
        btn=findViewById(R.id.btn)
    }


    private fun sRecycler() {
        recl?.adapter=adapter1
        adapter1.update(getDAta())
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {               /// <--для того чтобы menux xml появилось в main activity
        menuInflater.inflate(R.menu.menu_main, menu)
        adapter1.add(Dataclass(1,"blabla1","bla1.1"))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sett->adapter1.add(Dataclass(1,"hello1","hello2"))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun Listener() {
        btn?.setOnClickListener {
            !edt?.text.isNullOrEmpty()
            adapter1.remove(edt?.text.toString().toInt())
        }
    }

    private fun getDAta(): ArrayList<Dataclass>  {
        val list = arrayListOf<Dataclass>()
        for (i in 0..200){
            list.add(Dataclass(R.drawable.ic_im,"go bla-bla$i","0$i"))
        }

         return list
    }
}
