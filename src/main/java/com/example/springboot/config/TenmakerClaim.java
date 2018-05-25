package com.example.springboot.config;

import javax.servlet.http.HttpServletRequest;

public class TenmakerClaim {
    private String memberId;
    private String mail;
    private String name;
    private String nickname;
    private String tokenId;

    public TenmakerClaim() {
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    /*public static TenmakerClaim extract(String token) {
        Jwt jwt = (Jwt)GsonUtils.GsonToBean(JwtGenerator.JWTBodyDecode(token), Jwt.class);
        return jwt.getClaims();
    }*/

    /*public static TenmakerClaim extract(HttpServletRequest request) {
        return extract(request.getHeader("Access-Token"));
    }*/
}
