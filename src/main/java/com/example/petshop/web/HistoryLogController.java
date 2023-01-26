package com.example.petshop.web;


import com.example.petshop.model.HistoryLog;
import com.example.petshop.service.impl.HistoryLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryLogController {

    private final HistoryLogService historyService;

    public HistoryLogController(HistoryLogService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<HistoryLog> getHistory() {
        return historyService.getHistory();
    }
}
