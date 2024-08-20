package com.example.testLoanFile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanFileDTO {
  private String loanFileNumber;
  private String loanType;
  private Long centralBankCode;
  private String customerNumber;
  private String depositNumber;

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
