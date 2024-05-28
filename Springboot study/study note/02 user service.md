# springboot 프로젝트 기록
## user service
### User
* 사용자 도메인
  * 사용자 관리에 필요한 사용자 정보
* 사용자 서비스
  * 사용자서비스에 관련된 비즈니스 로직
  * JPA를 활용하여 DB에 저장

### UserDaoService
* @Component 를 사용하여 등록
  * @Service 를 사용해도 무방하지만,
  * bean의 역할도 같이 하기 위해서 사용

### UserController
* @RestController 를 사용하여 controller로 사용
* IntelliJ 에서 마우스 오른쪽 버튼 -> generate -> 생성자, setter, getter 생성 가능
* @PathVariable 를 사용하여 URI에서 변수 받아와 사용
* @RequestBody 를 사용하여 JSON과 같은 형태로 데이터 받아서 사용

### HTTP Status Code
* ResponseEntity 에 담아서 클라이언트에 데이터 반환
* ServletUriComponentsBuild 사용하여 
  * .path() : 기존 URI 주소에 path 안의 정보 추가한 URI
  * .buildAndExpand() : 어떤 정보를 받아서 URI에 사용하거나 전달
  * .toUri() : URI 정보로 만들어 전달

![](./img/2024-05-28-23-20-56.png)

### Exception Handling 예외 처리
* exception 패키지에 예외 처리 클래스들 생성하여 관리
* @ResponseStatus 를 사용하여 HTTP Status Code 설정
* 4xx : 클라측 에러
* 5xx : 서버측 에러