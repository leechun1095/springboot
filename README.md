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

## @ModelAttribute
* Spring MVC에서 사용되는 어노테이션으로, 주로 요청 파라미터를 Java 객체로 바인딩하는 데 사용됩니다.
* 주로 컨트롤러 메소드에서 입력 데이터를 처리할 때 사용됩니다. 
* 이 어노테이션을 사용하면 HTTP 요청 파라미터를 자동으로 Java 객체의 필드에 매핑할 수 있습니다.
### 주요 용도
1. 요청 파라미터를 객체로 바인딩: @ModelAttribute는 요청에서 전달된 파라미터를 지정된 객체에 자동으로 매핑합니다.
2. 모델 객체에 데이터를 추가: 컨트롤러 메소드에서 반환하는 데이터에 모델을 추가하거나, 뷰에서 사용할 데이터를 준비하는 데 사용됩니다.
```java
@RequestMapping("/getBoardList")
public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
  if(member.getId() == null) {
			 return "redirect:login";
		}
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
}
```

## @ControllerAdvice
* 모든 컨트롤러에서 발생하는 예외를 일괄적으로 처리
  
## @ExceptionHandler
* 각 컨트롤러마다 발생하는 예외를 개별적으로 처리하는 것

## 챕터 7 환경 셋팅
* Spring Boot 3.4.4와 Spring Security 5.1.5는 호환성에 문제가 있을 수 있다
  * 부트 2.7.17, jdk 1.8로 다운그레이드
  * build path - java compiler 1.8로 변경
  * <artifactId>spring-security-test</artifactId> 클릭 - 시큐리티 전부 5.1.5.RELEASE 로 버전 변경

```java
// pom.xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<!-- <version>3.4.4</version> -->
		<version>2.7.17</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<properties>
		<java.version>8</java.version>
		<maven.compiler.source>1.8</maven.compiler.source>
    	<maven.compiler.target>1.8</maven.compiler.target>
	</properties>
```

## @Component
* 일반적인 컴포넌트를 빈으로 등록할 때 사용
* 컴포넌트 스캔을 통해 빈으로 등록

## @Service
* 서비스 계층을 나타내는 특수화된 어노테이션 
* @Component의 역할을 확장한 것입니다. 
* 컴포넌트 스캔을 통해 빈으로 등록	
	
## @Repository
* 데이터 접근 객체(DAO)를 나타내는 어노테이션 
* @Component를 확장한 형태입니다. 
* 주로 데이터베이스와 관련된 클래스를 빈으로 등록할 때 사용합니다.	
	
## @Controller 
* Spring MVC에서 사용되는 컨트롤러를 나타내는 어노테이션
* @Component를 확장한 형태
* Spring MVC 웹 애플리케이션에서 컨트롤러 클래스를 빈으로 등록하는 데 사용됩니다.	
	
## @Configuration
* 빈을 정의하는 설정 클래스를 나타내는 어노테이션
* 이 어노테이션을 사용한 클래스는 애플리케이션의 설정 클래스로 간주되며, 
* 이 클래스 내에서 @Bean 어노테이션을 사용하여 명시적으로 빈을 등록할 수 있습니다.
