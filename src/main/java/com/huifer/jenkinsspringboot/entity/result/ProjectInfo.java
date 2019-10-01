package com.huifer.jenkinsspringboot.entity.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 工程开发信息
 *
 * @author huifer
 * @date 2019-10-01
 */
@Data
@NoArgsConstructor
public class ProjectInfo {

    private String name;
    /**
     * 开发小时数
     */
    private Integer hours;
    /**
     * 开发分钟数
     */
    private Integer minutes;
    /**
     * hours 小时 + minutes 分钟
     */
    private String text;

}
