package com.example.DigitalLibrary.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DigitalLibrary.Entites.IssueRecord;
import com.example.DigitalLibrary.Entites.User;

public interface IssueRecordRepository extends JpaRepository<IssueRecord, Long> {

    List<IssueRecord> findByUser(User user);

    List<IssueRecord> findByReturnedFalse();
}
