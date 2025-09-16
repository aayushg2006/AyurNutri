// FileName: src/main/java/com/ayurveda/diet/controller/DashboardController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.DashboardStatsDTO;
import com.ayurveda.diet.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public DashboardStatsDTO getStats() {
        return dashboardService.getDashboardStats();
    }
}