# MicroFrameworks

<div align="justify">
  Este proyecto demuestra una arquitectura básica de servidor web utilizando un microframework. Incluye un servidor simple que maneja tanto solicitudes de servicios     dinámicos como la entrega de archivos estáticos, haciemdo uso de los servicios a ofrecer al usuario y haciendo su debida obtención de metodos Static hasta llegar a     un servicio REST.
</div>

## Estructurar el proyecto

<div align="justify">
 Para hacer la debida instalacion y ejecución del programa es necesario tener en cuenta las siguientes recomendaciones:
</div>

* Tener la instalacion de Maven en la máquina personal
* JDK version 11 o superior

## Instalación 

1. Clonar el repositorio y navegar a la pestaña creada
   ```
   git clone AREP_Microframeworks
   cd AREP_Microframeworks
    ```

2. Ejecutar maven y esperar que se cosntruya correctamente

   ```
    mvn clean install
    ```
3. Finalmente, correr el archivo para hacer posible el ver realmente cada uno de los servicios ofrecidos por REST

   ```
   java -cp target/micro-frameworks-1.0-SNAPSHOT.jar edu.escuelaing.arep.app.App
    
   ```
## ARQUITECTURA
  
   ```
C:.
└───src
      ├───main
      │     ├───java
      │     │     └───edu
      │     │           └───escuelaing
      │     │                   └───arep
      |     └───resources             └───app
      │     
      └───test
            └───java
                   └───edu
                          └───escuelaing
                                   └───arep
                                        └───app

   ```                     
## EJECUCIÓN

   Se puede hacer revision de los siguientes HTML:

  ```
    http://localhost:8080/App/hello?name=
    http://localhost:8080/App/pi
    http://localhost:8080/index.html
    http://localhost:8080/App/datetime
    http://localhost:8080/App/sum?num1= 20 & num2= 1
    
   ```
## REVIEW

  En el proyecto se producen 4 servicios nuevos, se utiliza un orden y cada uno de ellos responde a su llamado independiente como archivo html a acceder en la red asi mismo como los archivos estáticos que permiten al usuario correr el main de la aplicación.

  * Se ejecuta un archivo estatico que cumple con cada uno de sus servicios de tipo REST y responde a ellos de manera satisfactoria.

      ![image](https://github.com/user-attachments/assets/973634d1-0d9b-4e99-8717-3e746fc91822)

  * Asi mismo cada uno de estos servicios corre de manera independiente

      ![image](https://github.com/user-attachments/assets/3e64c7be-185d-48bf-a33b-13237d537d35)

      -----------------------------------

      ![image](https://github.com/user-attachments/assets/b15210f0-a38f-47bf-b26a-acaa3e1b58f5)

      -----------------------------------

      ![image](https://github.com/user-attachments/assets/23096736-e1ef-49e0-8a7a-99c3e5e23d37)

# PRUEBAS

  ![image](https://github.com/user-attachments/assets/9c22977f-c1ca-49bf-8e45-a6b3fa532eb5)

# Realizado por

Nicolas Sebastian Achuri Macias
      

