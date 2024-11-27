package com.crm.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {

    private Long id;
    private String name;
    private String description;
}
