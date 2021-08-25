package com.sungwook.exception.exceptionhandling;

import com.sungwook.exception.exceptionhandling.dto.Example2FindStudentResponseDto;
import com.sungwook.exception.exceptionhandling.exceptions.FailedFindbookException;
import com.sungwook.exception.statuscode.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Example2Service {
    private ArrayList<StudentEntity> students = new ArrayList<StudentEntity>() {{
        add(new StudentEntity("a", 12));
        add(new StudentEntity("b", 13));
        add(new StudentEntity("c", 14));
    }};

    public Example2FindStudentResponseDto find_student(String name){
        StudentEntity failed_to_find_book = students.stream()
                .filter(studentEntity -> studentEntity.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new FailedFindbookException("failed to find book"));

        return new Example2FindStudentResponseDto(failed_to_find_book.getName());
    }
}
