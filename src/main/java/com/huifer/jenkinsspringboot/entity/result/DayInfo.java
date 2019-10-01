package com.huifer.jenkinsspringboot.entity.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 描述:
 * 日期统计
 *
 * @author huifer
 * @date 2019-10-01
 */
@Data
@NoArgsConstructor
public class DayInfo {
    /**
     * 日期 yyyy-MM-dd
     */
    private String date;

    private List data;

    @Data
    @NoArgsConstructor
    static class ProjInfo {
        /**
         * 项目名词
         */
        private String projectName;

        /**
         * 开发时间
         */
        private String text;
    }

}
