# six-pits-service

Service module for six-pits solution

## Development requirements

- Visual Studio Code with [Language Support for Java](https://marketplace.visualstudio.com/items?itemName=redhat.java)
  and [VSCode Lombok plugin](https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok).
- Linux or mac os machine (tested on mac os mojave and fedora linux 28).
- Java JDK 8 or superior available from command line.
- gradle 5 or newer. See installing instructions [here](https://gradle.org/install/).

## Usage

In order to execute the service project, all you need to do is to open a terminal and call `gradle bootRun`.

If you need to evolve the database, **flyway** migrations can be created in `src/main/resources/db/migrations` folder.
It also allows the creation of test-only migrations in `src/test/resources/db/migrations` folder.

The test and coverage report can be created with the `gradle test jacocoTestReport` command. Once it finishes the
reports will be in `build/reports` folder.

## Issues

The **@PrePersist** annotation was adopted to avoid some unwanted default behavior from JPA. The model is intentionally
thing and holds as minimum knowledge about the database schema as possible. It is however a full featured ORM so one or
two adjustments were made.

Some artifacts where excluded from **jacoco's coverage reports** because they where worthless to cover (get/set calls for
example). The core business however has two test suites, one with unit tests and other with some integration tests
showing that the REST API works as expected given a not empty initial state.

Spring Boot Rest adopts the HTTP verb PATCH as it's 'update' verb. On my approach however i decided to adopt PUT and
therefore i faced lack of support on test environment. Being more specific, the `ResourcesTestSuite.shouldRenameJoe()`
isn't clear as desired.

## Directions planned but not implemented

- Reverse communication with web client using websockets or something else
- Heroku hosting publishing or any other PaaS
- [Production profile](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
  to be enabled by environment variable or command line argument
- Checkstyle to create a common idiom to be respected by a future team
