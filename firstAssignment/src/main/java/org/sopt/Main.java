package org.sopt;

import org.sopt.input.Input;
import org.sopt.repository.Bank;
import org.sopt.repository.BankImpl;
import org.sopt.service.BankService;
import org.sopt.service.BankServiceImpl;
import org.sopt.view.View;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        int order, deposit;
        Bank bank = new BankImpl();
        BankService bankService = new BankServiceImpl();
        StringTokenizer info;
        String accountFrom, accountTo;
        Long money;

        while (true){
            // 초기 화면 출력 및 작업 입력
            View.init();
            order = Input.inputOrder();

            // 등록작업
            if (order == 1){

                //화면 출력 및 입력
                View.printResister();
                bank.save(Input.inputCustomer());
            }

            // 예금작업
            if(order == 2) {

                //화면 출력 및 입력
                View.printDepositOption();
                deposit = Input.inputDepositOption();

                // 입금
                if (deposit == 1) {
                    //화면 출력 및 입력
                    View.printDeposit();
                    info = Input.inputDeposit();
                    //계좌번호 및 금액 저장
                    accountFrom = info.nextToken();
                    money = Long.parseLong(info.nextToken());
                    //예금 작업 시작
                    bankService.deposit(bank.findByAccount(accountFrom), money);
                    //작업 후 출력
                    View.printAfterDeposit(bank.findByAccount(accountFrom).getName(), bank.findByAccount(accountFrom).getAsset());
                }

                // 출금
                if (deposit == 2) {
                    //화면 출력 및 입력
                    View.printWithdraw();
                    info = Input.inputWithdraw();
                    //계좌번호 및 금액 저장
                    accountFrom = info.nextToken();
                    money = Long.parseLong(info.nextToken());
                    //출금 작업 시작
                    try {
                        bankService.withdraw(bank.findByAccount(accountFrom), money);
                    }
                    catch (IllegalArgumentException e){
                        View.printNotEnoughMoney();
                        continue;
                    }
                    //작업 후 출력
                    View.printAfterWithdraw(bank.findByAccount(accountFrom).getName(), bank.findByAccount(accountFrom).getAsset());
                }

                // 계좌이체
                if (deposit == 3) {
                    //화면 출력 및 입력
                    View.printAccountTransfer();
                    info = Input.inputAccountTransfer();
                    //계좌번호 및 금액 저장
                    accountFrom = info.nextToken();
                    accountTo = info.nextToken();
                    money = Long.parseLong(info.nextToken());
                    //계좌이체 작업 시작
                    try {
                        bankService.accountTransfer(bank.findByAccount(accountFrom), bank.findByAccount(accountTo), money);
                    }
                    catch (IllegalArgumentException e){
                        View.printNotEnoughMoney();
                        continue;
                    }
                    //작업 후 출력
                    View.printAfterAccountTransfer(bank.findByAccount(accountFrom).getName(), bank.findByAccount(accountFrom).getAsset());
                }
            }

            // 종료
            if(order == 3){
                break;
            }
        }
    }
}
