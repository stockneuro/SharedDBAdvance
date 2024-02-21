package com.app.shareddbadvance

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import com.app.shareddbadvance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initializing the shared prefrence
        sharedPreferences=getSharedPreferences("NoteData", Context.MODE_PRIVATE)

//        storing data
        binding.saveNoteButton.setOnClickListener(View.OnClickListener {
            val note=binding.notesEditText.text.toString()

            val sharedEdit=sharedPreferences.edit()
            sharedEdit.putString("note",note)
            sharedEdit.apply()
            Toast.makeText(this,"Note Stored suceessfully",Toast.LENGTH_LONG).show()
            binding.notesEditText.text.clear()
        })

//        for getting data
        binding.displayNoteButton.setOnClickListener(View.OnClickListener {
            val storednote=sharedPreferences.getString("note","")
            binding.noteTextView.text="$storednote"
        })

    }
}