package com.ilm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LOAN_APPLICATION")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Double income;
    private String homeOwnership;
    private Integer empLength;
    private String loanIntent;
    private String loanGrade;
    private Double loanAmount;
    private Double loanInterestRate;
    private Double loanPercentIncome;
    private Boolean personDefaultInFile;
    private Integer personCreditHistLength;

}