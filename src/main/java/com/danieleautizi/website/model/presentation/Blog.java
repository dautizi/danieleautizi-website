package com.danieleautizi.website.model.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private String id;

    private String title;
    private String category;
    private String section;
    private String tag;

    private String keywords;

    private String cssClass;
    private String image;
    private String icon;
    private String altImage;
    private String articleUrl;
    private String staticUrl;
    private String description;

    private String blogType;
    private String viewType;
    private String mediaCssClass;

    private boolean active;
    private int prg;

    private ZonedDateTime datetime;
    private Date formattedDatetime;
    private String datetimeString;

    private ZonedDateTime lastUpdate;
    private Date formattedLastUpdate;
    private String lastUpdateString;

    private Blog prev;
    private Blog next;
}
