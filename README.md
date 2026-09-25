# Implementación de un sistema de gestión de productos con BDD

El sistema de gestión de productos debe permitir el registro de nuevos productos con nombre, precio, stock y categoría. Debe validar que los nombres de los productos no sean duplicados y que los precios no sean negativos. El sistema debe ser capaz de manejar escenarios de alta carga, con un throughput de 1 500 solicitudes por segundo en hora pico. Se espera que el sistema sea idempotente en el registro de productos, asegurando que múltiples solicitudes con la misma clave de producto no resulten en duplicados.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Registro básico de productos

**Objetivo:** Implementar la funcionalidad para registrar productos con las validaciones básicas de nombre y precio.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- El sistema debe permitir el registro de productos con nombre, precio, stock y categoría.
- Validar que los nombres de los productos no sean duplicados y que los precios no sean negativos.
- Asegurar que el sistema sea idempotente en el registro de productos.

**Entregable:** Sistema capaz de registrar productos con las validaciones básicas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo estructurar los datos para asegurar la unicidad de los nombres de los productos.
- Piensa en cómo manejar los errores de validación de forma efectiva.

</details>

### Fase 2: Manejo de alta carga

**Objetivo:** Optimizar el sistema para manejar un throughput de 1 500 solicitudes por segundo en hora pico.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- El sistema debe ser capaz de manejar un throughput de 1 500 solicitudes por segundo en hora pico.
- Implementar mecanismos para asegurar la idempotencia en el registro de productos bajo alta carga.

**Entregable:** Sistema optimizado para manejar un throughput de 1 500 solicitudes por segundo en hora pico.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de técnicas de escalado y optimización de rendimiento.
- Piensa en cómo asegurar la idempotencia bajo alta carga.

</details>

### Fase 3: Integración con BDD y frameworks de automatización

**Objetivo:** Integrar el sistema con BDD y frameworks de automatización para asegurar la calidad del código y la cobertura de pruebas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integrar el sistema con BDD y frameworks de automatización como Cucumber y Karate.
- Asegurar que el sistema tenga una cobertura de pruebas adecuada y que las pruebas sean efectivas.

**Entregable:** Sistema integrado con BDD y frameworks de automatización con una cobertura de pruebas adecuada.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo escribir pruebas efectivas usando BDD y frameworks de automatización.
- Piensa en cómo asegurar que las pruebas cubran todos los escenarios importantes.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es BDD y cómo se aplica en el desarrollo de software?
- **paraQueSirve**: ¿Para qué sirve integrar BDD y frameworks de automatización en el desarrollo de software?
- **comoSeUsa**: ¿Cómo se usa BDD y frameworks de automatización para escribir pruebas efectivas?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar BDD y frameworks de automatización?
- **queDecisionesImplica**: ¿Qué decisiones implica la integración de BDD y frameworks de automatización en el desarrollo de software?

## Criterios de Evaluacion

- Implementar la funcionalidad básica para registrar productos con las validaciones básicas.
- Optimizar el sistema para manejar un throughput de 1 500 solicitudes por segundo en hora pico.
- Integrar el sistema con BDD y frameworks de automatización con una cobertura de pruebas adecuada.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
