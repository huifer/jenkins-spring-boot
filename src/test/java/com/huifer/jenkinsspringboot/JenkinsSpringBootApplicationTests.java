package com.huifer.jenkinsspringboot;

import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.entity.xz.Linex;
import com.huifer.jenkinsspringboot.entity.xz.TLine;
import com.huifer.jenkinsspringboot.service.gp.TLineService;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.locationtech.jts.geom.LineString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static com.huifer.jenkinsspringboot.util.TestXml2Json.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsSpringBootApplicationTests {

    @Autowired
    private TLineService tLineService;

    @Test
    public void contextLoads() throws Exception {
        String xmlStr = readFile("E:\\w_pro\\jenkins-spring-boot\\src\\main\\resources\\1.gpx");
        Document doc = DocumentHelper.parseText(xmlStr);
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        String replace = json.toJSONString().replace("@", "");

        JSONObject object = JSONObject.parseObject(replace);
        Linex linex = object.toJavaObject(Linex.class);
        List<Linex.TrkBean.TrksegBean.TrkptBean> trkpt = linex.getTrk().getTrkseg().getTrkpt();
        LineString lineString = polyLine(trkpt);

        TLine tl = new TLine();
        tl.setTime(new Date());
        tl.setTitle("test");
        tl.setGeom(lineString);
        tl.setUserId(123);

        tLineService.ins(tl);
    }

}
