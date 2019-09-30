package com.huifer.jenkinsspringboot.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Date: 2019-09-30
 */
@Data
public class ProjectRest {
    private List<ProjectData> data;

    @Data
    private static class ProjectData {
        private Date created_at;
        private String html_escaped_name;
        private String id;
        private String name;
        private String repository;
        private String url;
    }
}
