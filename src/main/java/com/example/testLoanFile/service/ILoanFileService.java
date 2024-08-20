package com.example.testLoanFile.service;

import com.example.testLoanFile.dto.LoanFileDTO;
import java.util.List;
import java.util.Optional;

public interface ILoanFileService {

  public List<LoanFileDTO> getAllLoanFiles();

  public LoanFileDTO getLoanFileById(Long id);

  public LoanFileDTO createLoanFile(LoanFileDTO LoanFileDto);

  public LoanFileDTO updateLoanFile(Long id, LoanFileDTO loanFileDTO);

  public void deleteLoanFile(Long id);

}
