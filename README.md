# MobileApp_Alarmil


# Alamil Mobile Application

Esta es la aplicación móvil **Alamil**, desarrollada en Kotlin para Android. Proporciona funcionalidades para la creación de misiones, alarmas, monitoreo de frecuencia cardíaca y más, con un diseño sencillo e intuitivo.

## Requisitos previos

Asegúrate de tener las siguientes herramientas instaladas antes de intentar ejecutar este proyecto:

- [Android Studio](https://developer.android.com/studio) (versión más reciente)
- [JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/) (normalmente incluido en Android Studio)
- Un dispositivo Android o un emulador para ejecutar la aplicación

## Instalación

Sigue los siguientes pasos para instalar y ejecutar la aplicación localmente.

**Clonar el repositorio**

Clona este repositorio en tu máquina local con el siguiente comando:

git clone https://github.com/tu-usuario/alamil-mobile.git

## Abrir el proyecto en Android Studio

Abre Android Studio.

Selecciona Open an Existing Project y navega hasta el directorio donde clonaste el repositorio.

Asegúrate de que Android Studio importe correctamente todos los archivos del proyecto.

## Sincronizar dependencias

El proyecto utiliza Gradle para manejar dependencias. Android Studio debería sincronizar automáticamente las dependencias cuando abras el proyecto. Si no es así, puedes sincronizar manualmente:

En Android Studio, selecciona File > Sync Project with Gradle Files.
Asegúrate de que todas las dependencias se resuelvan correctamente. Si hay problemas, revisa los mensajes de error para identificar cualquier dependencia faltante.

Configuración de Emulador o Dispositivo Físico

Si tienes un dispositivo físico Android, conéctalo mediante USB y habilita la depuración USB.

También puedes configurar un emulador Android desde el Administrador de dispositivos en Android Studio. Asegúrate de seleccionar una imagen de dispositivo con una versión de Android compatible (Android 8.0+).

## Ejecutar la aplicación

Haz clic en el botón Run (símbolo de triángulo verde) en la barra superior de Android Studio.

Elige tu emulador o dispositivo físico en la ventana emergente y la aplicación debería iniciarse en el dispositivo.

## Funcionalidades principales
-Creación de misiones: Los usuarios pueden crear nuevas misiones con fechas de inicio y fin.

-Alarmas personalizadas: Configura alarmas específicas para cada misión.

-Monitoreo de frecuencia cardíaca: Los usuarios pueden monitorear su ritmo cardíaco durante las misiones.

-Interfaz intuitiva: Pantallas de fácil navegación y controles interactivos.

## Estructura del proyecto

-MainActivity: Pantalla principal de autenticación (login).

-HomeActivity: Pantalla de inicio con las funcionalidades de misión y alarmas.

-MissionCreationActivity: Pantalla para la creación de nuevas misiones.

-NewAlarmActivity: Pantalla para configurar alarmas.

-HeartRateActivity: Pantalla para monitoreo de frecuencia cardíaca.

-SplashActivity: Pantalla de carga inicial.

-Dependencias importantes

## El proyecto utiliza las siguientes bibliotecas:

MPAndroidChart: Para mostrar gráficos en la aplicación.

AndroidX Libraries: Conjunto de bibliotecas para mejorar la compatibilidad y facilitar el desarrollo.

