# decodificando-java-con-maven-junit-github

## Requisitos:

- JDK 9 o superior: https://jdk.java.net/13/
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


## Creación del proyecto Java con Maven
Proyecto base creado con dependencia JUnit por defecto:
~~~
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=org.medellin.app -DartifactId=my-demo
~~~

Ir a la carpeta del proyecto base:
~~~
cd my-demo
~~~


## Creación del repositorio con Git (local)
Ingresar al directorio que contiene el proyecto recien creado:

~~~
git init
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

Esta proyecto contiene 2 funcionalidades: La primera una calculadora para hacer operaciones matemáticas básicas: sumar, restar, multiplicar y dividir, y otra para realizar las 4 operaciones básicas sobre una base de datos: Crear, Actualizar, Consultar y Eliminar.
 
Vamos a empezar con la calculadora

- Cree la BasicCalculator en el paquete (directorio) clase org.medellin.app.calculator

- Cree el metodo sumar tal como se muestra a continuación

  public Long sum(Long number1, Long number2) {
		return number1 + number2;
	}

- Adiciona las dependencias para el manejo de logs en el archivo pom.xml, dentro del bloque de dependencias

            <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.30</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-jdk14 -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-jdk14</artifactId>
            <version>1.7.30</version>
        </dependency>



- Adiciona el logger para la generacion de logs

private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);
  
 - Adiciona un log de información al metodo sum
 
 logger.info( "Summing {} + {}", number1, number2 );
 
 - La clase `src/main/java/org/medellin/app/App.java` va a ser nuestra clase main, la cual se va a usar como puerta de entrada a nuestra calculadora. Abre dicha clase y ubica el metodo main `public static void main( String[] args )`. En esta clase adiciona el codigo para leer dos numeros por consola, nuestra aplicación devolverá el resultado de la suma de estos 
 
 
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

		System.out.println( "Enter number 1: " );
		String textNumber1 = bufferedReader.readLine();

		System.out.println( "Enter number 2: " );
		String textNumber2 = bufferedReader.readLine();
    
    Long number1 =Long.valueOf( textNumber1 );
		Long number2 = Long.valueOf( textNumber2 );
  
    Long result=number1+number2;
    
    System.out.println( number1 + " + " + number2 + " = " +  result);
    
    
- Adiciona el logger a la clase App.java



## Creación de casos de pruebas

Crea los casos de pruebas en la clase BasicCalculator.java ubicada en  `src/main/java/org/medellin/app/calculator` como se explica a continuación

- Abre el archivo pom.xml

      <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        
        
- El proyecto fue creado con la dependencia de junit, desde la version 5 junit fue renombrada por org.junit.jupiter, es necesario eliminar la dependencia de junit y adicionar la de junit.jupiter



        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.5.1</version>
            <scope>test</scope>
        </dependency>
        

- Abre la clase BasicCalculator.java para crear los casos de pruebas. Cree una clase CalculatorTest.java en `src/test/java/org/medellin/app/calculator`

- Instanciamos el sujeto de prueba en la clase CalculatorTest.java, en este caso el sujeto es BasicCalculator:

        public class CalculatorTest {
    
            private final BasicCalculator basicCalculator = new BasicCalculator();
        
            ...

- Empezamos con el primer caso de prueba, un caso de exito. Creamos un metodo sum. Este metodo va a usar el sujeto de prueba para sumar 1 con 1.

        
        void sum() {
            basicCalculator.sum(1L, 1L);
        }

- Luego necesitamos validar si el resultado de la suma es correcto, asi que agregamos un assertEquals validando que el resultado debe ser 2

        
        void sum() {
            assertEquals(2, basicCalculator.sum(1L, 1L));
        }

- Ahora, debemos decirle a JUnit que este metodo es un caso de prueba que puede ejecutarse, asi que le agregamos la anotation @Test

        @Test
        void sum() {
            assertEquals(2, basicCalculator.sum(1L, 1L));
        }

- Para que el caso de prueba sea mas descriptivo, podemos agregar el @DisplayName diciendo de que trata el caso de prueba

        @Test
        @DisplayName("Testing sum: 1+1=2")
        void sum() {
            assertEquals(2, basicCalculator.sum(1L, 1L));
        }

- Ahora se puede ejecutar este caso de prueba con el comando `mvn clean test`

- En el caso anterior, solo usamos un caso de entrada (1 y 1). Que pasa si quiero probar la misma logica de negocio (sumar) pero con muchos mas casos de prueba? Empezamos definiendo el metodo:

        @Test
        @DisplayName("Testing several sums")
        void severalSums(Long first, Long second, Long expectedResult) {
            assertEquals(expectedResult, basicCalculator.sum(first, second),
                         () -> first + " + " + second + " should equal " + expectedResult);
        }

- Luego definimos los multiples casos de entrada usando la anotacion @CsvSource:

        @Test
        @DisplayName("Testing several sums")
        @CsvSource({
                    "0,    1,   1",
                    "1,    2,   3",
                    "49,  51, 100",
                    "1,  100, 101"
            })
        void severalSums(Long first, Long second, Long expectedResult) {
            assertEquals(expectedResult, basicCalculator.sum(first, second),
                         () -> first + " + " + second + " should equal " + expectedResult);
        }

    @CvsSource define multiples casos de entrada y sus respectivas salidas esperadas. Cada caso de prueba es una fila, donde la primera columna es el primer operando, la segunda es el segundo operando, y la tercera representa el resultado esperado. Los datos de cada fila son pasados al metodo severalSums como parametros.
    JUnit va a ir fila por fila, ejecutando el metodo severalSums con los datos de esa fila.
    
- Tambien podemos agregar una descripcion dinamica a la prueba, para hacerle seguimiendo. Para esto usamos la anotacion @ParameterizedTest.

        @Test
        @DisplayName("Testing several sums")
        @CsvSource({
                    "0,    1,   1",
                    "1,    2,   3",
                    "49,  51, 100",
                    "1,  100, 101"
            })
        @ParameterizedTest(name = "{0} + {1} = {2}")
        void severalSums(Long first, Long second, Long expectedResult) {
            assertEquals(expectedResult, basicCalculator.sum(first, second),
                         () -> first + " + " + second + " should equal " + expectedResult);
        }

    @ParameterizedTest describe el caso de prueba basado en los casos de entrada definidos en @CvsSource. Esto significa que por cada caso de prueba (fila) en @CvsSource, se va a mostrar una descripcion de la forma {0} + {1} = {2}, donde 0 representa la primera posicion de la fila, 1 la segunda y 2 la tercera.

- Luego se puede ejecutar este caso de prueba con el comando `mvn clean test`

## Creación de ejecutable

El siguiente comando empaqueta el binario en la carpeta `target/.*jar`. El comando compila y construye:
~~~
mvn package
~~~
Para empaqueta sin necesidad compilar los tests se usa el siguiente comando:
~~~
mvn package -Dmaven.test.skip=true
~~~
***Esa propiedad hace parte del plugin surefire***

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
