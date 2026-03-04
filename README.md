# GestionPolizas
# Módulo 2 – Prueba Técnica Práctica: API de Gestión de Pólizas

Este repositorio contiene la implementación técnica del **Módulo 2**.
El proyecto implementa los **requerimientos esenciales** de una API de gestión de pólizas y riesgos, con las reglas de negocio y un mock externo para registro de eventos.

---

## Tecnologías Utilizadas

- Java 17 y Spring Boot 3.x  
- Spring Security: Autenticación mediante API Key  
- H2 Database: Base de datos en memoria  
- Lombok: Reducción de código repetitivo  
- SpringDoc OpenAPI (Swagger): Documentación interactiva y pruebas de endpoints  

---

## Configuración y Ejecución

Clonar el repositorio:  

- git clone https://github.com/gabriela0821/GestionPolizas.git

## Acceso local

- **Puerto:** 8081  
- **Swagger UI:** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

---

## Seguridad (API Key)

Para consumir cualquier endpoint, se debe incluir el siguiente header en la petición:

- **Header:** `x-api-key`  
- **Valor:** `123456`  

---

## Endpoints Implementados

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET    | `/api/v1/polizas` | Listar pólizas por tipo y estado |
| GET    | `/api/v1/polizas/{id}/riesgos` | Listar riesgos asociados a una póliza específica |
| GET    | `/api/v1/riesgos` | Listar riesgos; opcionalmente filtrar por tipo o polizaId |
| POST   | `/api/v1/polizas/{id}/renovar` | Renovar póliza: incrementa canon y prima según IPC; cambia estado a "RENOVADA" |
| POST   | `/api/v1/polizas/{id}/cancelar` | Cancelar póliza y todos sus riesgos asociados |
| POST   | `/api/v1/polizas/{id}/agregarRiesgo` | Agregar riesgo solo si la póliza es colectiva |
| POST   | `/api/v1/polizas/{id}/agregarPoliza` | Crear una nueva póliza con los datos básicos |
| POST   | `/api/v1/riesgos/{id}/cancelar` | Cancelar riesgo específico |
| POST   | `/core-mock/evento` | Mock externo: registrar intento de envío de evento al CORE |

---

## Reglas de Negocio

- Una póliza individual solo puede tener 1 riesgo.  
- No se puede renovar una póliza cancelada.  
- La cancelación de una póliza cancela todos sus riesgos.  
- Agregar riesgo requiere validar que la póliza sea colectiva.  

---

## Estructura del Proyecto

El proyecto sigue **arquitectura limpia** y está organizado en capas:

- **Domain:**  
  - Entidades de negocio: `Poliza`, `Riesgo`  
  - DTOs para intercambio de datos  
  - Repositorios base: `PolizaRepository`, `RiesgoRepository`  

- **Application:**  
  - Servicios de negocio: `PolizaService`, `RiesgoService`  
  - Contiene la lógica principal de cada operación  

- **Infrastructure:**  
  - Entities JPA: `PolizaEntity`, `RiesgoEntity`  
  - Mappers: `PolizaMapper`, `RiesgoMapper`  
  - Repositorios JPA: `JPAPolizaRepository`, `JPARiesgoRepository`  

- **Interfaces:**  
  - Configuraciones: `SwaggerConfig` y seguridad (`APIKeyFilter`)  
  - Controladores REST: `PolizaController`, `RiesgoController`, `CoreMockController`  

Esta separación permite mantener **código modular, mantenible y escalable**.

---

## Notas Adicionales

- Mock externo `/core-mock/evento` solo registra en logs los intentos de envío de eventos al CORE.  
- Swagger permite probar todos los endpoints de forma interactiva y revisar la documentación.  
- API Key obligatoria en todas las peticiones para seguridad mínima.
