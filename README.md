# Android MVVM Project

This is a sample Android MVVM (Model-View-ViewModel) project that demonstrates the use of modern Android development technologies and libraries including Dagger-Hilt, Retrofit, Jetpack Compose, Room Database, Kotlin Flow, and Coroutines.

<p align="center">
  <img src="https://developer.okta.com/assets-jekyll/blog/tutorial-kotlin-beginners-guide/kotlin-logo-social-21c8518b19eb96d96f35e0057bb92b7e1281a24820e0fa09e39c42f184bd7faa.png" width="200" />
</p>

## Features

- **MVVM Architecture**: The project follows the MVVM architectural pattern, separating concerns between data, presentation, and business logic.

- **Dependency Injection with Dagger-Hilt**: Dagger-Hilt is used for dependency injection, providing a standard way to manage and inject dependencies in the Android application.

- **Network Requests with Retrofit**: Retrofit is utilized for making network requests and handling API communication. It simplifies the process of interacting with web services.

- **UI with Jetpack Compose**: Jetpack Compose is used for building the UI, providing a modern and declarative way to create user interfaces.

- **Data Persistence with Room Database**: Room Database, part of Android Jetpack, is used for local data persistence, making it easier to work with SQLite databases.

- **Asynchronous Programming with Kotlin Flow and Coroutines**: Kotlin Flow and Coroutines are leveraged for asynchronous and reactive programming, allowing for efficient handling of asynchronous operations.

## Installation and Usage

To run the project, follow these steps:

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the project on an Android device or emulator

## Dependencies

The project relies on the following key dependencies:

- Dagger-Hilt
- Retrofit
- Jetpack Compose
- Room Database
- Kotlin Flow
- Coroutines
- Datastore

## libraries
```Kotlin
    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.google.code.gson:gson:$retrofit_version"

    // RoomDB
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:$room_version"

    // Dagger-Hilt
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"

    // Datastore
    implementation "androidx.datastore:datastore-preferences:$datastore_version"


## Contributions

Contributions are welcome! If you'd like to contribute to this project, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use and modify the code as per the license terms.

---

By following this README, developers can quickly understand the structure, technologies used, and how to get started with the Android MVVM project.