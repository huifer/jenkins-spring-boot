package com.huifer.jenkinsspringboot.entity.result;

import com.huifer.jenkinsspringboot.entity.db.WakaUserinfoPO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 描述:
 * 个人项目时间
 *
 * @author huifer
 * @date 2019-10-01
 */
@Data
@NoArgsConstructor
public class UserProject {
    /**
     * 用户id
     */
    private String id;
    /**
     * name
     */
    private String name;
    /**
     * 用户信息
     */
    private WakaUserinfoPO userInfo;
    /**
     * 数据信息
     */
    private List<ProjectInfo> data;

}
