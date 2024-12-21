# springboot 프로젝트 기록
## board 예제
### @RestController vs @Controller
* @RestController = @Controller + @ResquestBody
* @RestController를 사용하면 하위 메소드에 @RequestBOdy 자동으로 적용
* @Controller를 사용하는 경우, 필요하다면 하위 메소드에 @RequestBody 사용 필요
```java
@RestController
public class MyRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```
```java
@Controller
public class MyController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }
}
```