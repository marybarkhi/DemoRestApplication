package com.example.testLoanFile.mapper;

import com.example.testLoanFile.dto.LoanFileDTO;
import com.example.testLoanFile.model.LoanFile;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ILoanFileMapper {
  LoanFileDTO toDto(LoanFile loanFile);

  List<LoanFileDTO> toDtoList(List<LoanFile> loanFiles);

  LoanFile toEntity(LoanFileDTO loanFileDTO);


}
