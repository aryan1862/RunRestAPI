package com.example.runner.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    Run findById(@PathVariable Integer id)
    {
        Optional<Run>run= runRepository.findById(id);
        if(run.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Run run)
    {
        runRepository.create(run);
    }



}
