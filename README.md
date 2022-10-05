<img src="JanusColeLogo.png"> 

## Image Viewer for Android in Kotlin with MVVM and Jetpack Compose

In this repo you'll find:<br>
* A single activity architecture with two fragments using **[Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation)** .<br>
* User Interface built with a **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** for each screen.<br>
* Reactive UIs using **[Jetpack Compose](https://developer.android.com/jetpack/compose)** and **[MutableState](https://developer.android.com/reference/androidx/lifecycle/LiveData)**.<br>
* Consumption of a REST api, using Square's **[Retrofit2](https://square.github.io/retrofit/)** library via Kotlin coroutines.<br>
* Async image loading with the **[Coil-Compose](https://coil-kt.github.io/coil/compose/)** library.<br>
* Search criteria caching using **[Proto Datastore](https://developer.android.com/topic/libraries/architecture/datastore)** for persistence.<br>
* Dependency injection using **[Hilt](https://developer.android.com/jetpack/androidx/releases/hilt)** .<br>

### Improvements over the 5 Hour Version include<br>
• Replace the legacy XML Views UI with Jetpack Compose<br>
• Replace the LiveData fields with MutableState<br>
• Refactor the Retrofit code to use coroutines and better isolate components<br>
• Implement dependency injection using Hilt<br>
• Replace Picasso image loading with Coil-Compose<br>
• Implement saved search persistence using Proto Datastore<br>
• Add accessibility strings to input widgets<br>
• Fixed text overflow and scrolling bugs on the Image Detail screen<br>



• Implement accessibility<br>
• Complete tests<br>
• Implement a snazzy progress bar<br>
• Create dependency version values<br>
• Implement error handling<br>

Known Bugs:

• The Search button stops working when the user returns from the Image Detail screen. No idea what's up with that.<br>
• Needs better error handling<br>