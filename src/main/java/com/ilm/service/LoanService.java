package com.ilm.service;

import com.ilm.model.LoanApplication;
import com.ilm.model.LoanApplicationDto;
import com.ilm.repository.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

   /* @Autowired
    private KafkaTemplate<String, LoanApplication> kafkaTemplate; */

    private final String kafkaTopic = "loanApplications";

    public LoanApplicationDto createLoanApplication(LoanApplicationDto loanApplicationdto) {
        LoanApplication application = convertToEntity(loanApplicationdto);
        LoanApplication savedLoan = loanRepository.save(application);
      //kafkaTemplate.send(kafkaTopic, savedLoan);
        log.info("Loan application submitted");
        return convertToDto(savedLoan);
    }

    private LoanApplicationDto convertToDto(LoanApplication entity) {
        LoanApplicationDto dto = new LoanApplicationDto();
        dto.setId(entity.getId());
        dto.setAge(entity.getAge());
        dto.setName(dto.getName());
        dto.setIncome(entity.getIncome());
        dto.setHomeOwnership(entity.getHomeOwnership());
        dto.setEmpLength(entity.getEmpLength());
        dto.setLoanIntent(entity.getLoanIntent());
        dto.setLoanGrade(entity.getLoanGrade());
        dto.setLoanAmount(entity.getLoanAmount());
        dto.setLoanInterestRate(entity.getLoanInterestRate());
        dto.setLoanPercentIncome(entity.getLoanPercentIncome());
        dto.setPersonDefaultInFile(entity.getPersonDefaultInFile());
        dto.setPersonCreditHistLength(entity.getPersonCreditHistLength());
        return dto;
    }

    private LoanApplication convertToEntity(LoanApplicationDto dto) {
        LoanApplication entity = new LoanApplication();
        entity.setAge(dto.getAge());
        entity.setName(dto.getName());
        entity.setIncome(dto.getIncome());
        entity.setHomeOwnership(dto.getHomeOwnership());
        entity.setEmpLength(dto.getEmpLength());
        entity.setLoanIntent(dto.getLoanIntent());
        entity.setLoanGrade(dto.getLoanGrade());
        entity.setLoanAmount(dto.getLoanAmount());
        entity.setLoanInterestRate(dto.getLoanInterestRate());
        entity.setLoanPercentIncome(dto.getLoanPercentIncome());
        entity.setPersonDefaultInFile(dto.getPersonDefaultInFile());
        entity.setPersonCreditHistLength(dto.getPersonCreditHistLength());
        return entity;
    }

    public List<LoanApplication> getAllLoans() {
        return loanRepository.findAll();
    }

    public LoanApplicationDto getLoanDetailsForApplicant(Long loanId){
        LoanApplication application = loanRepository.getById(loanId);
        if(Objects.isNull(application)){
            log.error("No loan record found");
            throw new RuntimeException("Loan not found");
        }
        else{
            return convertToDto(application);
        }
    }
}
