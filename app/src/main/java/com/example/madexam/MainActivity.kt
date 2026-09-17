
package com.example.madexam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.madexam.ui.theme.MadexamTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MadexamTheme {
                CampusConnectApp()
            }
        }
    }
}


@Composable
fun CampusConnectApp() {

    var currentScreen by remember {
        mutableStateOf("dashboard")
    }

    val context = LocalContext.current

    when (currentScreen) {

        // HOME / DASHBOARD
        "dashboard" -> {

            CampusConnectDashboard(

                onProfileClick = {
                    currentScreen = "profile"
                },

                onEventsClick = {
                    currentScreen = "events"
                },

                onNoticesClick = {
                    currentScreen = "notices"
                },

                onCourseRegistrationClick = {

                    val intent = Intent(
                        context,
                        CourseRegistrationActivity::class.java
                    )

                    context.startActivity(intent)
                }
            )
        }


        // PROFILE
        "profile" -> {

            StudentProfile(
                onBackClick = {
                    currentScreen = "dashboard"
                }
            )
        }


        // EVENTS
        "events" -> {

            EmptyEventsScreen(
                onBackClick = {
                    currentScreen = "dashboard"
                }
            )
        }


        // NOTICES
        "notices" -> {

            EmptyNoticesScreen(
                onBackClick = {
                    currentScreen = "dashboard"
                }
            )
        }
    }
}


@Composable
fun CampusConnectDashboard(
    onProfileClick: () -> Unit,
    onEventsClick: () -> Unit,
    onNoticesClick: () -> Unit,
    onCourseRegistrationClick: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {

            // COLLEGE LOGO
            Image(
                painter = painterResource(
                    id = R.drawable.cllglogo
                ),
                contentDescription = "College Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )


            Text(
                text = "Campus Connect",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = "Welcome to your campus!",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Student Dashboard",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Stay connected with campus activities, events and announcements."
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            // EVENTS AND NOTICES
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = onEventsClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Events")
                }

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Button(
                    onClick = onNoticesClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Notices")
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )


            // COURSE REGISTRATION AND PROFILE
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    onClick = onCourseRegistrationClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Course Registration")
                }

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Button(
                    onClick = onProfileClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Profile")
                }
            }
        }
    }
}


// =============================
// PROFILE SCREEN
// =============================

@Composable
fun StudentProfile(
    onBackClick: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Student Profile",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Student Information",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Text(
                        text = "Name: Sahil",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "USN: 25MCAR0117",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Course: MCA",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "University: Jain University",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Email: student@gmail.com",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Home")
            }
        }
    }
}


// =============================
// EVENTS SCREEN
// =============================

@Composable
fun EmptyEventsScreen(
    onBackClick: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Events",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )


            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(30.dp)
                ) {

                    Text(
                        text = "No New Events",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "There are currently no new campus events."
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )


            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Home")
            }
        }
    }
}


// =============================
// NOTICES SCREEN
// =============================

@Composable
fun EmptyNoticesScreen(
    onBackClick: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Notices",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )


            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(30.dp)
                ) {

                    Text(
                        text = "No New Notices",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "There are currently no new campus notices."
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )


            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Home")
            }
        }
    }
}
