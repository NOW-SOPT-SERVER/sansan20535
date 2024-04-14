package org.sopt;

import org.sopt.controller.BankController;
import org.sopt.input.Input;
import org.sopt.repository.BankRepository;
import org.sopt.repository.BankRepositoryImpl;
import org.sopt.service.BankService;
import org.sopt.service.BankServiceImpl;
import org.sopt.view.View;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        BankController bankController = new BankController(new BankRepositoryImpl(), new BankServiceImpl());
        bankController.run();
    }
}
