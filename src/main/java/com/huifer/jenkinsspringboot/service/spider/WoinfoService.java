package com.huifer.jenkinsspringboot.service.spider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huifer.jenkinsspringboot.entity.xz.TWoinfo;
import com.huifer.jenkinsspringboot.mapper.TWoinfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2019-10-15
 */
@Service
public class WoinfoService extends ServiceImpl<TWoinfoMapper, TWoinfo> {
    public void inserts(List<TWoinfo> t) {
        saveBatch(t);
    }
}
