package com.example.runner.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RunRepository {
    private List<Run> runs=new ArrayList<>();



    List <Run> findAll()
    {
        return runs;
    }

    Run findById(int id)
    {
        return runs.stream().filter(run -> run.id()==id).findFirst().get();
    }

    @PostConstruct
    private void init()
    {
        runs.add(new Run(1,"Park", 0,0,10, Location.INDOOR));
        runs.add(new Run(2,"Gym", 0,0,10, Location.INDOOR));
    }
}
