# decodificando-java-con-maven-junit-github

## Requisitos:

- JDK 8 o superior: https://jdk.java.net/13/
- Maven 
  - Descarga: (https://maven.apache.org/download.cgi)
  - Instalación: (https://maven.apache.org/install.html)
- El IDE de su preferencia 
  - IntelliJ: https://www.jetbrains.com/es-es/idea/download/ 
  - Visual Studio: https://code.visualstudio.com/docs/languages/java
- Git: https://git-scm.com/downloads
- Cuenta en un servicio de repositorios basados en git
  - GitHub: https://github.com/join
  - GitLab: https://gitlab.com/users/sign_up
- Docker: https://www.docker.com/get-started



## Creación del repositorio con git (local):
TODO: git init 

## Creación del proyecto java con maven:
~~~
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=org.medellin.app -DartifactId=my-demo
~~~

TODO: resources directory wasn't created
TODO: to create maven with jupiter instead of junit
## Creación de pro

Esta proyecto contiene 2 apps: Una primera una calculadora para hacer operaciones matemáticas básicas: sumar, restar, multiplicar y dividir,
 y otra para realizar las 4 operaciones básicas sobre una base de datos: Crear, Actualizar, Consultar y Eliminar.
 
 
 TODO: Calculator only has sum, to add the other operations. Add delete (remove) and update (merge) to database part


## Adición de pruebas unitarias con JUnit/Jupiter:

TODO: Adición de las dependencias de JUnit, Casos de pruebas true , false, con datos quemados y leyendo desde archivo 


## Creación de ejecutable


TODO: Jar y como ejecutarlo, como saltar los test con skipTests=true


## Actualización del repositorio (remoto)

TODO: Git push, Branchs, PR