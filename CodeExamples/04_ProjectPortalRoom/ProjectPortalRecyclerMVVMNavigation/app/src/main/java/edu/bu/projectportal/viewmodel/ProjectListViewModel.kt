package edu.bu.projectportal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.bu.projectportal.datalayer.Project
import edu.bu.projectportal.ProjectPortalApplication
import edu.bu.projectportal.datalayer.ProjectDao
import java.util.concurrent.Executors
/*
Create a ViewModel class to keep track of the Project list
Use AndroidViewModel as the super class, we can pass the
application object directly to it.
 */
class ProjectListViewModel(application: Application): AndroidViewModel(application) {
    // pass the projectportalApplication as a parameter
    // make sure to define the application name in the manifest file.
    val projectportalDatabase = (application as ProjectPortalApplication).projectportalDatabase
    val projectDao = projectportalDatabase.projectDao()

    private val _projectList: LiveData<List<Project>> = projectDao.getAllProjects()
    val projectList:LiveData<List<Project>>
        get() = _projectList

    fun getAllProjects(): LiveData<List<Project>> {
        return projectDao.getAllProjects()
    }

    fun addProject(project: Project) {
        Executors.newSingleThreadExecutor().execute {
            projectDao.addProject(project)
        }
    }

    fun delProject(project: Project) {
        Executors.newSingleThreadExecutor().execute {
            projectDao.delProject(project)
        }
    }

}