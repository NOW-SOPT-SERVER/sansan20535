package org.sopt.service;

import org.sopt.entity.Customer;

public class BankServiceImpl implements BankService {

    // 예금_입금 구현
    @Override
    public Long deposit(Customer customer, Long money) {
        customer.setAsset(customer.getAsset() + money);
        return customer.getAsset();
    }

    // 예금_출금 구현
    @Override
    public Long withdraw(Customer customer, Long money) {
        if (customer.getAsset() - money < 0) {
            throw new IllegalArgumentException();
        }
        customer.setAsset(customer.getAsset() - money);
        return customer.getAsset();
    }

    // 예금_계좌이체 구현
    @Override
    public Long accountTransfer(Customer customerFrom, Customer customerTo, Long money) {
        if (customerFrom.getAsset() - money < 0) {
            throw new IllegalArgumentException();
        }
        customerFrom.setAsset(customerFrom.getAsset() - money);
        customerTo.setAsset(customerTo.getAsset() + money);
        return customerFrom.getAsset();
    }
}
