package com.ilm.controller;

import com.ilm.model.LoanApplication;
import com.ilm.model.LoanApplicationDto;
import com.ilm.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanApplicationDto> createLoan(@RequestBody @Valid LoanApplicationDto loanApplication) {
        return ResponseEntity.ok(loanService.createLoanApplication(loanApplication));
    }

    @GetMapping
    public ResponseEntity<List<LoanApplication>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanApplicationDto> getLoans(@PathVariable Long loanId ) {
        return ResponseEntity.ok(loanService.getLoanDetailsForApplicant(loanId));
    }
}