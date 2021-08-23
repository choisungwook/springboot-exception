package com.sungwook.exception.statuscode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Example1Controller {

    private ArrayList<StudentEntity> students = new ArrayList<StudentEntity>() {{
        add(new StudentEntity("a", 12));
        add(new StudentEntity("b", 13));
        add(new StudentEntity("c", 14));
    }};

    /***
     * 이름을 기준이름으로 학생을 찾으면 entity반환
     * 없으면 404리턴
     * @param name
     * @return
     */
    @GetMapping("/example1/student/{name}")
    public StudentEntity get_student(@PathVariable String name){

        StudentEntity find_student = students.stream()
                .filter(student -> student.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NotExistStudent(name));

        return find_student;
    }
}
