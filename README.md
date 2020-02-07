# decodificando-java-con-maven-junit-github

## Requisitos:

- JDK 8 o superior: https://jdk.java.net/13/
- Maven 
  - Descarga: (https://maven.apache.org/download.cgi)
  - Instalación: (https://maven.apache.org/install.html)
- El IDE de su preferencia 
  - IntelliJ: https://www.jetbrains.com/es-es/idea/download/
  - Eclipse: https://www.eclipse.org/downloads/packages/installer
  - Visual Studio: https://code.visualstudio.com/docs/languages/java
- Git: https://git-scm.com/downloads
- Cuenta en un servicio de repositorios remotos basados en Git
  - GitHub: https://github.com/join
  - GitLab: https://gitlab.com/users/sign_up
- Docker: https://www.docker.com/get-started


## Creación del proyecto Java con Maven
Proyecto base creado con dependencia JUnit por defecto:
~~~
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=org.medellin.app -DartifactId=my-demo
~~~
Log de creación del nuevo proyecto Maven:
~~~
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:3.1.2:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:3.1.2:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO]
[INFO]
[INFO] --- maven-archetype-plugin:3.1.2:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: /Users/eimer.castro/Desktop
[INFO] Parameter: package, Value: org.medellin.app
[INFO] Parameter: groupId, Value: org.medellin.app
[INFO] Parameter: artifactId, Value: my-demo
[INFO] Parameter: packageName, Value: org.medellin.app
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: /Users/eimer.castro/Desktop/my-demo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.391 s
[INFO] Finished at: 2020-02-06T22:11:28-05:00
[INFO] ------------------------------------------------------------------------
~~~
TODO: resources directory wasn't created
TODO: to create maven with jupiter instead of junit


## Creación del repositorio con Git (local)
Ingresar al directorio que contiene el proyecto recien creado:
~~~
cd my-demo
~~~
Crear el repositorio local de Git dentro del proyecto:
~~~
git init
~~~
Verificar la creación del repositorio con la siguiente salida:
~~~
Initialized empty Git repository in /Users/my-user/Desktop/my-demo/.git/
~~~
Creación de una rama de trabajo que proviene de la rama actual:
~~~
git branch [name-branch]
~~~
Creación de una nueva rama y posicionarse directamente en ella:
~~~
git checkout -b [name-branch]
~~~
Listar las ramas locales:
~~~
git branch -l
~~~

## Creación de proyectos

Esta proyecto contiene 2 apps: Una primera una calculadora para hacer operaciones matemáticas básicas: sumar, restar, multiplicar y dividir,
 y otra para realizar las 4 operaciones básicas sobre una base de datos: Crear, Actualizar, Consultar y Eliminar.
 
 
 TODO: Calculator only has sum, to add the other operations. Add delete (remove) and update (merge) to database part


## Adición de pruebas unitarias con JUnit/Jupiter:

TODO: Adición de las dependencias de JUnit, Casos de pruebas true , false, con datos quemados y leyendo desde archivo 


## Creación de ejecutable


TODO: Jar y como ejecutarlo, como saltar los test con skipTests=true


## Actualización del repositorio local
Verificar los cambios realizados en los archivos del proyecto
~~~
git status
~~~
Mover todos los archivos nuevos, modificados y eliminados desde Working Directory a Staging Area:
~~~
git add .
~~~
ó
~~~
git add -A
~~~
ó indicando un archivo en especifico
~~~
git add ruta/del/archivo/o/directorio
~~~
Mover los archivos de Staging Area a Git Repository
~~~
git commit -m "Descripción de los cambios realizados en este commit."
~~~
## Actualización del repositorio remoto
Crear un nuevo repositorio en el servicio de repositorios remotos.  

Adicionar el repositorio remoto de origen
~~~
git remote add [origin] [SSH/HTTPS]
~~~
Subir los cambios realizados desde una rama en el repositorio local hacia una rama en el repositorio remoto:
~~~
git push [origin] [name-branch]
~~~
###Fusionando ramas:
Moverse a la rama que debe contener los nuevos cambios de la rama en la que se estaba trabajando:
~~~
git checkout [name-branch]
~~~
Fusionar las ramas
~~~
git merge [name-branch]
~~~
Verificar que los cambias provenientes de la rama creada funcionen con las características previas.

##Creación de Pull Request (PR)
1. Ir a la ruta del repositorio remoto
2. Seleccionar el commit que muestra los cambios realizados en la rama que se estaba trabajando
3. Seleccionar la rama a la cual se solicita hacer merge mediante el Pull Request
4. Seleccionar los aprobadores
5. Clic en el botón crear Pull Request
6. En caso de no requerir aprobadores dar clic directamente en el botón "Merge"