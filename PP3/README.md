# Práctica Programada 3 - Estructuras de Datos.

**Nombre:** Yirlania Córdoba Muñoz  
**Carné:** FI23031490
**IDE o editor utilizado:** Visual Studio Code 21  


## Páginas web donde halló posibles soluciones o Snippets de código

- https://chatgpt.com/



## Prompts (consultas y respuestas) de chatbots de IA utilizados

**Prompt:** “Darme un ejemplo de una lista circular doblemente enlazada en Java con métodos addFirst, addLast, removeFirst y removeLast.”  
**Respuesta:** ChatGPT generó una implementación funcional con referencias head y tail, asegurando el comportamiento circular correcto.



## Respuestas a las preguntas

### 1. Si tuviera que implementar una estructura tipo Cola (Queue), ¿qué tipo de lista (simple, circular, doblemente enlazada o circular doblemente enlazada) utilizaría y por qué? ¿Y para una estructura tipo Pila (Stack)?

Para una **Cola (Queue)** utilizaría una lista simplemente enlazada**, ya que este tipo de lista permite insertar elementos al final y eliminar desde el inicio, por su implementación que es sencilla y eficiente para este tipo de estructura.

En el caso de una **Pila (Stack)**, también usaría una lista simplemente enlazada, porque las operaciones de inserción y eliminación (push y pop) se realizan siempre en un solo extremo, siguiendo el principio LIFO (Last In, First Out). Esto hace que su implementación sea directa y con un manejo de memoria adecuado.

### 2. ¿Cuál cree que podría ser una ventaja y una desventaja de utilizar una estructura de tipo lista creada por usted mismo, en vez de las opciones proveídas directamente por los módulos estándar de Java (como por ejemplo List)?

**Ventaja:** Crear una lista desde cero permite entender a fondo cómo funcionan internamente las estructuras de datos.

**Desventaja:** Requiere más tiempo y esfuerzo, puede generar errores si no se manejan correctamente las referencias.

