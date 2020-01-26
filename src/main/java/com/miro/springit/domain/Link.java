package com.miro.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;

    // comments
    private List<Comment> comments = new ArrayList<>();

}
