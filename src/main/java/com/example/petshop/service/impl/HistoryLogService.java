package com.example.petshop.service.impl;

import com.example.petshop.model.HistoryLog;

import com.example.petshop.repository.HistoryLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryLogService {
    private final HistoryLogRepository historyRepository;
    private final Logger logger = LoggerFactory.getLogger(HistoryLogService.class);
    public HistoryLogService(HistoryLogRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
    public List<HistoryLog> getHistory() {
        return historyRepository.findAll();
    }
    public void saveHistory(int successfulBuyers, int unSuccessfulBuyers) {
        HistoryLog historyLog = new HistoryLog();
        historyLog.setSuccessfulBuyers(successfulBuyers);
        historyLog.setUnsuccessfulBuyers(unSuccessfulBuyers);
        historyLog.setDateOfExecution(LocalDateTime.now());
        historyRepository.save(historyLog);
        logger.info("History Log : Successful buyers: {} Unsuccessful buyers : {} Date {}", successfulBuyers, unSuccessfulBuyers, LocalDateTime.now());
    }
}
