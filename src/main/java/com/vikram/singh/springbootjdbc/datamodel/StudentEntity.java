package com.vikram.singh.springbootjdbc.datamodel;

import java.time.LocalDateTime;

public record StudentEntity(
        int id,
        String name,
        int standard,
        String section,
        LocalDateTime creationTime,
        LocalDateTime modificationTime) {

}
