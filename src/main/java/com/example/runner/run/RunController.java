package com.example.runner.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunController {

    private final RunRepository runRepository;
    //autowired not required since only single class is present
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping(value = "/api/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping(value="/")
    public String home()
    {
        return "HOMEPAGE";
    }
}
