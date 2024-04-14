package org.sopt.controller;

import org.sopt.input.Input;
import org.sopt.repository.BankRepository;
import org.sopt.repository.BankRepositoryImpl;
import org.sopt.service.BankService;
import org.sopt.service.BankServiceImpl;
import org.sopt.view.View;

import java.util.StringTokenizer;

public class BankController {
    private final int BANK_REGISTER = 1;
    private final int BANK_DEPOSIT = 2;
    private final int BANK_EXIT = 3;
    private final int DEPOSIT_SAVE = 1;
    private final int DEPOSIT_WITHDRAW = 2;
    private final int DEPOSIT_TRANSFER = 3;
    private final BankRepository bankRepository;
    private final BankService bankService;
    int order, deposit;
    boolean exit;
    StringTokenizer info;
    String accountFrom, accountTo;
    Long money;

    public BankController(BankRepository bankRepository, BankService bankService) {
        this.bankRepository = bankRepository;
        this.bankService = bankService;
        this.exit = false;
    }

    public void run() {

        while (true) {
            View.init();
            order = Input.inputOrder();

            switch (order) {
                case BANK_REGISTER -> registerCustomer();
                case BANK_DEPOSIT -> depositMoney();
                case BANK_EXIT -> exit = true;
            }

            if (exit == true) {
                break;
            }
        }
    }

    public void registerCustomer() {
        View.printResister();
        bankRepository.save(Input.inputCustomer());
    }

    public void depositMoney() {
        View.printDepositOption();
        deposit = Input.inputDepositOption();
        depositOption(deposit);
    }

    public void depositOption(int deposit) {
        switch (deposit) {
            case DEPOSIT_SAVE -> saveMoney();
            case DEPOSIT_WITHDRAW -> withdrawMoney();
            case DEPOSIT_TRANSFER -> transferMoney();
        }
    }

    public void saveMoney() {
        View.printDeposit();
        info = Input.inputDeposit();
        accountFrom = info.nextToken();
        money = Long.parseLong(info.nextToken());
        bankService.deposit(bankRepository.findByAccount(accountFrom), money);
        View.printAfterDeposit(bankRepository.findByAccount(accountFrom).getName(), bankRepository.findByAccount(accountFrom).getAsset());
    }

    public void withdrawMoney() {
        View.printWithdraw();
        info = Input.inputWithdraw();
        accountFrom = info.nextToken();
        money = Long.parseLong(info.nextToken());
        try {
            bankService.withdraw(bankRepository.findByAccount(accountFrom), money);
            View.printAfterWithdraw(bankRepository.findByAccount(accountFrom).getName(), bankRepository.findByAccount(accountFrom).getAsset());
        } catch (IllegalArgumentException e) {
            View.printNotEnoughMoney();
        }
    }

    public void transferMoney() {
        View.printAccountTransfer();
        info = Input.inputAccountTransfer();
        accountFrom = info.nextToken();
        accountTo = info.nextToken();
        money = Long.parseLong(info.nextToken());
        try {
            bankService.accountTransfer(bankRepository.findByAccount(accountFrom), bankRepository.findByAccount(accountTo), money);
            View.printAfterAccountTransfer(bankRepository.findByAccount(accountFrom).getName(), bankRepository.findByAccount(accountFrom).getAsset());
        } catch (IllegalArgumentException e) {
            View.printNotEnoughMoney();
        }
    }
}
