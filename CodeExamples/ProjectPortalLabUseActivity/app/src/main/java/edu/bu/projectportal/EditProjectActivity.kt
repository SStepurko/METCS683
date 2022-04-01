package edu.bu.projectportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class EditProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_project)

        val projTitle = findViewById<EditText> (R.id.projTitleEdit)
        val projDesc =  findViewById<EditText> (R.id.projDescEdit)
        val projAuthor = findViewById<EditText>(R.id.projAuthorEdit)
        val link = findViewById<EditText>(R.id.gitLinkEdit)
        val isFavorite = findViewById<Switch>(R.id.switch1edit)
        val keywords = findViewById<ChipGroup>(R.id.KeywordsEdit)

        val submit = findViewById<Button>(R.id.submit)
        val cancel = findViewById<Button>(R.id.cancel)

        projTitle.setText(Project.project.title)
        projDesc.setText(Project.project.description)
        projAuthor.setText(Project.project.author)
        link.setText(Project.project.gitLink)
        isFavorite.isChecked = Project.project.isFavorite

        isFavorite.setOnCheckedChangeListener { _, b ->
            Project.project.isFavorite = b
        }

        Project.project.keywords.forEach { keyword ->
            val chip = (this.layoutInflater.inflate(R.layout.item_chip, null, false) as? Chip)?.apply {
                text = keyword.name
                isChecked = keyword.isChecked
                setPadding(8,0,8,0)
                isClickable = true
                setOnCheckedChangeListener { _, _ ->
                    Project.project.keywords.firstOrNull { it.name == keyword.name }?.let { it.isChecked = !it.isChecked }
                }
            }

            keywords.addView(chip)
        }

        val editProjDoneListener = View.OnClickListener{ view ->
            if (view.id == R.id.submit) {
                Project.project.title = projTitle.text.toString()
                Project.project.description = projDesc.text.toString()
                Project.project.author = projAuthor.text.toString()
                Project.project.gitLink = link.text.toString()
            }
            startActivity(Intent(this, MainActivity::class.java))

        }

        submit.setOnClickListener (editProjDoneListener)
        cancel.setOnClickListener (editProjDoneListener)

    }
}