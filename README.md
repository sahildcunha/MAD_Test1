# CampusConnect 

A simple Android application developed using **Kotlin and Jetpack Compose** to demonstrate a student-focused campus connectivity system.

The application provides a central dashboard where students can access their profile, campus events, notices, and course registration.

---

##  Experiment Overview

### Project Name

**CampusConnect**

### Platform

Android

### Programming Language

**Kotlin**

### UI Framework

**Jetpack Compose**

### Design System

**Material 3**

### Development Environment

**Android Studio**

---

##  Objective

The objective of this experiment is to develop a basic Android application using **Kotlin and Jetpack Compose** that demonstrates:

* Building user interfaces using Jetpack Compose.
* Using composable functions to create reusable UI components.
* Managing screen navigation using Compose state.
* Using `Intent` to launch another Android Activity.
* Displaying student information.
* Creating interactive buttons and cards.
* Using Android resources such as images.
* Implementing Material 3 UI components.

---

##  Scenario

**CampusConnect** is designed as a simple campus companion application for students.

A student opens the application and is presented with a dashboard containing the college logo and different campus-related options.

From the dashboard, the student can:

1. View their **Profile**.
2. Check **Events**.
3. Check **Notices**.
4. Open **Course Registration**.
5. Return between the available screens.

The dashboard acts as the main navigation point of the application.

The application starts with the `dashboard` screen and changes the current screen based on the button selected by the user.

---

# 🛠️ Technologies Used

| Technology         | Purpose                     |
| ------------------ | --------------------------- |
| Kotlin             | Application development     |
| Jetpack Compose    | Building the Android UI     |
| Material 3         | UI components and styling   |
| Android Studio     | Development environment     |
| Android Intent     | Activity navigation         |
| Compose State      | Managing screen navigation  |
| Drawable Resources | Displaying the college logo |

---

# Concepts Demonstrated

## 1. Jetpack Compose

The application uses Jetpack Compose for creating the user interface instead of traditional XML layouts.

Composable functions such as `CampusConnectApp()`, `CampusConnectDashboard()`, `StudentProfile()`, `EmptyEventsScreen()`, and `EmptyNoticesScreen()` are used to create different parts of the application.

---

## 2. State Management

The application uses Compose's `remember` and `mutableStateOf` to keep track of the currently displayed screen.

```kotlin
var currentScreen by remember {
    mutableStateOf("dashboard")
}
```

When a button is clicked, the value of `currentScreen` changes and the corresponding screen is displayed.

For example:

```kotlin
onProfileClick = {
    currentScreen = "profile"
}
```

## This allows the application to switch between screens without requiring a traditional navigation library.

## 3. Intent

The **Course Registration** button uses an Android `Intent` to launch `CourseRegistrationActivity`.

```kotlin
val intent = Intent(
    context,
    CourseRegistrationActivity::class.java
)

context.startActivity(intent)
```

This demonstrates communication between Android Activities.

---

## 4. Material 3 Components

The application uses Material 3 components such as:

* `Scaffold`
* `Card`
* `Button`
* `Text`

## These components are used to create the dashboard, student profile, events, and notices interfaces.

#  Project Folder Structure

The relevant project structure is:

