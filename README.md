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
Abra una consola de comandos y ejecutar el siguiente comando:
~~~
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=org.medellin.app -DartifactId=my-demo
~~~
Después de ejecutar el comando anterior se creará un proyecto con la estructura de directorios:
~~~
src/main/java/org/medellin/app
src/test/java/org/medellin/app
~~~

## Creación del repositorio con Git (local)
Ir a la carpeta `my-demo` que contiene el proyecto recien creado:
~~~
cd my-demo
~~~
Crea el repositorio Git ejecutando el siguiente comando:
~~~
git init
~~~

Crear una nueva rama y posicionarse directamente en ella:
~~~
git checkout -b [name-branch]
git checkout -b meetupfebrero2020
~~~
Verificar el estado de los archivos en el proyecto:
~~~
git status
~~~

## Configuración del Proyecto
Este proyecto contiene 1 funcionalidad, la cual es una calculadora para hacer operaciones matemáticas básicas: sumar, restar, multiplicar y dividir.

- Importar el proyecto con el IDE de su preferencia

#### Agregar las Dependencias y Propiedades ####

##### 1. Agregar las propiedades para parametrizar las versiones y las especificaciones para la compilación del artefacto #####
~~~
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
~~~
*Tener en cuenta que se estaría usando Java 12 como mínima versión de compilación.*

##### 2. Agregar las dependencias de Simple Logging Facade for Java para manejar logs.
~~~
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
~~~

##### 3. Agregar archivo .gitignore para no tener en cuenta los ficheros generados por el IDE y la compilación de la aplicación
~~~
.gitignore
~~~
#### Creación de las Clases y Métodos ####

##### 4. Creación de la clase *BasicCalculator.java* para manejar las operaciones aritméticas
Cree la clase *BasicCalculator.java* en el paquete clase `org.medellin.app.calculator`  
Adicione el logger para manejar los logs de la clase *BasicCalculator.java*
~~~
private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);
~~~ 
Cree el método sumar adicionando un log de información tal como se muestra a continuación:
~~~
public Long sum(Long number1, Long number2) {
    logger.info( "Summing {} + {}", number1, number2 );
    return number1 + number2;
}
~~~
*TODO: Completar las demás operaciones aritméticas.*  
*NOTA: Tener en cuenta la división sobre cero.*

La clase `src/main/java/org/medellin/app/App.java` va a contener el método main, la cual se va a usar como puerta de entrada a la calculadora. Abra dicha clase y ubique el método main `public static void main( String[] args )`.  
En esta clase se adiciona el codigo para leer dos numeros por consola, la aplicación devolverá el resultado de la suma de estos: 
~~~
public class App {

	private static final  Logger logger = LoggerFactory.getLogger( App.class );

	public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        
        System.out.println( "Enter number 1: " );
        String textNumber1 = bufferedReader.readLine();
        
        System.out.println( "Enter number 2: " );
        String textNumber2 = bufferedReader.readLine();
        
        Long number1 = Long.valueOf( textNumber1 );
        Long number2 = Long.valueOf( textNumber2 );
        
        BasicCalculator calculator = new BasicCalculator();
        Long result = calculator.sum( number1, number2 );
        
        System.out.println( number1 + " + " + number2 + " = " + result );
    }
}
~~~

## Creación de casos de pruebas
Crea los casos de pruebas de la clase `BasicCalculator.java` ubicada en `src/main/java/org/medellin/app/calculator` como se explica a continuación:

##### 1. Actualizar la dependencia de JUnit a Jupiter #####
Abre el archivo pom.xml y cambia la dependencia de JUnit existente por la nueva versión JUnit/Jupiter:
~~~
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.5.1</version>
    <scope>test</scope>
</dependency>
~~~
*NOTA: Los paquetes que debe importar para los tests están dentro de `org.junit.jupiter`*


##### 2. Agregar el plugin surefire al build para la ejecución de los test unitarios y la generación de los reportes #####
~~~
<build>
  <plugins>
         <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</build>
~~~

##### 3. Creación de la clase de pruebas #####
Cree la clase *BasicCalculatorTest.java* en el paquete `src/test/java/org/medellin/app/calculator` para manejar las pruebas unitarias de la clase *BasicCalculator.java*  

*NOTA: La clase de pruebas unitarias puede tener un nombre diferente, pero por buenas prácticas se recomienda utilizar el mismo nombre de la clase a probar con el sufijo "Test"*.

##### 4. Adición de pruebas unitarias con JUnit/Jupiter #####
Instanciar la clase a probar como un sujeto de prueba, en este caso un objeto de tipo *BasicCalculator.java*
~~~
public class CalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();
    ...
}
~~~
Creee los test unitarios utilizando el patrón AAA(Arrange-Act-Assert):  
**Arrange**: Inicialización de objetos y asignación de variables.  
**Act**: Invocación del método a probar con los valores previamente inicializados.  
**Assert**: Verifica si el valor obtenido por el método antes ejecutado es el esperado.  

