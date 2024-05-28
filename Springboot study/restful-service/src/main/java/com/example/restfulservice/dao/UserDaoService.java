package com.example.restfulservice.dao;

import com.example.restfulservice.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    /**
     * DB에 저장하지 않고, 임시로 메모리에 저장하여 사용하는 목적
     * 호출시 생성, 종료시 삭제
     */
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "nameA", new Date()));
        users.add(new User(2, "nameB", new Date()));
        users.add(new User(3, "nameC", new Date()));
    }

    public List<User> findAll() {

        /**
         * 전체 유저 정보 찾기
         */

        return users;
    }

    public User save(User user) {

        /**
         * 유저 정보 저장
         */

        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        if (user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }

        users.add(user);

        return user;
    }

    public User findOne (int id) {

        /**
         * 특저 유저 하나의 정보 찾기
         */

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
