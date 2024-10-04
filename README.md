# Rick and Morty Character Viewer

Este es un proyecto de Android que utiliza la API de [Rick and Morty](https://rickandmortyapi.com/) para mostrar información de los personajes. Los datos se presentan en un `RecyclerView`, donde cada tarjeta muestra detalles básicos de un personaje. Al hacer clic en una tarjeta, se abre una nueva actividad con información más detallada del personaje.

## Funcionalidades

- **Listado de personajes**: Se muestra una lista de personajes en un `RecyclerView`.
- **Detalle de personaje**: Al hacer clic en un personaje, se abre una nueva pantalla que muestra detalles adicionales del personaje seleccionado.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal.
- **Retrofit**: Biblioteca para consumir APIs RESTful.
- **Glide**: Biblioteca para cargar y manejar imágenes.
- **Parcelable**: Para pasar objetos entre actividades de forma eficiente.
- **RecyclerView**: Para mostrar una lista de elementos en formato de tarjetas.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/rick-and-morty-viewer.git
2. Asegúrate de tener configuradas las dependencias en el archivo `build.gradle`:
   ```gradle
   implementation 'com.squareup.retrofit2:retrofit:2.9.0'
   implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
   implementation 'com.github.bumptech.glide:glide:4.12.0'
3. Ejecuta el proyecto en un dispositivo o emulador Android.

## Uso

1. Al iniciar la aplicación, verás una lista de personajes obtenidos desde la API de Rick and Morty.
2. Haz clic en cualquier tarjeta de personaje para ver detalles adicionales sobre el personaje.

## Estructura del proyecto

1. MainActivity: Controla el listado de personajes y consume la API.
2. CharacterDetailActivity: Muestra información detallada del personaje seleccionado.
4. ApiService: Define las funciones para interactuar con la API de Rick and Morty.
5. UsuarioAdaptador: Adaptador para enlazar los datos del personaje con el RecyclerView.

## API

El proyecto utiliza la API pública de Rick and Morty. Más detalles en rickandmortyapi.com.
