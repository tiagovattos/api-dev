Atividade De Fixação CEPEIN (Backend).
Objetivo do projeto - Desenvolver um projeto Spring Boot atendendo aos requisitos acima e promovendo boas
práticas de desenvolvimento.
Tecnologias utilizadas:
Java 21
Spring Boot 3.3.1
Build Tool Maven
Spring Boot DevTools
Lombok
H2 Database
Spring Data JPA
Spring Web
Validation

O projeto deve conter:
Tabelas: O projeto deve conter no mínimo 4 tabelas.
Atributos: As entidades devem ter atributos dos tipos String, Long, LocalDateTime,
LocalDate, BigDecimal e Enum.
Requisições: Implementar operações utilizando lambda, streams e conversão de datas.
CRUD: Implementar operações CRUD para todas as entidades.
Relacionamentos: Incluir todos os tipos de relacionamento:
a. One-to-One (Um-para-um)
b. One-to-Many (Um-para-muitos)
c. Many-to-One (Muitos-para-um)
d. Many-to-Many (Muitos-para-muitos)
Identificador Composto: Utilizar `@EmbeddedId` em uma das entidades.
Tratamento de Exceções: Implementar um mecanismo de tratamento global de exceções
utilizando `@ControllerAdvice` e `@ExceptionHandler`.
PathVariable e RequestParam: Demonstrar o uso de `@PathVariable` e `@RequestParam`
nos endpoints da API.
JPA Query Methods:
1. findBy
2. findFirstBy
3. findByAnd
4. findByOr
5. findByIn
6. findByOrderByDesc
7. findByBetween
8. deleteBy
9. findByOrderBy
10. findByLessThan
11. findByLessThanEqual
12. findByGreaterThan
13. findByGreaterThanEqual
