package com.huifer.jenkinsspringboot.service.spider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huifer.jenkinsspringboot.entity.xz.TXz;
import com.huifer.jenkinsspringboot.mapper.TXzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Date: 2019-10-15
 */
@Service
public class XzService extends ServiceImpl<TXzMapper, TXz> {
    @Autowired
    private TXzMapper tXzMapper;
    @Transactional(rollbackFor = Exception.class)
    public void inserts(List<TXz> tXzs) {
        saveBatch(tXzs);
    }

    public TXz findByNameAndUrl(String name, String url) {

        return tXzMapper.findByNameAndUrl(name, url);
    }


}
