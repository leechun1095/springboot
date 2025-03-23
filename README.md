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

## 스프링 부트가 JSP를 권장하지 않는 가장 큰 이유
* 스프링 부트가 독립적으로 실행 가능한 애플리케이션을 빠르고 쉽게 만드는 것을 목표로 하기 때문임
* 따라서 웹 어플리케이션도 war가 아닌 jar로 패키징 할 수 있도록 지원하는 것이다.
* 화면을 JSP로 처리하면 war로 패키징 해야하고, war 패키징은 복잡한 폴더 구조를 구성해야 한다.
* 따라서 스프링 부트는 타임리프(Thymeleaf) 같은 템플릿 엔진을 사용하여 화면을 개발하도록 권장함

## @SessionAttributes
@SessionAttributes("member")
* Spring MVC에서 세션에 데이터를 저장하고 관리하는 데 사용하는 어노테이션입니다.
* 이 어노테이션을 사용하면 특정 모델 속성을 HTTP 세션에 자동으로 저장할 수 있게 됩니다.

