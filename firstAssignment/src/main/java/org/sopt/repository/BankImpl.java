package org.sopt.repository;

import org.sopt.entity.Customer;

import java.util.HashMap;

public class BankImpl implements Bank {
    // 고객 정보 저장소(Hash map)
    HashMap<String, Customer> bank = new HashMap<String, Customer>();

    // 고객정보 저장 메소드 오버라이딩
    // [수정] 계좌번호를 키로 저장
    @Override
    public void save(Customer customer) {
        bank.put(customer.getAccount(), customer);
    }

    // 이름으로 고객 찾기 메소드 오버라이딩
    // [수정]계좌번호로 고객찾기
    @Override
    public Customer findByAccount(String name) {
        return bank.get(name);
    }
}
