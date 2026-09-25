# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `Dockerfile` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `docker-compose.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `src/main/java/com/productos/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/productos/infrastructure/adapters/ProductJpaAdapter.java` — `ProductJpaRepository.save`: Se invoca `save` sobre `ProductJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Chapter Backend, Especialidad Desarrollador, Tecnologia Java, Advanced - Aplica metodologias de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatizacion como Cucumber, el framework Karate, etc. - Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con solida base en arquitectura y testing.

### Reto
- Tema: Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un sistema de gestión de productos con BDD
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Registro básico de productos — objetivo: Implementar la funcionalidad para registrar productos con las validaciones básicas de nombre y precio. — entregable (NO resolver): Sistema capaz de registrar productos con las validaciones básicas.
- Fase 2: Manejo de alta carga — objetivo: Optimizar el sistema para manejar un throughput de 1 500 solicitudes por segundo en hora pico. — entregable (NO resolver): Sistema optimizado para manejar un throughput de 1 500 solicitudes por segundo en hora pico.
- Fase 3: Integración con BDD y frameworks de automatización — objetivo: Integrar el sistema con BDD y frameworks de automatización para asegurar la calidad del código y la cobertura de pruebas. — entregable (NO resolver): Sistema integrado con BDD y frameworks de automatización con una cobertura de pruebas adecuada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.productos</groupId>
    <artifactId>productos-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>productos-service</name>
    <description>Sistema de gestión de productos con BDD y manejo de alta carga</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
        <cucumber.version>7.15.0</cucumber.version>
        <karate.version>1.4.0</karate.version>
        <springdoc.version>2.5.0</springdoc.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
            <version>3.1.4</version>
        </dependency>

        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.intuit.karate</groupId>
            <artifactId>karate-junit5</artifactId>
            <version>${karate.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- API Documentation -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>3.2.5</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
        </repository>
    </repositories>
</project>

// === ARCHIVO: src/main/java/com/productos/Application.java ===
package com.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import java.time.Duration;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Resilience4JCircuitBreakerFactory circuitBreakerFactory() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(5)
                .build();

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        return new Resilience4JCircuitBreakerFactory(
                new Resilience4JConfigBuilder()
                        .circuitBreakerConfig(circuitBreakerConfig)
                        .timeLimiterConfig(timeLimiterConfig)
                        .build());
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: productos-service
  datasource:
    url: jdbc:postgresql://localhost:5432/productos_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      idle-timeout: 30000
      connection-timeout: 20000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
          order_inserts: true
          order_updates: true

server:
  port: 8080
  tomcat:
    threads:
      max: 200
      min-spare: 10
    connection-timeout: 20000ms

resilience4j:
  circuitbreaker:
    instances:
      productService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
          - org.springframework.web.client.ResourceAccessException
  ratelimiter:
    instances:
      productRateLimiter:
        limitForPeriod: 1500
        limitRefreshPeriod: 1s
        timeoutDuration: 0
        registerHealthIndicator: true
        eventConsumerBufferSize: 100
  timelimiter:
    instances:
      productTimeLimiter:
        timeoutDuration: 2s
        cancelRunningFuture: true

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
    operationsSorter: method

// === ARCHIVO: src/main/java/com/productos/domain/Product.java ===
package com.productos.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private final String name;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @PositiveOrZero(message = "El precio del producto no puede ser negativo")
    private final BigDecimal price;

    @NotNull(message = "El stock del producto no puede ser nulo")
    @PositiveOrZero(message = "El stock del producto no puede ser negativo")
    private final Integer stock;

    @NotBlank(message = "La categoría del producto no puede estar vacía")
    private final String category;

    public Product(String id, String name, BigDecimal price, Integer stock, String category) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.price = Objects.requireNonNull(price, "El precio no puede ser nulo");
        this.stock = Objects.requireNonNull(stock, "El stock no puede ser nulo");
        this.category = Objects.requireNonNull(category, "La categoría no puede ser nula");
        validate();
    }

    private void validate() {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
               Objects.equals(name, product.name) &&
               Objects.equals(price, product.price) &&
               Objects.equals(stock, product.stock) &&
               Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, stock, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/productos/domain/ProductRepository.java ===
package com.productos.domain;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByName(String name);
    boolean existsByName(String name);
}

// === ARCHIVO: src/main/java/com/productos/domain/ProductService.java ===
package com.productos.domain;

import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import com.productos.infrastructure.exceptions.InvalidProductException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = Objects.requireNonNull(productRepository, "El repositorio de productos no puede ser nulo");
    }

    public Product registerProduct(@NotNull @Valid Product product) {
        validateProduct(product);
        ensureProductDoesNotExist(product.getName());

        Product productWithId = new Product(
            UUID.randomUUID().toString(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCategory()
        );

        return productRepository.save(productWithId);
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new InvalidProductException("El producto no puede ser nulo");
        }
    }

    private void ensureProductDoesNotExist(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("El producto con nombre '" + name + "' ya existe");
        }
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/repositories/ProductJpaRepository.java ===
package com.productos.infrastructure.repositories;

