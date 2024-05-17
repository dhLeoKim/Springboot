package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetApiController {

    @GetMapping(path = "/hello/2")          // GetMapping을 ctrl + 클릭 하여 사용가능한 옵션 확인, path="URL 주소"
    public String getHello() {
        return "get Hello";
    }

//    @GetMapping("/pathVariable/{name}")     // {}으로 pathVariable 사용
//    public String pathVariable(@PathVariable String name){
//        System.out.println("PathVariable : " + name);
//
//        return name;
//    }

    @GetMapping("/pathVariable/{id}")     // 변수의 이름과 pathVariable을 다르게 설정해야하는 경우
    public String pathVariable(@PathVariable(name="id") String pathName){
        System.out.println("PathVariable : " + pathName);

        return pathName;
    }

    // http://localhost:8080/api/query-param?user=abc&email=abc@abc.com
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){     // Map으로 모두 받을 수 있게

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(             // 특정 query만 받을 수 있게 명시
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    /////////////////////////////////////////
    // 가장 많이 사용하는 방법
    // 받는 DTO 생성하여 맵핑

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
