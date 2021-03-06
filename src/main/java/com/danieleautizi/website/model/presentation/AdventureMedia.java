package com.danieleautizi.website.model.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdventureMedia {

    private String id;

    private String mediaType;
    private String mediaPath;
    private String mediaUrl;
    private String title;
    private String alt;
    private String cssClass;

    private boolean active;
    private int prg;

    private ZonedDateTime datetime;
    private ZonedDateTime lastUpdate;
}
