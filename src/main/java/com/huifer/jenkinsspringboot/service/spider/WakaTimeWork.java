package com.huifer.jenkinsspringboot.service.spider;

import com.huifer.jenkinsspringboot.entity.UserApiPO;
import com.huifer.jenkinsspringboot.entity.WakaUserinfo;
import com.huifer.jenkinsspringboot.mapper.UserApiPOMapper;
import com.huifer.jenkinsspringboot.mapper.WakaUserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * waka time 定时任务
 *
 * @author huifer
 * @date 2019-09-29
 */
@Service
public class WakaTimeWork {

    @Autowired
    private UserApiPOMapper userApiPOMapper;
    @Autowired
    private WakaSpider wakaSpider;
    @Autowired
    private WakaUserinfoMapper wakaUserinfoMapper;

    /**
     * 跟新用户信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateWakaTimeUserInfo() {
        List<UserApiPO> userApiList = userApiPOMapper.findAll();
        for (UserApiPO userApiPO : userApiList) {
            WakaUserinfo wakaUserinfo = wakaSpider.userInfo(userApiPO.getApiKey());
            wakaUserinfo.setUpdateTime(new Date());
            WakaUserinfo dbInfo = wakaUserinfoMapper.selectByPrimaryKey(wakaUserinfo.getApiKey());
            if (dbInfo != null) {
                wakaUserinfoMapper.updateByPrimaryKey(wakaUserinfo);
            } else {
                wakaUserinfoMapper.insert(wakaUserinfo);
            }
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void updateWakaHeart() {
        List<UserApiPO> userApiList = userApiPOMapper.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (UserApiPO userInfo : userApiList) {
            wakaSpider.heart(sdf.format(new Date()), userInfo.getApiKey(),userInfo.getId());
        }
    }


}
