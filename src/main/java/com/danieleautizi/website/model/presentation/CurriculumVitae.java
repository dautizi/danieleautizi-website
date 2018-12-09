package com.danieleautizi.website.model.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitae {

    private String id;

    private String title;
    private String path;
    private String filename;
    private String description;

    private String link;

    private boolean active;
    private int prg;
}
