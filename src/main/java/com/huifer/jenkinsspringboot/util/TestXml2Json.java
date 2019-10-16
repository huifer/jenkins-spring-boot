package com.huifer.jenkinsspringboot.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.entity.xz.Linex;
import org.dom4j.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by chengsheng on 2015/8/19.
 */
public class TestXml2Json {
    private static GeometryFactory geometryFactory = new GeometryFactory();

    public static void main(String[] args) throws Exception {
        String xmlStr = readFile("E:\\w_pro\\jenkins-spring-boot\\src\\main\\resources\\1.gpx");
        Document doc = DocumentHelper.parseText(xmlStr);
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        String replace = json.toJSONString().replace("@", "");

        JSONObject object = JSONObject.parseObject(replace);
        Linex linex = object.toJavaObject(Linex.class);
        List<Linex.TrkBean.TrksegBean.TrkptBean> trkpt = linex.getTrk().getTrkseg().getTrkpt();
        LineString lineString = polyLine(trkpt);
        System.out.println(replace);
    }

    public static String readFile(String path) throws Exception {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(new Long(file.length()).intValue());
        //fc向buffer中读入数据
        fc.read(bb);
        bb.flip();
        String str = new String(bb.array(), StandardCharsets.UTF_8);
        fc.close();
        fis.close();
        return str;

    }

    /**
     * xml转json
     *
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public static JSONObject xml2Json(String xmlStr) throws DocumentException {
        Document doc = DocumentHelper.parseText(xmlStr);
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }

    /**
     * xml转json
     *
     * @param element
     * @param json
     */
    public static void dom4j2Json(Element element, JSONObject json) {
        //如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        if (chdEl.isEmpty() && !isEmpty(element.getText())) {//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }

        for (Element e : chdEl) {//有子元素
            if (!e.elements().isEmpty()) {//子元素也有子元素
                JSONObject chdjson = new JSONObject();
                dom4j2Json(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }


            } else {//子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    public static boolean isEmpty(String str) {

        return str == null || str.trim().isEmpty() || "null".equals(str);
    }

    public static LineString polyLine(List<Linex.TrkBean.TrksegBean.TrkptBean> tks) {
//        Coordinate[] coords  = new Coordinate[] {new Coordinate(2, 2), new Coordinate(2, 2)};
        Coordinate[] coords = new Coordinate[tks.size()];
        for (int i = 0; i < tks.size(); i++) {
            Linex.TrkBean.TrksegBean.TrkptBean tk = tks.get(i);
            coords[i] = new Coordinate(Double.parseDouble(tk.getLon()), Double.parseDouble(tk.getLat()), Double.parseDouble(tk.getEle()));

        }
        LineString line = geometryFactory.createLineString(coords);
        return line;
    }
}