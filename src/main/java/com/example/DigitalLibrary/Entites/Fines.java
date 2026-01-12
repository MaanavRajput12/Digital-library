package com.example.DigitalLibrary.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fines")
public class Fines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fineId;

    @OneToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private IssueRecord issueRecord;

    private double amount;

    private boolean paid;

    public Fines() {}

    public Long getFineId() {
        return fineId;
    }

    public IssueRecord getIssueRecord() {
        return issueRecord;
    }

    public void setIssueRecord(IssueRecord issueRecord) {
        this.issueRecord = issueRecord;
    }

    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }
 
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
