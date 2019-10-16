package com.huifer.jenkinsspringboot.entity.xz;

import lombok.Data;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "t_line")
public class TLine implements Serializable {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue
    private Integer fid;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "geom")
    private Geometry geom;

    private Date time;
}