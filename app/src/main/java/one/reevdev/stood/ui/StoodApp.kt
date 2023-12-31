package one.reevdev.stood.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.reevdev.stood.features.task.navigation.TaskScreens
import one.reevdev.stood.features.task.navigation.navigateToAddTaskScreen
import one.reevdev.stood.features.task.navigation.navigateToDetail
import one.reevdev.stood.features.task.navigation.taskAddTaskScreen
import one.reevdev.stood.features.task.navigation.taskDetailScreen
import one.reevdev.stood.features.task.navigation.taskScreen

@Composable
fun StoodApp(
    modifier: Modifier = Modifier,
    startDestination: String = TaskScreens.Task.route,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        taskScreen(
            onTaskClick = { navController.navigateToDetail(it) },
            navigateToAddTask = { navController.navigateToAddTaskScreen() })
        taskDetailScreen { navController.navigateUp() }
        taskAddTaskScreen { navController.navigateUp() }
    }
}