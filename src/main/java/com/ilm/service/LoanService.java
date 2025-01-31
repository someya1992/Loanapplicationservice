package com.ilm.service;

import com.ilm.model.LoanApplication;
import com.ilm.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

   /* @Autowired
    private KafkaTemplate<String, LoanApplication> kafkaTemplate; */

    private final String kafkaTopic = "loanApplications";

    public LoanApplication createLoanApplication(LoanApplication loanApplication) {
        LoanApplication savedLoan = loanRepository.save(loanApplication);
      //   kafkaTemplate.send(kafkaTopic, savedLoan);
        return savedLoan;
    }

    public List<LoanApplication> getAllLoans() {
        return loanRepository.findAll();
    }
}
