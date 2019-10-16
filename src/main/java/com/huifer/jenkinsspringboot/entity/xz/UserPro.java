package com.huifer.jenkinsspringboot.entity.xz;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Date: 2019-10-15
 */
@Data
@NoArgsConstructor
public class UserPro implements Serializable {
    private String name;
    private String url;
    private Integer cityId;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"url\":\"")
                .append(url).append('\"');
        sb.append(",\"cityId\":")
                .append(cityId);
        sb.append('}');
        return sb.toString();
    }
}
