package com.example.springcloudkafka.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class PageEvent {
    private String name, user;
    private Date date;
    private long duration;
}
