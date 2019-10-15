package com.huifer.jenkinsspringboot.service.spider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huifer.jenkinsspringboot.entity.xz.TStinfo;
import com.huifer.jenkinsspringboot.mapper.TStinfoMapper;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019-10-15
 */
@Service
public class StinfoService extends ServiceImpl<TStinfoMapper, TStinfo> {
    public void insert(TStinfo t) {
        save(t);
    }
}
