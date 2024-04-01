package com.example.runner.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/runs")
public class RunController {

    private final RunRepository runRepository;
    //autowired not required since only single class is present
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping(value="")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping(value="/home")
    public String home()
    {
        return "HOMEPAGE";
    }

    @GetMapping(value="/{id}")
    public String x()
    {
        return "hello";
    }
    @GetMapping(value="/1")
    Run findById()
    {
        return runRepository.findById(1);
    }

}
