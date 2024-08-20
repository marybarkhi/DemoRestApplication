package com.example.testLoanFile.controller;

import com.example.testLoanFile.dto.LoanFileDTO;
import com.example.testLoanFile.service.ILoanFileService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loan-files")
@Validated
public class LoanFileController {
private final ILoanFileService iLoanFileService;

  public LoanFileController(ILoanFileService iLoanFileService) {
    this.iLoanFileService = iLoanFileService;
  }

    @GetMapping
    public ResponseEntity<List<LoanFileDTO>> getAllLoanFiles() {
        List<LoanFileDTO> loanFiles = iLoanFileService.getAllLoanFiles();
        return ResponseEntity.ok(loanFiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanFileDTO> getLoanFileById(@PathVariable @Positive Long id) {
        LoanFileDTO loanFileDto = iLoanFileService.getLoanFileById(id);
        return ResponseEntity.ok(loanFileDto);
    }

    @PostMapping
    public ResponseEntity<LoanFileDTO> createLoanFile(@RequestBody @Valid LoanFileDTO loanFileDto) {
        LoanFileDTO createdLoanFile = iLoanFileService.createLoanFile(loanFileDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoanFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanFileDTO> updateLoanFile(
            @PathVariable @Positive Long id,
            @RequestBody @Valid LoanFileDTO loanFileDTO) {
        LoanFileDTO updatedLoanFile = iLoanFileService.updateLoanFile(id, loanFileDTO);
        return ResponseEntity.ok(updatedLoanFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanFile(@PathVariable @Positive Long id) {
        iLoanFileService.deleteLoanFile(id);
        return ResponseEntity.noContent().build();
    }
}