import com.productos.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName(@Param("name") String name);
}

// === ARCHIVO: src/main/java/com/productos/application/ProductUseCase.java ===
package com.productos.application;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.InvalidProductException;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class ProductUseCase {
    private final ProductService productService;

    @Autowired
    public ProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public Product registerProduct(@NotNull @Valid Product product) throws InvalidProductException, ProductAlreadyExistsException {
        return productService.registerProduct(product);
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/adapters/ProductJpaAdapter.java ===
package com.productos.infrastructure.adapters;

import com.productos.domain.Product;
import com.productos.domain.ProductRepository;
import com.productos.infrastructure.repositories.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ProductJpaAdapter implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductJpaAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productJpaRepository.findByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return productJpaRepository.findByName(name).isPresent();
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/controllers/ProductController.java ===
package com.productos.infrastructure.controllers;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import com.productos.infrastructure.exceptions.InvalidProductException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> registerProduct(@Valid @RequestBody Product product) {
        try {
            Product registeredProduct = productService.registerProduct(product);
            return new ResponseEntity<>(registeredProduct, HttpStatus.CREATED);
        } catch (InvalidProductException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ProductAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/config/Resilience4jConfig.java ===
package com.productos.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(Duration.ofSeconds(60))
               .ringBufferSizeInHalfOpenState(10)
               .ringBufferSizeInClosedState(10)
               .build();
    }

    @Bean
    public RetryConfig customRetryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public TimeLimiterConfig customTimeLimiterConfig() {
        return TimeLimiterConfig.custom()
               .timeoutDuration(Duration.ofSeconds(5))
               .build();
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/exceptions/GlobalExceptionHandler.java ===
package com.productos.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<String> handleInvalidProductException(InvalidProductException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/exceptions/ProductAlreadyExistsException.java ===
package com.productos.infrastructure.exceptions;

import com.productos.domain.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductAlreadyExistsException extends RuntimeException {
    private final Product product;
    private final Set<ConstraintViolation<Product>> violations;

    public ProductAlreadyExistsException(Product product, Set<ConstraintViolation<Product>> violations) {
        super("El producto ya existe");
        this.product = product;
        this.violations = violations;
    }

    public Product getProduct() {
        return product;
    }

    public Set<ConstraintViolation<Product>> getViolations() {
        return violations;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder("El producto ya existe: ");
        message.append(product.getName()).append(". Violaciones: ");
        for (ConstraintViolation<Product> violation : violations) {
            message.append(violation.getMessage()).append(", ");
        }
        return message.toString();
    }
}

// === ARCHIVO: src/main/java/com/productos/infrastructure/exceptions/InvalidProductException.java ===
package com.productos.infrastructure.exceptions;

import com.productos.domain.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidProductException extends RuntimeException {
    private final Product product;
    private final Set<ConstraintViolation<Product>> violations;

    public InvalidProductException(Product product, Set<ConstraintViolation<Product>> violations) {
        super("El producto es inválido");
        this.product = product;
        this.violations = violations;
    }

    public Product getProduct() {
        return product;
    }

    public Set<ConstraintViolation<Product>> getViolations() {
        return violations;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder("El producto es inválido: ");
        message.append(product.getName()).append(". Violaciones: ");
        for (ConstraintViolation<Product> violation : violations) {
            message.append(violation.getMessage()).append(", ");
        }
        return message.toString();
    }
}

// === ARCHIVO: src/test/java/com/productos/bdd/CucumberTest.java ===
package com.productos.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.productos.bdd.steps",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class CucumberTest {
}

// === ARCHIVO: src/test/resources/features/product_registration.feature ===
Feature: Product Registration

  As a user
  I want to register a new product
  So that I can manage the inventory

  Scenario: Register a new product with valid data
    Given a product with name "Product1", price 10.99, stock 100, category "Electronics"
    When the product is registered
    Then the product should be saved with name "Product1", price 10.99, stock 100, category "Electronics"

  Scenario: Register a product with duplicate name
    Given a product with name "Product1", price 10.99, stock 100, category "Electronics"
    And a product with name "Product1", price 15.99, stock 50, category "Electronics" already exists
    When the product is registered
    Then an error should be returned indicating that the product name already exists

  Scenario: Register a product with negative price
    Given a product with name "Product2", price -5.99, stock 100, category "Electronics"
    When the product is registered
    Then an error should be returned indicating that the price cannot be negative

// === ARCHIVO: src/test/java/com/productos/bdd/steps/ProductRegistrationSteps.java ===
package com.productos.bdd.steps;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductRegistrationSteps {

    @Autowired
    private ProductService productService;

    private Product product;
    private String errorMessage;

    @Given("a product with name \"{string}\", price {double}, stock {int}, category \"{string}\"")
    public void aProductWithNamePriceStockCategory(String name, double price, int stock, String category) {
        product = new Product(null, name, BigDecimal.valueOf(price), stock, category);
    }

    @When("the product is registered")
    public void theProductIsRegistered() {
        try {
            product = productService.registerProduct(product);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the product should be saved with name \"{string}\", price {double}, stock {int}, category \"{string}\"")
    public void theProductShouldBeSavedWithNamePriceStockCategory(String name, double price, int stock, String category) {
        assertNotNull(product);
        assertEquals(name, product.getName());
        assertEquals(BigDecimal.valueOf(price), product.getPrice());
        assertEquals(stock, product.getStock());
        assertEquals(category, product.getCategory());
    }

    @Then("an error should be returned indicating that the product name already exists")
    public void anErrorShouldBeReturnedIndicatingThatTheProductNameAlreadyExists() {
        assertNotNull(errorMessage);
        assertEquals("Product already exists", errorMessage);
    }

    @Then("an error should be returned indicating that the price cannot be negative")
    public void anErrorShouldBeReturnedIndicatingThatThePriceCannotBeNegative() {
        assertNotNull(errorMessage);
        assertEquals("Price cannot be negative", errorMessage);
    }
}

// === ARCHIVO: src/test/java/com/productos/bdd/KarateTest.java ===
package com.productos.bdd;

import com.intuit.karate.junit5.Karate;

public class KarateTest {

    @Karate.Test
    Karate testProductRegistration() {
        return Karate.run("product_registration").relativeTo(getClass());
    }
}

// === ARCHIVO: src/test/resources/karate/product_registration.feature ===
Feature: Product Registration

  Scenario: Register a new product
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Test Product",
      "price": 100,
      "stock": 10,
      "category": "Test Category"
    }
    When method post
    Then status 201
    And match response == {
      "id": '#notnull',
      "name": "Test Product",
      "price": 100,
      "stock": 10,
      "category": "Test Category"
    }

  Scenario: Attempt to register a product with an existing name
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Existing Product",
      "price": 200,
      "stock": 20,
      "category": "Existing Category"
    }
    When method post
    Then status 409
    And match response == {
      "error": "Product with name Existing Product already exists"
    }

  Scenario: Attempt to register a product with a negative price
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Test Product 2",
      "price": -100,
      "stock": 10,
      "category": "Test Category"
    }
    When method post
    Then status 400
    And match response == {
      "error": "Price must be a positive number"
    }

// === ARCHIVO: src/test/java/com/productos/ProductServiceTest.java ===
package com.productos;

import com.productos.domain.Product;
import com.productos.domain.ProductRepository;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.InvalidProductException;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterProduct_Success() {
        Product product = new Product("1", "Test Product", new BigDecimal("100"), 10, "Test Category");
        when(productRepository.save(product)).thenReturn(product);
        Product registeredProduct = productService.registerProduct(product);
        assertNotNull(registeredProduct);
        assertEquals(product, registeredProduct);
    }

    @Test
    void testRegisterProduct_ProductAlreadyExists() {
        Product product = new Product("1", "Existing Product", new BigDecimal("200"), 20, "Existing Category");
        when(productRepository.existsByName(product.getName())).thenReturn(true);
        Exception exception = assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.registerProduct(product);
        });
        assertEquals("Product with name Existing Product already exists", exception.getMessage());
    }

    @Test
    void testRegisterProduct_InvalidPrice() {
        Product product = new Product("1", "Test Product 2", new BigDecimal("-100"), 10, "Test Category");
        Exception exception = assertThrows(InvalidProductException.class, () -> {
            productService.registerProduct(product);
        });
        assertEquals("Price must be a positive number", exception.getMessage());
    }
}

// === ARCHIVO: Dockerfile ===
FROM openjdk:21-jdk AS build
WORKDIR /app
COPY. /app
RUN./mvnw clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/productos-service-0.0.1-SNAPSHOT.jar /app/productos-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/productos-service.jar"]

// === ARCHIVO: docker-compose.yml ===
version: '3.8'
services:
  app:
    build:.
    ports:
      - '8080:8080'
    depends_on:
      - db
  db:
    image: postgres:13
    environment:
      POSTGRES_DB: productos
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
    ports:
      - '5432:5432'
  monitoring:
    image: prometheus/prometheus
    ports:
      - '9090:9090'
    volumes:
      -./prometheus.yml:/etc/prometheus/prometheus.yml
    depends_on:
      - app
```
