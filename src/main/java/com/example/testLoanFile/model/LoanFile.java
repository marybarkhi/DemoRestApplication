package com.example.testLoanFile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_loanfile")
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String loanFileNumber;
    @Column(nullable = false)
    private String loanType;
    @Column(nullable = false , unique = true)
    private Long centralBankCode;
    @Column(nullable = false)
    private String customerNumber;
    @Column(nullable = false)
    private String depositNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanFileNumber() {
        return loanFileNumber;
    }

    public void setLoanFileNumber(String loanFileNumber) {
        this.loanFileNumber = loanFileNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Long getCentralBankCode() {
        return centralBankCode;
    }

    public void setCentralBankCode(Long centralBankCode) {
        this.centralBankCode = centralBankCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }
}
