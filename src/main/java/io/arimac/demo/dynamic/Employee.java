package io.arimac.demo.dynamic;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {
    private float height;
    private float weight;
    private String name;
    private int age;
}