##### Creación del test unitario para la suma: #####

- Iniciar con el primer caso de prueba, un caso de exito. Crea un método sum. Este método va a usar el sujeto de prueba para sumar 1 con 1.
~~~        
public void sum() {
    // Arrange
    Long number1 = 1L;
    Long number2 = 1L;
    
    // Act
    basicCalculator.sum(number1, number2);
}
~~~
- Luego se debe validar si el resultado de la suma es correcto, asi que se agrega un assertEquals validando que el resultado debe ser 2.
~~~        
public void sum() {
    // Arrange
    Long number1 = 1L;
    Long number2 = 1L;
    Long expectedValue = 2L;
    
    // Act
    Long result = basicCalculator.sum(number1, number2);
    
    // Assert
    assertEquals(expectedValue, result);
}
~~~
- Ahora, se debe indicarle a JUnit que este método es un caso de prueba que puede ejecutarse, así que se le agrega la anotación `@Test`
~~~
@Test
public void sum() {
    // Arrange
    Long number1 = 1L;
    Long number2 = 1L;
    Long expectedValue = 2L;
    
    // Act
    Long result = basicCalculator.sum(number1, number2);
    
    // Assert
    assertEquals(expectedValue, result);
}
~~~
- Para que el caso de prueba sea más descriptivo, se puede agregar la anotación `@DisplayName` indicando de qué trata el caso de prueba.
~~~
@Test
@DisplayName("Testing sum: 1+1=2")
public void sum() {
    // Arrange
    Long number1 = 1L;
    Long number2 = 1L;
    Long expectedValue = 2L;
    
    // Act
    Long result = basicCalculator.sum(number1, number2);
    
    // Assert
    assertEquals(expectedValue, result);
}
~~~

- Ahora se puede ejecutar este caso de prueba con el comando `mvn clean test`

En el caso anterior, solo se usó un caso de entrada (1 y 1).  
Qué pasa si se desea probar la misma lógica de negocio (sumar) pero con muchos más casos de prueba?  

- Definición de multiples casos de entrada usando la anotación `@CsvSource`:
~~~
@DisplayName("Testing several sums")
@ParameterizedTest(name = "{0} + {1} = {2}")
@CsvSource({
        "0,    1,   1",
        "1,    2,   3",
        "49,  51, 100",
        "1,  100, 101"
})
public void severalSums(Long first, Long second, Long expectedResult) {
    assertEquals(expectedResult, basicCalculator.sum(first, second),
                 () -> first + " + " + second + " should equal " + expectedResult);
}
~~~
- `@CvsSource` define multiples casos de entrada y sus respectivas salidas esperadas. Cada caso de prueba es una fila, donde la primera columna es el primer operando, la segunda es el segundo operando, y la tercera representa el resultado esperado. Los datos de cada fila son pasados al metodo severalSums como parámetros.  

- JUnit recorre cada fila ejecutando el método `severalSums` con los datos de cada fila.

- También se puede agregar una descripción dinámica a la prueba, para hacerle seguimiendo. Para esto se usa la anotación `@ParameterizedTest`.

`@ParameterizedTest` describe el caso de prueba basado en los casos de entrada definidos en `@CvsSource`. Esto significa que por cada caso de prueba (fila) en `@CvsSource`, se va a mostrar una descripción de la forma {0} + {1} = {2}, donde 0 representa la primera posición de la fila, 1 la segunda y 2 la tercera.

- Luego se puede ejecutar este caso de prueba con el comando `mvn clean test`

## Creación de ejecutable

- Agregar el plugin para el empaquetado del artefacto:
~~~
<build>
    <plugins>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <configuration>
                <archive>
                    <manifest>
                      <mainClass>org.medellin.app.App</mainClass>
                    </manifest>
                </archive>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>
        </plugin>
    </plugins>
</build>
~~~
El siguiente comando empaqueta el binario en la carpeta `target/*.jar`. El comando compila y construye el nuevo artefacto:
~~~
mvn clean compile assembly:single
~~~
Para empaquetar sin necesidad compilar los tests se usa el siguiente comando:
~~~
mvn clean compile assembly:single -DskipTests=true
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
Mover los archivos de Staging Area a Git Repository
~~~
git commit -m "Descripción de los cambios realizados en este commit."
~~~

## Actualización del repositorio remoto
Crear un nuevo repositorio en el servicio de repositorios remotos.  

Adicionar el repositorio remoto de origen
~~~
git remote add [origin] [SSH/HTTPS]
git remote add origin https://github.com/comunidad-hispana-jugs/decodificando-java-con-maven-junit-github.git
~~~
Subir los cambios realizados desde una rama en el repositorio local hacia una rama en el repositorio remoto:
~~~
git push [origin] [name-branch]
git push origin meetupfebrero2020
~~~
