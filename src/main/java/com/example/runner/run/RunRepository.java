package com.example.runner.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs=new ArrayList<>();



    List <Run> findAll()
    {
        return runs;
    }

    Optional<Run> findById(int id)
    {
        return runs.stream().filter(run -> run.id()==id).findFirst();
    }

    void create(Run run)
    {
        runs.add(run);
    }

    @PostConstruct
    private void init()
    {
        runs.add(new Run(1,"Park", 0,0,10, Location.INDOOR));
        runs.add(new Run(2,"Gym", 0,0,10, Location.INDOOR));
    }

    void update(Run run,int id)
    {
        Optional<Run>existingRun= findById(id);
        if(existingRun.isPresent())
            runs.set(runs.indexOf(existingRun.get()),run);
    }

    void delete(int id)
    {
        runs.removeIf(run -> run.id().equals(id));
    }
}
