package com.example.madexam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madexam.ui.theme.MadexamTheme

class CourseRegistrationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MadexamTheme {

                CourseRegistrationScreen(
                    onRegister = { course, semester ->

                        val intent = Intent(
                            this,
                            ConfirmationActivity::class.java
                        )

                        intent.putExtra("COURSE", course)
                        intent.putExtra("SEMESTER", semester)

                        startActivity(intent)
                        finish()
                    },

                    onBack = {
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun CourseRegistrationScreen(
    onRegister: (String, String) -> Unit,
    onBack: () -> Unit
) {

    var courseName by remember {
        mutableStateOf("")
    }

    var selectedSemester by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Course Registration",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Course Name",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = courseName,
            onValueChange = {
                courseName = it
            },
            label = {
                Text("Enter course name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Semester",
            style = MaterialTheme.typography.titleMedium
        )

        Row {
            RadioButton(
                selected = selectedSemester == "Semester 1",
                onClick = {
                    selectedSemester = "Semester 1"
                }
            )

            Text(
                text = "Semester 1",
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Row {
            RadioButton(
                selected = selectedSemester == "Semester 2",
                onClick = {
                    selectedSemester = "Semester 2"
                }
            )

            Text(
                text = "Semester 2",
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Row {
            RadioButton(
                selected = selectedSemester == "Semester 3",
                onClick = {
                    selectedSemester = "Semester 3"
                }
            )

            Text(
                text = "Semester 3",
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Row {
            RadioButton(
                selected = selectedSemester == "Semester 4",
                onClick = {
                    selectedSemester = "Semester 4"
                }
            )

            Text(
                text = "Semester 4",
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {

                if (courseName.isNotBlank() &&
                    selectedSemester.isNotBlank()
                ) {

                    onRegister(
                        courseName,
                        selectedSemester
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Home")
        }
    }
}