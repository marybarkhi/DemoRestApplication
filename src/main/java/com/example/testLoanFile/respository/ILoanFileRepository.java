package com.example.testLoanFile.respository;

import com.example.testLoanFile.model.LoanFile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanFileRepository extends JpaRepository<LoanFile,Long> {
  Optional<LoanFile> findByCentralBankCode(Long centralBankCode);

}
