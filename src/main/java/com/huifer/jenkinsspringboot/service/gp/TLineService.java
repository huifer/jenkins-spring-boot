package com.huifer.jenkinsspringboot.service.gp;

import com.huifer.jenkinsspringboot.entity.xz.TLine;
import com.huifer.jenkinsspringboot.repo.TLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2019-10-15
 */
@Service
public class TLineService {
    @Autowired
    private TLineRepo tLineRepo;
    @Transactional(rollbackFor = Exception.class)
    public void  ins(TLine tLine){
        tLineRepo.save(tLine);
    }
}
