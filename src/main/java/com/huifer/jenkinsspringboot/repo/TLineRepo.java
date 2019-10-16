package com.huifer.jenkinsspringboot.repo;

import com.huifer.jenkinsspringboot.entity.xz.TLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Date: 2019-10-15
 */
@Repository
public interface TLineRepo extends JpaRepository<TLine, Integer> {

}
