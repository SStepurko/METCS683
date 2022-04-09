package edu.bu.projectportal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.bu.projectportal.adapter.MyProjListRecyclerViewAdapter
import edu.bu.projectportal.databinding.MainActivitySlidepaneBinding
import edu.bu.projectportal.datalayer.Project

class MainActivity : AppCompatActivity(), MyProjListRecyclerViewAdapter.OnProjectClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_slidepane)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            findViewById<FragmentContainerView>(R.id.detailContainerId)
                ?.findNavController()?.navigate(R.id.action_detailFragment_to_addFragment)
            findViewById<SlidingPaneLayout>(R.id.slidepane).open()

        }
    }
   

    override fun onBackPressed() {
        findViewById<SlidingPaneLayout>(R.id.slidepane).close()
        hideKeyboard()
    }

    override fun onProjectClick(project: Project){
        findViewById<SlidingPaneLayout>(R.id.slidepane).open()
    }

    private fun hideKeyboard() {
        // Check if no view has focus:
        val view = currentFocus
        if (view != null) {
            val inputManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}