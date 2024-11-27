package com.crm.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDto {

    private Long id;
    private String name;
    private String description;
}
