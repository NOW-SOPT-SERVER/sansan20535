package org.sopt.repository;

import org.sopt.entity.Customer;

public interface BankRepository {

    // 고객 정보 저장
    public void save(Customer customer);

    //이름으로 고객 정보 찾기
    //[수정] 계좌번호로 고객 정보 찾기
    public Customer findByAccount(String account);
}
