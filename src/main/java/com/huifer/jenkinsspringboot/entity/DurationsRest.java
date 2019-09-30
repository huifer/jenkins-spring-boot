package com.huifer.jenkinsspringboot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2019-09-30
 */
@Data
public class DurationsRest {
    private String branches;
    private List<DurationsRestData> data;
    private Date end;
    private Date start;
    private String timezone;

    @lombok.Data
    private static class DurationsRestData {
        private Date created_at;
        private String cursorpos;
        private BigDecimal duration;
        private String id;
        private String lineno;
        private String machine_name_id;
        private String project;
        private BigDecimal time;
        private String user_id;
    }
}
