package com.huifer.jenkinsspringboot.entity.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 描述:
 * 按项目人员统计
 *
 * @author huifer
 * @date 2019-10-01
 */
@Data
@NoArgsConstructor
public class ProjectWithUser {
    /**
     * 项目名词
     */
    private String projectNanme;

    /**
     * 数据列表
     */
    private List<ProjectInfo> data;

}
