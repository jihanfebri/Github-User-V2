# GitHub User Explorer

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)

A modern Android application that allows users to explore GitHub profiles and manage their favorite GitHub users. Built with Kotlin and following Android best practices.

## Features

- Search GitHub users
- View detailed user profiles
- Save favorite users
- Dark/Light theme support
- Local data persistence
- Responsive UI design

## Tech Stack

- **Language:** Kotlin
- **Minimum SDK:** 24
- **Target SDK:** 34
- **Architecture:** MVVM (Model-View-ViewModel)

### Libraries Used

- Retrofit2 - REST API client
- Room Database - Local data persistence
- Glide - Image loading and caching
- OkHttp3 - HTTP client
- ViewBinding - View binding
- AndroidX Lifecycle - ViewModel and LiveData
- Circle ImageView - Circular image views
- ViewPager2 - Swipeable views
- DataStore Preferences - Key-value data storage

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- JDK 8
- Android SDK 34
- Kotlin 1.8+

### Installation

1. Clone the repository
   ```bash
   git clone [repository-url]
   ```

2. Open the project in Android Studio

3. Sync project with Gradle files

4. Run the app on an emulator or physical device

## Project Structure

The project follows a clean architecture approach with the following main components:

- `data` - Data layer with repositories and data sources
- `domain` - Business logic and use cases
- `ui` - User interface components
- `utils` - Utility classes and extensions

## Building and Running

The app can be built using Android Studio or through the command line:

```bash
./gradlew assembleDebug
```

To install and run on a connected device:

```bash
./gradlew installDebug
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Contact

Jihan Febriansyah

Project Link: [https://github.com/jihanfebri/Github-User-V2](https://github.com/jihanfebri/Github-User-V2)

---
Last updated: January 11, 2025
