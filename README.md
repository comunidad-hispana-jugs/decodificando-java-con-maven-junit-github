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
mvn archetype:generate -DgroupId=org.medellin.java -DartifactId=decodificando-java-con-maven-junit-github
 -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=RELEASE -Dfile.encoding=UTF-8 -DinteractiveMode=false
~~~

## Creación de 

TODO: codigo para operaciones basicas, con Input  (Console).  Usar algun feature de +Java10 como var para mostrar como cambiar el JDK en el pom



## Adición de pruebas unitarias con JUnit:

TODO: Adición de las dependencias de JUnit, Casos de pruebas true , false, con datos quemados y leyendo desde archivo 


## Creación de ejecutable


TODO: Jar y como ejecutarlo, como saltar los test con skipTests=true


## Actualización del repositorio (remoto)

TODO: Git push, Branchs, PR
