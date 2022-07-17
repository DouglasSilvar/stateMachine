package com.example.demo.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotFindException extends RuntimeException{

    public NotFindException(String msg){
        super(msg);
    }
}
