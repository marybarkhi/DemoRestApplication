package com.example.testLoanFile.exception;

import java.io.Serial;

public class LoanFileException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -2;

  public LoanFileException(String message) {
    super(message);
  }
}
