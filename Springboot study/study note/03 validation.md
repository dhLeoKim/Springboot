# springboot 프로젝트 기록
## validation
### validation 유효성 검사
* Controller 에서 @Valid 를 사용하여 유효성 체크
* Domain 에서 @Size 를 사용하여 범위, @Past를 사용하여 시간에 해당하는 검사 가능

### internationalization 다국어 처리
* LocaleResolver 빈으로 등록하기
```yml
spring:
  message:
    basename: messages
```
* basename 설정 후, 해당 이름으로 properties 파일 생성
```
messages.properties
messages_kr.properties
```
* @RequestHeader 를 사용하여 헤더에 설정 값 인자로 받기

#### 인코딩 이슈
* IntelliJ -> settings -> encoding 검색
* 경로 지정 후, UTF-8 혹은 용도에 맞게 인코딩 설정

### Filtering
* @JsonIgnore 를 사용하여 외부에 노출시키고 싶지 않은 정보를 숨길 수 있음
  * 개별적으로 설정
* @JsonIgnoreProperties 를 사용하여 일괄 설정 가능
* @JsonFilter 를 사용하여
* @Requestmapping 을 사용하여 해당 컨트롤러의 URI 앞에 prefix처럼 사용 가능
* BeanUtils.copyProperties 을 객체간의 값들 복사할 때 사용
```java
        // 어떤 필드를 포함하고 싶은지, 특정 필드만 포함하는 필터 생성
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        // UserInfo 라는 id(이름)에 필터를 적용, FilterProvider로 사용
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        // adminUser를 담은 mapping에 필터 적용
        mapping.setFilters(filters);
```

### URI를 활용한 버전 관리
* URI에 버전을 명시
  * 예시 : /v1/users 
* Domain 에서도 @JsonFilter("UserInfoV1")를 사용하여 버전별로 관리 가능

### parameter와 header를 활용한 버전 관리
* QueryString parameter를 사용해서 버전관리, params = "version=1" 설정
  * 예시 : /users/?version=1
* header를 사용해서 버전 관리, headers = "X-API-VERSION=1" 설정
  * header 값에 X-API-VERSION 값을 담아서 요청
* mime-type을 이용한 버전 관리

#### 버전관리 주의사항
* URI에 과도한 정보 제공 지양 (버전)
* 헤더값 사용 주의
* 캐시문제 발생 가능
* 용도에 맞게 설계
  * 웹브라우져에서 바로 실행 가능 (URI에 명시, request parameter 사용) or 실행 불가 (header, mime-type)
* API 문서화 잘 해두기