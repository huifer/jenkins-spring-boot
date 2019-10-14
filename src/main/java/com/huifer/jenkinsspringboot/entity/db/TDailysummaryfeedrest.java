package com.huifer.jenkinsspringboot.entity.db;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TDailysummaryfeedrest {
    private Integer fid;

    private LocalDateTime date;

    private BigDecimal productivityPulse;

    private BigDecimal veryproductivePercentage;

    private BigDecimal productivePercentage;

    private BigDecimal neutralPercentage;

    private BigDecimal distractingPercentage;

    private BigDecimal verydistractingPercentage;

    private BigDecimal allproductivePercentage;

    private BigDecimal alldistractingPercentage;

    private BigDecimal uncategorizedPercentage;

    private BigDecimal businessPercentage;

    private BigDecimal communicationandschedulingPercentage;

    private BigDecimal socialnetworkingPercentage;

    private BigDecimal designandcompositionPercentage;

    private BigDecimal entertainmentPercentage;

    private BigDecimal newsPercentage;

    private BigDecimal softwaredevelopmentPercentage;

    private BigDecimal referenceandlearningPercentage;

    private BigDecimal shoppingPercentage;

    private BigDecimal utilitiesPercentage;

    private BigDecimal totalHours;

    private BigDecimal veryproductiveHours;

    private BigDecimal productiveHours;

    private BigDecimal neutralHours;

    private BigDecimal distractingHours;

    private BigDecimal verydistractingHours;

    private BigDecimal allproductiveHours;

    private BigDecimal alldistractingHours;

    private BigDecimal uncategorizedHours;

    private BigDecimal businessHours;

    private BigDecimal communicationandschedulingHours;

    private BigDecimal socialnetworkingHours;

    private BigDecimal designandcompositionHours;

    private BigDecimal entertainmentHours;

    private BigDecimal newsHours;

    private BigDecimal softwaredevelopmentHours;

    private BigDecimal referenceandlearningHours;

    private BigDecimal shoppingHours;

    private BigDecimal utilitiesHours;

    private String totaldurationFormatted;

    private String veryproductivedurationFormatted;

    private String productivedurationFormatted;

    private String neutraldurationFormatted;

    private String distractingdurationFormatted;

    private String verydistractingdurationFormatted;

    private String allproductivedurationFormatted;

    private String alldistractingdurationFormatted;

    private String uncategorizeddurationFormatted;

    private String businessdurationFormatted;

    private String communicationandschedulingdurationFormatted;

    private String socialnetworkingdurationFormatted;

    private String designandcompositiondurationFormatted;

    private String entertainmentdurationFormatted;

    private String newsdurationFormatted;

    private String softwaredevelopmentdurationFormatted;

    private String referenceandlearningdurationFormatted;

    private String shoppingdurationFormatted;

    private String utilitiesdurationFormatted;

    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;
}