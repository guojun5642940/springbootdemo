package com.guoj.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.guoj.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author guojun
 * @Title: TokenService
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019-12-1715:49
 */
@Service
public class TokenService {

    public String getToken(SysUser user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId().toString()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}