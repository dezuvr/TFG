# MusicRatings Android App

Una aplicación Android para descubrir, valorar y compartir música.

## Estructura del Proyecto

```
MusicRatingsAndroid/
├── app/
│   ├── build.gradle
│   ├── src/main/
│   │   ├── java/com/musicratings/app/
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── styles.xml
│   │   │   └── drawable/
│   │   │       ├── nav_button_active.xml
│   │   │       ├── nav_button_inactive.xml
│   │   │       ├── border_button.xml
│   │   │       ├── search_background.xml
│   │   │       ├── tab_active.xml
│   │   │       └── stats_background.xml
│   │   └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
└── preview.html
```

## Características

- 🏠 **Inicio**: Pantalla principal con acceso rápido a todas las secciones
- 🎵 **Canciones**: Catálogo completo de canciones con búsqueda y filtros
- 💿 **Álbumes**: Explora álbumes por género, artista o año
- 👤 **Perfil**: Gestiona tu información personal y estadísticas
- 🔍 **Búsqueda**: Encuentra rápidamente canciones y álbumes
- ⭐ **Valoraciones**: Califica y reseña tu música favorita

## Requisitos

- Android Studio Arctic Fox o superior
- Android SDK 21 (Android 5.0) o superior
- Java 8

## Cómo Ejecutar

1. Abre el proyecto en Android Studio
2. Sincroniza el proyecto (File → Sync Project with Gradle Files)
3. Conecta un dispositivo Android o inicia un emulador
4. Ejecuta la aplicación (Run → Run 'app')

## Diseño

- **Tema Principal**: Azul oscuro (#003686)
- **Color Secundario**: Verde Spotify (#1DB954)
- **Tipografía**: Sans-serif del sistema
- **Iconografía**: Material Design Icons

## Vista Previa

Puedes ver una vista previa de la aplicación abriendo el archivo `preview.html` en tu navegador.

## Usuarios

La aplicación utiliza el formato de nombres de usuario estándar:
- perfil1 (usuario principal)
- perfil2 (usuario en following)
- perfil3, perfil4, etc. (otros usuarios)

---

**Disfruta descubriendo y valorando tu música favorita! 🎵**
