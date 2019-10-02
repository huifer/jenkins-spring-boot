package com.huifer.jenkinsspringboot.service.query;
import com.huifer.jenkinsspringboot.entity.db.ProjectPO;
import com.huifer.jenkinsspringboot.entity.db.SummaryProjectPO;
import com.huifer.jenkinsspringboot.entity.result.ProjectInfo;
import com.huifer.jenkinsspringboot.entity.result.ProjectWithUser;
import com.huifer.jenkinsspringboot.entity.result.UserProject;
import com.huifer.jenkinsspringboot.mapper.*;
import com.huifer.jenkinsspringboot.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    @Autowired
    private SummaryProjectPOMapper summaryProjectPOMapper;

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

        List<SummaryProjectPO> byApiKeyAndName = summaryProjectPOMapper.findByApiKeyAndName();

        Map<String, List<SummaryProjectPO>> collect = byApiKeyAndName.stream().collect(Collectors.groupingBy(SummaryProjectPO::getDay));

        collect.forEach(
                (k, v) -> {
                    List<ProjectInfo> projectInfos = new ArrayList<>();
                    ProjectWithUser projectWithUser = new ProjectWithUser();
                    for (SummaryProjectPO summaryProjectPO : v) {
                        projectWithUser.setDay(k);
                        projectWithUser.setProjectNanme(summaryProjectPO.getName());

                        ProjectInfo projectInfo = new ProjectInfo();
                        projectInfo.setTotalSeconds(summaryProjectPO.getTotalSeconds());
                        projectInfo.setUserName(userApiMapper.findByApiKey(summaryProjectPO.getApiKey()));
                        projectInfo.setDay(summaryProjectPO.getDay());
                        projectInfo.setName(summaryProjectPO.getName());
                        projectInfo.setHours(summaryProjectPO.getHours());
                        projectInfo.setMinutes(summaryProjectPO.getMinutes());
                        projectInfo.setText(DateUtils.timeText(summaryProjectPO.getHours().intValue(),
                                summaryProjectPO.getMinutes().intValue()));

                        projectInfos.add(projectInfo);
                    }
                    projectWithUser.setData(projectInfos);
                    res.add(projectWithUser);
                }
        );


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
