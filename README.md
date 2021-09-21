# Breaking Bad App

# Preview:

<img src=".media/preview.gif" alt="Drawing" style="width: 200px;"/>        <img src=".media/darkmode.gif" alt="Drawing" style="width: 200px;"/>

## Introduction ##
This project is an Android app wich consumes the Breaking Bad Api, to display, list, and provide information about the characters related. This project is made in Kotlin, and inspired in the concept of clean architecture as it shown in the following diagram.

![Clean Architecture](https://codersopinion.com/images/posts/clean-architecture/clean-architecture.png)


The direction of each layer communication is the rule and it help to struct the file structure, allowing scale and maintain the application for future improvements. Based on the repository architecture presented in the android documentation, we use the MVVM architecture to communicate the UI and model. Additionally it allows to persist the data and handle the user interactions.

![Android MVVM Architecture](https://miro.medium.com/max/724/1*BqFy9rd2_hCtOeHgUY72gg.png)

## Technologies used ##

This application uses the most common libraries for Android projects:

- Room Database: Part of the Jetpack Compose, it allows to persist the data consumed in the application.
- Navigation: It is used to define the flow between fragments, with a single activity strategy architecture
- Dagger: Is the framework used to manage the dependency injection, providing the suitable instances.
- Retrofit: It allows to define the proper operations to consume the the methods provided by the Breaking Bad Api.
- Moshi: It is used to map the json retrieved by the server to data classes.
- Glide: It allows to render the images represented as urls.
- Timber: This library provide improvement for log messages with the context related when they are shown in Logcat.

For testing, the following are the libraries used:
- Mock Web Server
- Mockito
- Robolectric

## Github Actions ##
To guarantee a success development, a github action was created to check the builds and test validation, for each feature developed on different branches.