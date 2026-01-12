package com.example.DigitalLibrary.Services;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.Entites.Fines;
import com.example.DigitalLibrary.Entites.IssueRecord;
import com.example.DigitalLibrary.ExceptionHandlers.BadRequestException;
import com.example.DigitalLibrary.ExceptionHandlers.ResourceNotFoundException;
import com.example.DigitalLibrary.Repositories.FinesRepository;
import com.example.DigitalLibrary.Repositories.IssueRecordRepository;

@Service
public class FinesServices {

    private final FinesRepository fineRepository;
    private final IssueRecordRepository issueRecordRepository;

    public FinesServices(FinesRepository fineRepository, IssueRecordRepository issueRecordRepository) {
        this.fineRepository = fineRepository;
        this.issueRecordRepository = issueRecordRepository;
    }

    public Fines calculateFine(Long issueId) {
        if (issueId == null) {
            throw new BadRequestException("Issue ID cannot be null");
        }

        IssueRecord record = issueRecordRepository.findById(issueId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Issue record not found with id: " + issueId));

        if (record.getReturnDate() == null) {
            throw new BadRequestException("Book has not been returned yet");
        }

        long daysLate = ChronoUnit.DAYS.between(
                record.getIssueDate().plusDays(14),
                record.getReturnDate());

        double amount = daysLate > 0 ? daysLate * 10.0 : 0.0;

        Fines fine = new Fines();
        fine.setIssueRecord(record);
        fine.setAmount(amount);

        return fineRepository.save(fine);
    }
}
