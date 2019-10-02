package com.huifer.jenkinsspringboot.service.query;

import com.huifer.jenkinsspringboot.entity.db.ProjectPO;
import com.huifer.jenkinsspringboot.entity.result.ProjectWithUser;
import com.huifer.jenkinsspringboot.entity.result.UserProject;
import com.huifer.jenkinsspringboot.mapper.HistorySevenPOMapper;
import com.huifer.jenkinsspringboot.mapper.ProjectPOMapper;
import com.huifer.jenkinsspringboot.mapper.UserApiPOMapper;
import com.huifer.jenkinsspringboot.mapper.WakaUserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * waka time 查询逻辑
 *
 * @author huifer
 * @date 2019-10-01
 */
@Service
public class WakaTimeQuery {

    @Autowired
    private ProjectPOMapper projectMapper;
    @Autowired
    private HistorySevenPOMapper historySevenMapper;

    @Autowired
    private UserApiPOMapper userApiMapper;

    @Autowired
    private WakaUserinfoMapper userinfoMapper;

    /**
     * 个人项目时间统计
     */
    public List<UserProject> statisticsUser() {
        List<UserProject> res = new ArrayList<>();



        return res;
    }


    /**
     * 按项目统计人员开发时间
     *
     * @return
     */
    public List<ProjectWithUser> statisticsProjectByUser() {
        List<ProjectWithUser> res = new ArrayList<>();

        return res;
    }




    /**
     * 查询所有项目
     *
     * @return
     */
    private List<ProjectPO> findAllProject() {
        return projectMapper.findAll();
    }



}
