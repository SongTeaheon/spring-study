package com.study.song.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* 사용자 정보를 DB에 넣기 위한 모델
* Roles와 Authority는 권한을 위한 것으로, ","를 기준으로 append한다.
* */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;
    @Column
    private String password;

    private String roles = "";

    private String permissions = "";

    public User(String email, String password, String roles, String permissions) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
    }
    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }

        return new ArrayList<>();
    }
}
