package com.xworkz.bank.service;

import org.springframework.stereotype.Service;

@Service
public class BankService implements Bank{
    @Override
    public void accountOpen() {
        System.out.println("Account is opened");
    }

    @Override
    public void accountClose() {
        System.out.println("Account is Close");
    }

    @Override
    public void verifyPin() {
        System.out.println("Once again verify the pin to login");
    }

    @Override
    public void accountStatus() {
        System.out.println("Check account status");
    }

    @Override
    public void deposit() {
        System.out.println("Amount is deposited");
    }

    @Override
    public void withdraw() {
        System.out.println("Account is withdraw");
    }

    @Override
    public void transaction() {
        System.out.println("Some amount is transaction");
    }

    @Override
    public void balanceAlert() {
        System.out.println("Gives a balance alert");
    }

    @Override
    public void deactiveAccount() {
        System.out.println("Account is deactived ");
    }

    @Override
    public void monthlyStatement() {
        System.out.println("sends a monthly statement to user");
    }

}
