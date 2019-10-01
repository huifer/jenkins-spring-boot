package com.huifer.jenkinsspringboot.service.query;

import com.huifer.jenkinsspringboot.entity.db.HistorySevenPO;
import com.huifer.jenkinsspringboot.entity.db.ProjectPO;
import com.huifer.jenkinsspringboot.entity.db.UserApiPO;
import com.huifer.jenkinsspringboot.entity.result.ProjectInfo;
import com.huifer.jenkinsspringboot.entity.result.ProjectWithUser;
import com.huifer.jenkinsspringboot.entity.result.UserProject;
import com.huifer.jenkinsspringboot.mapper.HistorySevenPOMapper;
import com.huifer.jenkinsspringboot.mapper.ProjectPOMapper;
import com.huifer.jenkinsspringboot.mapper.UserApiPOMapper;
import com.huifer.jenkinsspringboot.mapper.WakaUserinfoMapper;
import com.huifer.jenkinsspringboot.util.DateUtils;
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
        List<UserApiPO> all = userApiMapper.findAll();
        for (UserApiPO user : all) {
            UserProject userProject = new UserProject();
            userProject.setId(String.valueOf(user.getId()));
            userProject.setName(user.getName());
            userProject.setUserInfo(userinfoMapper.selectByPrimaryKey(user.getApiKey()));

            List<ProjectInfo> info = new ArrayList<>();

            for (ProjectPO project : findAllProject()) {
                HistorySevenPO history = findHistory(user.getApiKey(), project.getProjectName());
                ProjectInfo inf = new ProjectInfo();

                inf.setName(project.getProjectName());
                setProjectInfo(history, inf);
                info.add(inf);
            }
            userProject.setData(info);
            res.add(userProject);

        }


        return res;
    }


    /**
     * 按项目统计人员开发时间
     *
     * @return
     */
    public List<ProjectWithUser> statisticsProjectByUser() {
        List<ProjectWithUser> res = new ArrayList<>();
        List<UserApiPO> all = userApiMapper.findAll();

        for (ProjectPO project : findAllProject()) {
            ProjectWithUser projectWithUser = new ProjectWithUser();
            projectWithUser.setProjectNanme(project.getProjectName());

            List<ProjectInfo> userInfos = new ArrayList<>();
            for (UserApiPO user : all) {
                HistorySevenPO history = findHistory(user.getApiKey(), project.getProjectName());
                ProjectInfo uInfo = new ProjectInfo();
                uInfo.setName(user.getName());
                setProjectInfo(history, uInfo);
                userInfos.add(uInfo);
            }
            projectWithUser.setData(userInfos);
            res.add(projectWithUser);
        }
        return res;
    }

    /**
     * 设置数据信息
     *
     * @param history
     * @param uInfo
     */
    private void setProjectInfo(HistorySevenPO history, ProjectInfo uInfo) {
        if (history != null) {
            uInfo.setHours(history.getHours());
            uInfo.setMinutes(history.getMinutes());
            String[] split = history.getDigital().split(":");
            uInfo.setText(DateUtils.timeText(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        } else {
            uInfo.setHours(0);
            uInfo.setMinutes(0);
            uInfo.setText(DateUtils.timeText(0, 0));
        }
    }


    /**
     * 查询所有项目
     *
     * @return
     */
    private List<ProjectPO> findAllProject() {
        return projectMapper.findAll();
    }


    /**
     * 根据api_key 和项目名称查询项目历史
     *
     * @param apiKey
     * @param projectName
     * @return
     */
    private HistorySevenPO findHistory(String apiKey, String projectName) {
        return historySevenMapper.findByApiKeyAndProName(apiKey, projectName);
    }

}
