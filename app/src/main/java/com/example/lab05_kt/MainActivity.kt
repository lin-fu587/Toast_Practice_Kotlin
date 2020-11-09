package com.example.lab05_kt

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn =findViewById<Button>(R.id.button)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("請選擇功能")
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
                dialog.setNeutralButton("取消")
                { dialogInterface, i ->
                    Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
                }
                dialog.setNegativeButton("自定義Toast")
                { dialogInterface, i ->
                    showToast()
                }
                dialog.setPositiveButton("顯示list")
                { dialogInterface, i ->
                    showListDialog()
                }
                dialog.show()
            }
            fun showToast(){
                val toast =Toast(this@MainActivity)
                toast.setGravity(Gravity.TOP, 0, 50)
                toast.setDuration(Toast.LENGTH_SHORT)
                val inflater =getLayoutInflater()
                val layout =inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_root))
                toast.setView(layout)
                toast.show()
            }
            fun  showListDialog(){
                val list = arrayOf("message1", "message2", "message3", "message4", "message5")
                val DL1 =AlertDialog.Builder(this@MainActivity)
                DL1.setTitle("使用List呈現")
                DL1.setItems(list, DialogInterface.OnClickListener()
                { dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this@MainActivity,"你獲得的是"+list[i],Toast.LENGTH_SHORT).show()
                })
                DL1.show()
            }
        })
    }
}