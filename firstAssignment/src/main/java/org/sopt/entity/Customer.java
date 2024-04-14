package org.sopt.entity;

public class Customer {

    // 고객 아이디
    private Long id;

    // 고객 이름
    private String name;

    // 계좌번호
    private String account;

    // 자산
    private Long asset;

    // 생성자
    public Customer(Long id, String name, String account, Long asset) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.asset = asset;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public Long getAsset() {
        return asset;
    }

    public void setAsset(Long asset) {
        this.asset = asset;
    }
}
