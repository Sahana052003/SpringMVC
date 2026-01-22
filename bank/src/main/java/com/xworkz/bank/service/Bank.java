package com.xworkz.bank.service;

public interface Bank {
    void accountOpen();
    void accountClose();
    void verifyPin();
    void accountStatus();
    void deposit();
    void withdraw();
    void transaction();
    void balanceAlert();
    void deactiveAccount();
    void monthlyStatement();
}
