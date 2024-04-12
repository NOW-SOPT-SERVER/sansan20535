package org.sopt.input;

import org.sopt.entity.Customer;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {

    static Long id = 0L;

    // 요청사항 입력
    public static int inputOrder() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // 고객정보 입력
    public static Customer inputCustomer() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer infoCustomer = new StringTokenizer(scanner.nextLine(), "-");
        return new Customer(id++, infoCustomer.nextToken(), infoCustomer.nextToken(), Long.parseLong(infoCustomer.nextToken()));
    }

    // 예금작업종류 입력
    public static int inputDepositOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // 입금정보 입력
    public static StringTokenizer inputDeposit() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer infoCustomer = new StringTokenizer(scanner.nextLine(), "-");
        return infoCustomer;
    }

    // 출금정보 입력
    public static StringTokenizer inputWithdraw() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer infoCustomer = new StringTokenizer(scanner.nextLine(), "-");
        return infoCustomer;
    }

    // 계좌이체정보 입력
    public static StringTokenizer inputAccountTransfer() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer infoCustomer = new StringTokenizer(scanner.nextLine(), "-");
        return infoCustomer;
    }
}
