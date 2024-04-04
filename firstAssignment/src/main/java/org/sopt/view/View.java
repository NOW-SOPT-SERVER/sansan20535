package org.sopt.view;
public class View {

    // 초기화면 출력
    public static void init(){
        System.out.println("-------------------------------------------------");
        System.out.println("안녕하세요! 원하는 작업을 선택해 주세요!");
        System.out.println("1. 등록");
        System.out.println("2. 예금");
        System.out.println("3. 종료");
        System.out.print(">>> ");
    }

    // 고객등록화면 출력
    public static void printResister(){
        System.out.println("-------------------------------------------------");
        System.out.println("성함과 계좌번호, 저축하실 자산의 금액을 입력해주세요! (Ex: 홍길동-1111-5000)");
        System.out.print(">>> ");
    }

    //예금작업선택화면 출력
    public static void printDepositOption(){
        System.out.println("-------------------------------------------------");
        System.out.println("원하는 작업을 선택해 주세요!");
        System.out.println("1. 입금");
        System.out.println("2. 출금");
        System.out.println("3. 계좌이체");
        System.out.print(">>> ");
    }

    //입금화면 출력
    public static void printDeposit(){
        System.out.println("-------------------------------------------------");
        System.out.println("계좌번호와 저축하실 자산의 금액을 입력해주세요! (Ex: 1111-5000)");
        System.out.print(">>> ");
    }

    //출금화면 출력
    public static void printWithdraw(){
        System.out.println("-------------------------------------------------");
        System.out.println("계좌번호와 출금하실 자산의 금액을 입력해주세요! (Ex: 1111-5000)");
        System.out.print(">>> ");
    }

    //계좌이체화면 출력
    public static void printAccountTransfer(){
        System.out.println("-------------------------------------------------");
        System.out.println("보내시는 분의 계좌와 이체하실 분의 계좌, 계좌이체하실 금액을 입력해주세요! (Ex: 1111-2222-5000)");
        System.out.print(">>> ");
    }

    //입금 후 화면 출력
    public static void printAfterDeposit(String name, Long asset){
        System.out.println("-------------------------------------------------");
        System.out.println(name + "님의 잔액은 " + asset + "원입니다!");
        System.out.print(">>> ");
    }

    //출금 후 화면 출력
    public static void printAfterWithdraw(String name, Long asset){
        System.out.println("-------------------------------------------------");
        System.out.println(name + "님의 잔액은 " + asset + "원입니다!");
        System.out.print(">>> ");
    }

    //계좌이체 후 화면 출력
    public static void printAfterAccountTransfer(String name, Long asset){
        System.out.println("-------------------------------------------------");
        System.out.println(name + "님의 잔액은 " + asset + "원입니다!");
        System.out.print(">>> ");
    }
}
