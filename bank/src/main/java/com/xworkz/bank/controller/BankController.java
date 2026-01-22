package com.xworkz.bank.controller;

import com.xworkz.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Controller
@RequestMapping("/")
public class BankController {
    public BankController(){
        System.out.println("BankController is Called");
    }
    @Autowired
    BankService bankService;


    @GetMapping("/check")
    public String check(@RequestParam double balance){
        bankService.accountOpen();
        System.out.println("Checking bank balance : " + balance);
        return "index";
    }

    @GetMapping("/bank")
    public String bank(@RequestParam String name){
        bankService.accountClose();
        System.out.println("Called Bank "+ name);
        return "bank";
    }

    @GetMapping("/pinNumber")
    public String pinNumber(@RequestParam int pin){
        bankService.verifyPin();
        System.out.println("Enter a pin Number : " + pin);
        return "amount";
    }
    @GetMapping("/checkAccount")
    public String checkAccount(@RequestParam long account){
        bankService.accountStatus();
        System.out.println("Checking person account : " + account);
        return "detail";
    }
    @GetMapping("/status")
    public String status(@RequestParam String name){
        bankService.deposit();
        System.out.println("Calling Status Method " + name);
        return "person";
    }
    @GetMapping("/amountWithdraw")
    public String amountWithdraw(@RequestParam int amount){
        bankService.withdraw();
        System.out.println("Amount is Withdraw : " + amount);
        return "withdraw";
    }
    @GetMapping("/transactionDetails")
    public String transactionDetails(@RequestParam String name){
        bankService.transaction();
        System.out.println("Calling transactionDetails " + name);
        return "transaction";
    }

    @GetMapping("/montlyStatus")
    public String montlyStatus(@RequestParam String name){
        bankService.monthlyStatement();
        System.out.println("getting monthly status from Bank " + name);
        return "deposit";
    }

    @GetMapping("/account")
    public String account(@RequestParam String name){
        bankService.deactiveAccount();
        System.out.println("Bank Account details " + name);
        return "cash";
    }
    @GetMapping("/statement")
    public String statement(@RequestParam String name){
        bankService.monthlyStatement();
        System.out.println("getting Statement from Bank " + name);
        return "bankform";
    }
}
