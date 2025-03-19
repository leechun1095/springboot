# Spring Boot Quick Start

## @ConfigurationProperties
@ConfigurationProperties(prefix="board.jdbc")
* board.jdbc properties 파일에 설정할 프로퍼티를 접근하기 위한 접두사이다.
* 프로퍼티에 해당하는 Setter 메소드들이 자동으로 실행되어 프로퍼티 값들을 설정한다.
* board-spring-boot-stater 프로젝트 참조
  * BoardAutoConfiguration.java
  * JDBCConnectionManagerProperties.java
```java
-- application.properties
board.jdbc.driverClass=oracle.jdbc.driver.OracleDriver
board.jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
board.jdbc.username=hr
board.jdbc.password=hr
```
