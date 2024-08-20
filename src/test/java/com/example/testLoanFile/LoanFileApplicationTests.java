package com.example.testLoanFile;

import com.example.testLoanFile.dto.LoanFileDTO;
import com.example.testLoanFile.exception.CentralBankCodeException;

import com.example.testLoanFile.exception.LoanFileException;
import com.example.testLoanFile.mapper.ILoanFileMapper;
import com.example.testLoanFile.model.LoanFile;
import com.example.testLoanFile.respository.ILoanFileRepository;
import com.example.testLoanFile.service.impl.LoanFileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class LoanFileApplicationTest {
    @Mock
    private ILoanFileRepository iLoanFileRepository;

    @Mock
    private ILoanFileMapper iLoanFileMapper;

    @InjectMocks
    private LoanFileServiceImpl loanFileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void deleteLoanFile_NonExistingId_ShouldThrowException() {
        Long id = 25L;
        when(iLoanFileRepository.existsById(id)).thenReturn(false);

        assertThrows(LoanFileException.class, () -> loanFileService.deleteLoanFile(id));
    }

    @Test
    void createLoanFile_InvalidCentralBankCode_ShouldThrowException() {
        LoanFileDTO inputDto = new LoanFileDTO();
        inputDto.setCentralBankCode(9L);

        assertThrows(CentralBankCodeException.class, () -> loanFileService.createLoanFile(inputDto));
    }

}
