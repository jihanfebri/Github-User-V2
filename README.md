# 🚀 GitHub User Explorer

<div align="center">

![GitHub User Explorer](app/src/main/res/drawable/launcher_github.png)

[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://www.android.com/) 
[![Kotlin](https://img.shields.io/badge/Kotlin-1.8.0-blue.svg)](https://kotlinlang.org/)
[![Android Studio](https://img.shields.io/badge/Android%20Studio-2023.1.1-green.svg)](https://developer.android.com/studio)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

*A modern Android application for exploring GitHub users with a beautiful Material Design interface*

[Features](#features) • [Screenshots](#screenshots) • [Installation](#installation) • [Architecture](#architecture) • [Tech Stack](#tech-stack) • [Contributing](#contributing)

</div>

## ✨ Features

🔍 **Advanced Search**
- Real-time GitHub user search
- Detailed user profiles with followers and following information
- Smooth and responsive user interface

❤️ **Favorites System**
- Save favorite GitHub users locally
- Quick access to favorite profiles
- Manage your favorite users list

🎨 **Modern UI/UX**
- Material Design 3 components
- Dark/Light theme support
- Responsive layout for different screen sizes
- Smooth animations and transitions

🛠️ **Technical Features**
- MVVM Architecture
- Repository Pattern
- Room Database for local storage
- ViewBinding for efficient view access
- Kotlin Coroutines for async operations
- Retrofit for API calls

## 📱 Screenshots

<div align="center">
<table>
<tr>
<td><strong>Light Theme</strong></td>
<td><strong>Dark Theme</strong></td>
</tr>
<tr>
<td><em>Add screenshots here</em></td>
<td><em>Add screenshots here</em></td>
</tr>
</table>
</div>

## 🛠️ Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Components:**
  - Material Design 3
  - Custom Views
  - ViewBinding
  - RecyclerView with DiffUtil
- **Architecture:**
  - MVVM (Model-View-ViewModel)
  - Repository Pattern
  - Clean Architecture principles
- **Dependencies:**
  - AndroidX Libraries
  - Retrofit2 & OkHttp3 for networking
  - Room Database for local storage
  - Glide for image loading
  - ViewPager2 for swipeable views
  - Circle ImageView for profile pictures
- **Other Tools:**
  - Kotlin Coroutines
  - Android DataStore
  - ViewModel & LiveData

## ⚙️ Installation

1. Clone the repository
```bash
git clone https://github.com/jihanfebri/Github-User-V2.git
```

2. Open in Android Studio
- Open Android Studio
- Choose "Open an Existing Project"
- Navigate to the cloned directory

3. Add GitHub Token
- Create a `local.properties` file in the root directory
- Add your GitHub token:
```properties
GITHUB_API_KEY=your_github_token_here
```

4. Build and Run
- Connect your Android device or use an emulator
- Click the "Run" button (▶️) or press `Shift + F10`

## 🏗️ Architecture

This app follows the MVVM (Model-View-ViewModel) architecture pattern and Repository Pattern:

```
com.example.githubuser/
├── data/
│   ├── response/         # API Response Models
│   ├── retrofit/         # Network Layer
│   └── room/            # Local Database
├── ui/
│   ├── main/            # Main Screen
│   ├── detail/          # User Details
│   ├── favorite/        # Favorites
│   └── setting/         # App Settings
└── utils/               # Utility Classes
```

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Jihan Febriansyah**

[![GitHub](https://img.shields.io/badge/GitHub-jihanfebri-black?logo=github)](https://github.com/jihanfebri)

---
<div align="center">
Made with ❤️ by Jihan Febriansyah

Last updated: January 11, 2025
</div>
