package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.entity.xz.UserInfo;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

/**
 * @Date: 2019-10-14
 */
@Service
public class XzSpider {
    @Autowired
    private RestTemplate restTemplate;

    public void spider() {
        String url = "http://www.imxingzhe.com/api/v4/user_month_info?user_id=792998&year=2019&month=9";
        ResponseEntity<String> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        UserInfo userInfo = object.toJavaObject(UserInfo.class);
        System.out.println();
    }

    public void line() throws Exception {
        String Cookie = "td_cookie=2441531771; td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1570757134,1571020126,1571020162; rd=X4DR; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571029514";
        String url = "http://www.imxingzhe.com/xing/72076175/gpx/";
        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        headers.add("Accept-Encoding", "gzip, deflate");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Cache-Control", "max-age=0");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1570757134,1571020126,1571020162; rd=X4DR; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571029514");
        headers.add("Host", "www.imxingzhe.com");
        headers.add("Upgrade-Insecure-Requests", "1");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        ResponseEntity<String> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                String.class
        );
        String body = exchange.getBody();

    }

    public <T> T xmlToBean(String xmlString, Class<T> tClass) throws Exception {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xmlString));

    }

    public void getNodes(Element node) {
        System.out.println("--------------------");

        //当前节点的名称、文本内容和属性
        System.out.println("当前节点名称：" + node.getName());//当前节点名称
        System.out.println("当前节点的内容：" + node.getTextTrim());//当前节点名称
        List<Attribute> listAttr = node.attributes();//当前节点的所有属性的list
        for (Attribute attr : listAttr) {//遍历当前节点的所有属性
            String name = attr.getName();//属性名称
            String value = attr.getValue();//属性的值
            System.out.println("属性名称：" + name + "属性值：" + value);
        }

        //递归遍历当前节点所有的子节点
        List<Element> listElement = node.elements();//所有一级子节点的list
        for (Element e : listElement) {//遍历所有一级子节点
            this.getNodes(e);//递归
        }
    }

}