```text
CampusConnect/
│
├── app/
│   └── src/
│       └── main/
│           │
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── madexam/
│           │               │
│           │               ├── MainActivity.kt
│           │               ├── CourseRegistrationActivity.kt
│           │               │
│           │               └── ui/
│           │                   └── theme/
│           │                       ├── Color.kt
│           │                       ├── Theme.kt
│           │                       └── Type.kt
│           │
│           ├── res/
│           │   ├── drawable/
│           │   │   └── cllglogo.*
│           │   │
│           │   ├── mipmap/
│           │   └── values/
│           │
│           └── AndroidManifest.xml
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

### Important Files

| File                            | Description                                            |
| ------------------------------- | ------------------------------------------------------ |
| `MainActivity.kt`               | Main application entry point and Compose UI            |
| `CourseRegistrationActivity.kt` | Activity opened through the Course Registration button |
| `cllglogo`                      | College logo displayed on the dashboard                |
| `Theme.kt`                      | Application theme configuration                        |
| `Color.kt`                      | Color definitions                                      |
| `Type.kt`                       | Typography configuration                               |
| `AndroidManifest.xml`           | Android application configuration                      |
| `README.md`                     | Project documentation                                  |

---

# Application Screens

## 1. Dashboard

The dashboard is the main screen of the application.

It contains:

* College logo
* CampusConnect title
* Welcome message
* Student Dashboard card
* Events button
* Notices button
* Course Registration button
* Profile button

The dashboard UI is implemented using `Scaffold`, `Column`, `Row`, `Card`, `Button`, `Text`, and `Image` components.

### Screenshot

Add your dashboard screenshot here:

```markdown
![CampusConnect Dashboard](screenshots/dashboard.png)
```

---

#  Student Profile

The Profile screen displays student information inside a Material Card.

The displayed information includes:

* Name: Sahil
* USN: 25MCAR0117
* Course: MCA
* University: Jain University
* Email: [student@gmail.com](mailto:student@gmail.com)

The screen also contains a **Back to Home** button.

### Screenshot

```markdown
![Student Profile](screenshots/profile.png)
```

---

#  Events

The Events screen currently displays a message indicating that there are no new campus events.

It contains:

* Events heading
* "No New Events" message
* Description
* Back to Home button

### Screenshot

```markdown
![Events Screen](screenshots/events.png)
```

---

#  Notices

The Notices screen displays a message indicating that there are currently no new campus notices.

It contains:

* Notices heading
* "No New Notices" message
* Description
* Back to Home button

### Screenshot

```markdown
![Notices Screen](screenshots/notices.png)
```

---

# Test Cases

The following test cases are used to verify the main functionality of the application.

---

## Test Case 1 – Open Student Profile

### Test Objective

Verify that the Profile button opens the Student Profile screen and displays the correct student details.

### Steps

1. Launch the CampusConnect application.
2. From the Dashboard, click **Profile**.
3. Verify that the Student Profile screen is displayed.
4. Verify the student information.

### Expected Result

The Student Profile screen should open and display:

```text
Name: Sahil
USN: 25MCAR0117
Course: MCA
University: Jain University
Email: student@gmail.com
```

---

## Test Case 2 – Open Events

### Test Objective

Verify that the Events button navigates to the Events screen.

### Steps

1. Launch CampusConnect.
2. Click **Events** from the Dashboard.
3. Verify that the Events screen is displayed.

### Expected Result

The Events screen should display:

**No New Events**

along with the message:

**There are currently no new campus events.**

### Screenshot

```markdown
![Test Case 2 - Events](screenshots/testcase2-events.png)
```

---

## Test Case 3 – Open Notices

### Test Objective

Verify that the Notices button navigates to the Notices screen.

### Steps

1. Launch CampusConnect.
2. Click **Notices** from the Dashboard.
3. Verify that the Notices screen is displayed.

### Expected Result

The Notices screen should display:

**No New Notices**

along with the message:

**There are currently no new campus notices.**

---

# Application Flow

```text
                 ┌─────────────────────┐
                 │   CampusConnect     │
                 │      Dashboard      │
                 └──────────┬──────────┘
                            │
          ┌─────────────────┼─────────────────┐
          │                 │                 │
          ▼                 ▼                 ▼
      ┌────────┐       ┌────────┐       ┌────────┐
      │ Profile│       │ Events │       │ Notices│
      └────┬───┘       └────┬───┘       └────┬───┘
           │                │                │
           ▼                ▼                ▼
     Student Details    No New Events   No New Notices

                            │
                            ▼
                  ┌───────────────────┐
                  │ Course Registration│
                  └─────────┬─────────┘
                            │
                            ▼
                CourseRegistrationActivity
```

The dashboard determines which screen is displayed using the `currentScreen` state. The Course Registration option starts a separate Activity using an Android Intent.

---

# Result

The **CampusConnect** Android application was successfully developed using **Kotlin and Jetpack Compose**.

The application demonstrates:

* Jetpack Compose UI development
* Material 3 components
* State-based screen navigation
* Android Activity navigation using Intent
* Student profile information display
* Campus events and notices screens
* Resource/image usage
* Basic Android application structure

---

# Student Details

**Name:** Sahil
**USN:** 25MCAR0117
**Course:** Master of Computer Applications (MCA)
**University:** Jain University

---

## Conclusion

CampusConnect demonstrates how Jetpack Compose can be used to create a simple, interactive Android application with multiple screens and user interactions. The project provides a basic foundation for a campus management application that could later be expanded with real-time announcements, event registration, course management, notifications, and student services.
