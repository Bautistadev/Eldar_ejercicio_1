# Sistema de Procesamiento de Operaciones con Tarjetas de Crédito 💳

## Descripción

Este sistema permite procesar operaciones con tarjetas de crédito de diferentes marcas y ofrece funcionalidades para registrar usuarios, tarjetas, y consultar información relacionada. El sistema garantiza que las operaciones cumplan con ciertos criterios de validación, como la cantidad máxima permitida y la validez de la tarjeta.

### Características principales:
- Validación de tarjetas por fecha de vencimiento.
- Validación de operaciones por monto (máximo de 10,000 pesos).
- Cálculo de tasas de servicio según la marca de tarjeta (VISA, NARA, AMEX).
- El CVV es un dato sensible requerido para procesar operaciones.

## Requisitos

El sistema implementa las siguientes funcionalidades:

1. **Registro de usuarios**: Permite registrar una persona indicando nombre, apellido, DNI, fecha de nacimiento y email.
2. **Registro de tarjetas**: Permite registrar una tarjeta con los siguientes datos:
    - Marca de tarjeta (VISA, NARA, AMEX).
    - Número de tarjeta.
    - Fecha de vencimiento.
    - Nombre completo del titular (cardholder).
    - CVV privado de 3 dígitos.
3. **Consulta de tarjetas**: Permite retornar información de las tarjetas asociadas a un usuario dado su DNI.
4. **Consulta de tasas**: Calcula las tasas de todas las marcas de tarjetas para una fecha específica. Si no se proporciona una fecha, se usa la fecha actual.

## Reglas de Validación

- Una operación es válida si:
    - La tarjeta utilizada no ha expirado (la fecha de vencimiento debe ser mayor a la fecha actual).
    - El monto de la operación es menor a 10,000 pesos.
    - Se proporciona el CVV correcto para la tarjeta.
- Las tasas de servicio se calculan de la siguiente manera:
    - **VISA**: Año dividido por mes (Ejemplo: 20/12).
    - **NARA**: Día del mes multiplicado por 0.5 (Ejemplo: 27 * 0.5).
    - **AMEX**: Mes multiplicado por 0.1 (Ejemplo: 9 * 0.1).

## Menú interactivo

El sistema ofrece un menú interactivo por consola con las siguientes opciones:

1. **Registrar una persona**: Solicita los datos personales (nombre, apellido, DNI, fecha de nacimiento, email) para registrar un usuario.
2. **Registrar una tarjeta**: Solicita los datos de la tarjeta (marca, número, fecha de vencimiento, nombre del titular) y asocia la tarjeta al usuario registrado.
3. **Consultar tarjetas**: Permite consultar las tarjetas asociadas a un usuario por medio de su DNI.
4. **Consultar tasas de tarjetas**: Calcula y muestra las tasas de todas las marcas para una fecha específica. Si no se proporciona una fecha, usa la fecha actual.

## Ejecución

1. Asegúrate de tener instalado [Java](https://www.java.com) para ejecutar el sistema.
2. Clona este repositorio:
   ```bash
   git clone https://github.com/Bautistadev/Eldar_ejercicio_1.git
   ```
3. Ingresar al directorio descargado y dirigirse al directorio target
4. Ejercutar:
    ```bash
   java -jar Ejercicio_1-1.0-SNAPSHOT.jar
   ```