package com.example.runner.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(Integer id, @NotEmpty String title, int startedOn, int completedOn, @Positive Integer miles, Location location)
{

}
