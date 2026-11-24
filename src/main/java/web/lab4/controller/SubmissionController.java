package web.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.lab4.model.Point;
import web.lab4.service.PointService;
import web.lab4.service.StatisticsService;

@Controller
public class SubmissionController {
    private final StatisticsService statisticsService;
    private final PointService pointService;

    public SubmissionController(StatisticsService statisticsService, PointService pointService) {
        this.statisticsService = statisticsService;
        this.pointService = pointService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("results", statisticsService.getList());
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@RequestBody Point point, Model model){
        pointService.process(point);
        model.addAttribute("results", statisticsService.getList());
        return "index";
    }

}
