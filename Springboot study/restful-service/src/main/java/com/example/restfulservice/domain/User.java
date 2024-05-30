package com.example.restfulservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password", "ssn"})
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {

    @Schema(title = "사용자 ID", description = "사용자 ID는 자동 생성")
    private Integer id;
    @Schema(title = "사용자 이름", description = "사용자 이름을 입력, 2글자 이상 제한")
    @Size(min = 2, message = "이름을 2글자 이상으로 입력해 주세요.")
    private String name;
    @Schema(title = "사용자 등록일", description = "사용자 등록일 입력, 미입력시 현재 날짜")
    @Past(message = "등록일은 미래 날짜를 입력할 수 없습니다.")
    private Date joinDate;

//    @JsonIgnore
    @Schema(title = "사용자 비밀번호", description = "사용자 비밀번호 입력")
    private String password;
//    @JsonIgnore
    @Schema(title = "사용자 주민번호", description = "사용자 주민번호 입력")
    private String ssn;
}
