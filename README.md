# Atividade De Fixação CEPEIN (Backend).
> Objetivo do projeto - Desenvolver um projeto Spring Boot atendendo aos requisitos acima e promovendo boas práticas de desenvolvimento.

# 🛠️ Tecnologias utilizadas:
- **Java 21**
- **Spring Boot 3.3.2**
- **Build Tool Maven**
- Spring Web
- Spring Boot DevTools
- Lombok
- H2 Database
- Spring Data JPA
- Validation

## O projeto deve conter:
- **Tabelas**: O projeto deve conter no mínimo 4 tabelas e seus CRUDs.
- **Atributos**: As entidades devem ter atributos dos tipos String, Long, LocalDateTime,
LocalDate, BigDecimal e Enum.
- **Requisições**: Implementar operações utilizando lambda, streams e conversão de datas.
- **Relacionamentos**: Incluir todos os tipos de relacionamento:
  - One-to-One (Um-para-um)
  - One-to-Many (Um-para-muitos)
  - Many-to-One (Muitos-para-um)
  - Many-to-Many (Muitos-para-muitos)
- **Identificador Composto**: Utilizar `@EmbeddedId` em uma das entidades.
- **Tratamento de Exceções**: Implementar um mecanismo de tratamento global de exceções
utilizando `@ControllerAdvice` e `@ExceptionHandler`.
PathVariable e RequestParam: Demonstrar o uso de `@PathVariable` e `@RequestParam`
nos endpoints da API.
- **JPA Query Methods**:
  - findBy
  - findFirstBy
  - findByAnd
  - findByOr
  - findByIn
  - findByOrderByDesc
  - findByBetween
  - deleteBy
  - findByOrderBy
  - findByLessThan
  - findByLessThanEqual
  - findByGreaterThan
  - findByGreaterThanEqual
