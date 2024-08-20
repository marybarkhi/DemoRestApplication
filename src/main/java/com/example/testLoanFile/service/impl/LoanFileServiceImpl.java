package com.example.testLoanFile.service.impl;

import com.example.testLoanFile.dto.LoanFileDTO;
import com.example.testLoanFile.exception.CentralBankCodeException;
import com.example.testLoanFile.exception.LoanFileException;
import com.example.testLoanFile.mapper.ILoanFileMapper;
import com.example.testLoanFile.model.LoanFile;
import com.example.testLoanFile.respository.ILoanFileRepository;
import com.example.testLoanFile.service.ILoanFileService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanFileServiceImpl implements ILoanFileService {

  private final ILoanFileRepository iLoanFileRepository;

  private final ILoanFileMapper iLoanFileMapper;

  public LoanFileServiceImpl(ILoanFileRepository iLoanFileRepository,
      ILoanFileMapper iLoanFileMapper) {
    this.iLoanFileRepository = iLoanFileRepository;
    this.iLoanFileMapper = iLoanFileMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<LoanFileDTO> getAllLoanFiles() {
    List<LoanFile> loanFiles = iLoanFileRepository.findAll();
    return iLoanFileMapper.toDtoList(loanFiles);
  }

  @Override
  @Transactional(readOnly = true)
  public LoanFileDTO getLoanFileById(Long id) {
    return iLoanFileMapper.toDto(iLoanFileRepository.findById(id)
        .orElseThrow(() -> new LoanFileException("Loan file not found with id: " + id)));
  }

  @Override
  @Transactional
  public LoanFileDTO createLoanFile(LoanFileDTO loanFileDto) {
    validateCentralBankCode(loanFileDto.getCentralBankCode());
    LoanFile loanFile = iLoanFileMapper.toEntity(loanFileDto);
    return iLoanFileMapper.toDto(iLoanFileRepository.save(loanFile));
  }


  @Override
  @Transactional
  public LoanFileDTO updateLoanFile(Long id, LoanFileDTO loanFileDto) {
    return iLoanFileRepository.findById(id)
        .map(currentLoanFile -> {
          if (!currentLoanFile.getCentralBankCode().equals(loanFileDto.getCentralBankCode())) {
            validateCentralBankCode(loanFileDto.getCentralBankCode());
          }
          updateLoanFileFields(currentLoanFile, loanFileDto);
          LoanFile updatedLoanFile = iLoanFileRepository.save(currentLoanFile);
          return iLoanFileMapper.toDto(updatedLoanFile);
        })
        .orElseThrow(() -> new LoanFileException("LoanFile not found" + id));
  }

  @Override
  @Transactional
  public void deleteLoanFile(Long id) {
    if (!iLoanFileRepository.existsById(id)) {
      throw new LoanFileException("LoanFile not found" + id);
    }
    iLoanFileRepository.deleteById(id);
  }

  private void validateCentralBankCode(Long centralBankCode) {
    Optional<LoanFile> existingLoanFile = iLoanFileRepository.findByCentralBankCode(
        centralBankCode);
    if (existingLoanFile.isPresent()) {
      throw new CentralBankCodeException("central bank code duplicated" + centralBankCode);
    }
    if (centralBankCode.compareTo(10L) < 0) {
      throw new CentralBankCodeException("centralBankCode should be greater than 10");
    }
  }

  private void updateLoanFileFields(LoanFile currentLoanFile, LoanFileDTO loanFileDto) {
    currentLoanFile.setLoanFileNumber(loanFileDto.getLoanFileNumber());
    currentLoanFile.setLoanType(loanFileDto.getLoanType());
    currentLoanFile.setCentralBankCode(loanFileDto.getCentralBankCode());
    currentLoanFile.setDepositNumber(loanFileDto.getDepositNumber());
    currentLoanFile.setCustomerNumber(loanFileDto.getCustomerNumber());
  }

}
