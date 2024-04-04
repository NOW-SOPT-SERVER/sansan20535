package org.sopt.service;

import org.sopt.entity.Customer;

public interface BankService {
    // 예금_입금
    public Long deposit(Customer customer, Long money);
    // 예금_출금
    public Long withdraw(Customer customer, Long money);
    // 예금_계좌이체
    public Long accountTransfer(Customer customerFrom, Customer customerTo, Long money);
}
