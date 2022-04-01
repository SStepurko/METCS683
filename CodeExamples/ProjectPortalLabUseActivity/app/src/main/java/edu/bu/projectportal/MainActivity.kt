package edu.bu.projectportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    private lateinit var projTitle: TextView
    private lateinit var projDesc: TextView
    private lateinit var editProj: ImageButton
    private lateinit var projAuthor: TextView
    private lateinit var link: TextView
    private lateinit var isFavorite: Switch
    private lateinit var keywords: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        projTitle = findViewById(R.id.projTitle)
        projDesc =  findViewById(R.id.projDesc)
        projAuthor = findViewById(R.id.projAuthor)
        link = findViewById(R.id.gitLink)
        isFavorite = findViewById(R.id.switch1)
        keywords = findViewById(R.id.Keywords)

        editProj = findViewById(R.id.editProj)

        projTitle.text =  Project.project.title
        projDesc.text = Project.project.description
        projAuthor.text = Project.project.author
        link.text = Project.project.gitLink
        isFavorite.isChecked = Project.project.isFavorite

        Project.project.keywords.forEach { keyword ->
            val chip = (this.layoutInflater.inflate(R.layout.item_chip, null, false) as? Chip)?.apply {
                text = keyword.name
                isChecked = keyword.isChecked
                setPadding(8,0,8,0)
                isClickable = false
            }

            keywords.addView(chip)
        }

        editProj.setOnClickListener {
            startActivity(Intent(this, EditProjectActivity::class.java))
        }
    }

}