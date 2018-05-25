package com.example.springboot.config;

public class Jwt {
    private int v;
    private String uid;
    private long iat;
    private TenmakerClaim claims;
    private long exp;

    public Jwt() {
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public void setClaims(TenmakerClaim claims) {
        this.claims = claims;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getV() {
        return this.v;
    }

    public String getUid() {
        return this.uid;
    }

    public long getIat() {
        return this.iat;
    }

    public TenmakerClaim getClaims() {
        return this.claims;
    }

    public long getExp() {
        return this.exp;
    }
}
