package web.lab4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import web.lab4.service.StatisticsService;

import java.time.format.DateTimeFormatter;

@Controller
public class StatisticsController {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public String index(Model model){
        model.addAttribute("results", statisticsService.getList());
        model.addAttribute("amount", statisticsService.getAmount());
        model.addAttribute("hits", statisticsService.getHits());
        model.addAttribute("hit_percent", statisticsService.getHitPercent() * 100);
        model.addAttribute("last_clear", statisticsService.getLastClear().format(formatter));
        return "result";
    }

    @DeleteMapping("/statistics")
    public ResponseEntity<Void> delete(){
        statisticsService.clear();
        return ResponseEntity.noContent().build();
    }
}
