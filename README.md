
# College Advisor Mobile
![image](https://github.com/patibachleda/CollegeCalc/assets/58675259/cc89297e-b6bc-483e-ad31-c2cc34ababa7)

College Advisor Mobile is an app intended to help high school students make financially smart decisions when choosing a university and career path. The app allows you to search all 6343 universities in the United States and select the major that is offered at the selected university. Then, the app will give you an analysis of your decision including how long it would take you to pay off any loans you might have to take. Below is a demo video showcasing the features:

https://github.com/patibachleda/CollegeAdvisorMobile/assets/58675259/048703af-b961-4a1f-9be1-42c6daef6f1b

The app is made up of four main screens:

1. The Home screen displays a welcome with the student's name and provides 9 articles that can be read in the app about categories such as Student Loan Debt, Choosing A College, and Choosing a Major.

2. The calculator screen first starts with a screen to take in the user's desired school and major. The majors are specific to the school selected. After selecting a school and a major the user will be redirected to a Results screen upon clicking "Calculate"

3. The Results screen summarizes important financial information a student would need to decide about what university and degree would be best for them.
   
5. The Favorites Screen allows the user to edit their name (that will display on this screen and the Home screen) and access their saved searches. The user can also remove favorites here. Clicking on the View More will load a Results screen from the selected school and major so the student can easily compare their options.

## Architecture 
This app's architecture follows the Model-ViewModel-Model Architecture to ensure that views do not handle state changes:

![Screenshot 2023-12-27 at 1 06 36 PM](https://github.com/patibachleda/CollegeCalc/assets/58675259/b94b5f83-6da9-41f0-9207-e6507b7a3cac)

## Data Source
All data comes from the College Scorecard API
https://collegescorecard.ed.gov/data/documentation/

## Libraries used:

|      Use      |     Source    |
| ------------- | ------------- |
|  Navigation  |    Voyager    |
|  Data store  | com.russhwolf.settings  |
|   Web View   | io.github.kevinnzou  |
| HTTP Client/Serialization  | Ktor  |
|   ViewModel  | dev.icerock.moko  |

## Set up the environment

> **Warning**
> You need a Mac with macOS to write and run iOS-specific code on simulated or real devices.
> This is an Apple requirement.

To work with this template, you need the following:

* A machine running a recent version of macOS
* [Xcode](https://apps.apple.com/us/app/xcode/id497799835)
* [Android Studio](https://developer.android.com/studio)
* The [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
* The [CocoaPods dependency manager](https://kotlinlang.org/docs/native-cocoapods.html)

### On Android

To run your application on an Android emulator:

1. Ensure you have an Android virtual device available. Otherwise, [create one](https://developer.android.com/studio/run/managing-avds#createavd).
2. In the list of run configurations, select `androidApp`.
3. Choose your virtual device and click **Run**:

<details>
  <summary>Alternatively, use Gradle</summary>

To install an Android application on a real Android device or an emulator, run `./gradlew installDebug` in the terminal.

</details>

### On iOS

#### Running on a simulator

To run your application on an iOS simulator in Android Studio, modify the `iosApp` run configuration:

1. In the list of run configurations, select **Edit Configurations**:
2. Navigate to **iOS Application** | **iosApp**.
3. In the **Execution target** list, select your target device. Click **OK**:
4. The `iosApp` run configuration is now available. Click **Run** next to your virtual device:


#### Running on a real device

You can run your Compose Multiplatform application on a real iOS device for free.
To do so, you'll need the following:

* The `TEAM_ID` associated with your [Apple ID](https://support.apple.com/en-us/HT204316)
* The iOS device registered in Xcode
