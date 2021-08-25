package com.sungwook.exception.exceptionhandling;

import com.sungwook.exception.exceptionhandling.dto.Example2FindStudentResponseDto;
import com.sungwook.exception.exceptionhandling.dto.ExceptionCommonResponseDto;
import com.sungwook.exception.exceptionhandling.exceptions.FailedFindbookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example2Controller {

    @Autowired
    private Example2Service student_service;

    /***
     * 이름으로 학생검색
     * 없으면 예외가 발생
     * @return
     */

    @GetMapping("/example2/student/{name}")
    public ResponseEntity<Example2FindStudentResponseDto> example_controller(@PathVariable String name) {
        Example2FindStudentResponseDto responseDto = student_service.find_student(name);

        return new ResponseEntity<Example2FindStudentResponseDto>(responseDto, HttpStatus.OK);
    }


    @ExceptionHandler(FailedFindbookException.class)
    public ResponseEntity<ExceptionCommonResponseDto> FailedFindbookExceptionHandler(Exception ex){
        ExceptionCommonResponseDto responseDto = new ExceptionCommonResponseDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<ExceptionCommonResponseDto>(
                responseDto,
                responseDto.getStatus()
        );
    }

}
