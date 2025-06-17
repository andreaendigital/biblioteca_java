# Sistema de Gestión de Biblioteca

Deberás implementar el método Try/Catch de manera de solucionar la brecha que se puede producir al restringir de forma básica las acciones de usuario y que no bote el programa. Para llevar esto a cabo, deberás incorporar propagación de excepciones, jerarquía de excepciones, excepciones checked y unchecked, lanzamiento de excepciones y creación de excepciones.

## Descripción del Proyecto :scroll:

Caso planteado: 

Imagina que estás desarrollando un programa para administrar las bibliotecas de DUOC UC. El objetivo es crear una aplicación que permita a los usuarios buscar y prestar libros, guardar información sobre los libros y los usuarios, y generar informes a partir de los datos almacenados en archivos externos. 
Para comenzar, puedes utilizar dos tipos de colecciones en Java: ‘ArrayList’, que puede usarse para almacenar objetos de la clase ‘Libro’, y el ‘HashMap’, que puede usarse para almacenar objetos de la clase ‘Usuario’. Estas colecciones te permitirán organizar y acceder a los datos de manera eficiente. 
Para garantizar la robustez y la seguridad del programa, puedes implementar excepciones para manejar situaciones como la búsqueda de un libro que no existe, el préstamo de un libro que ya está prestado, o la introducción de datos incorrectos por parte del usuario. 
Además, para integrar archivos externos de CSV y texto, puedes utilizar las clases ‘BufferedReader’ y ‘FileWriter’ en Java. Puedes leer datos de un archivo CSV utilizando ‘BufferedReader’ y luego crear objetos ‘Libro’ o ‘Usuario’ a partir de los datos leídos. También puedes guardar información en archivos de texto utilizando ‘FileWriter’, por ejemplo, para almacenar los detalles de los resultados obtenidos. 


## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

Para concretar esta actividad, deberás realizar los siguientes pasos: 

👌 1.  Configura el entorno de desarrollo
- Crear un Nuevo Proyecto en NetBeans y selecciona "Nuevo Proyecto". Elige "Aplicación Java" y dale un nombre a tu proyecto.

👌 2. Diseña la estructura del proyecto
- Crea clases principales: podrías necesitar clases como Libro, Biblioteca, Usuario.
- Define atributos y métodos: por ejemplo, Libro podría tener atributos como título, autor, y estado (disponible o prestado).

👌 3. Implementa el manejo de excepciones
  a)	Búsqueda de un libro inexistente
  - Crea una excepción personalizada, por ejemplo, ‘LibroNoEncontradoException’.
  - Utiliza ‘try-catch’ en el método de búsqueda para capturar esta excepción.

  b)	Préstamo de un libro ya prestado
  - Crea otra excepción personalizada, como ‘LibroYaPrestadoException’.

  c)	Introducción de datos incorrectos
  - Utiliza ‘InputMismatchException’ para manejar errores de formato en la entrada del usuario.
  - Encierra la lógica de entrada del usuario en un bloque ‘try-catch’.

  d)	Usa bloques ‘try’
  - Rodea con un bloque ‘try’ cualquier código que pueda lanzar una excepción.

  e)	Define bloques ‘catch’
  - Para cada tipo de excepción, define un bloque ‘catch’ específico.
  - En cada ‘catch’, maneja la excepción de manera adecuada, como informar al usuario.

  f)	No captures excepciones inmanejables
  - Evita los bloques ‘catch’ genéricos que capturan ‘Exception’.
  - Solo captura excepciones que entiendas y puedas manejar.

  g)	No Detectes excepciones Sin control
  - No uses ‘try-catch’ si no puedes hacer algo útil con la excepción.

  h)	Relanza excepciones con ‘throw’:
  - Si capturas una excepción que no puedes manejar completamente, puedes relanzarla usando ‘throw’.

  i)	Usa variables de excepción:
  - En los bloques ‘catch’, utiliza la variable de excepción para obtener detalles sobre el error y mostrar mensajes útiles.


## Visuales :mage_woman:

Captura título no encontrado:
![Captura de pantalla 2025-06-16 162036](https://github.com/user-attachments/assets/ac8bb5d5-de17-4b42-b6f9-304b72c6ac88)

Captura el error de libro no prestado:
![Captura de pantalla 2025-06-16 161942](https://github.com/user-attachments/assets/f3776936-6d96-4dae-bd5a-3afa5b44e32a)

Manejo del error en caso de no encontrar archivo CSv
![Captura de pantalla 2025-06-15 142041](https://github.com/user-attachments/assets/c4e007e6-ec09-4374-b550-c2e2eab7237d)


## Autores ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
- **Miguel Garrido** ⚡  - [Miguel Garrido](https://github.com/m1k1saur1o)
