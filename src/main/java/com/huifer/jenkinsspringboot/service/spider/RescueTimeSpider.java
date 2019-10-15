package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONArray;
import com.huifer.jenkinsspringboot.config.RescueTimeApiConfig;
import com.huifer.jenkinsspringboot.entity.db.TDailysummaryfeedrest;
import com.huifer.jenkinsspringboot.entity.rescuetime.DailySummaryFeedRest;
import com.huifer.jenkinsspringboot.mapper.TDailysummaryfeedrestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @Date: 2019-09-30
 */
@Slf4j
@Service
public class RescueTimeSpider {
    @Value("${test_api}")
    public String apikey;
    @Autowired
    TDailysummaryfeedrestMapper tDailysummaryfeedrestMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RescueTimeApiConfig rescueTimeApiConfig;

    /**
     * 每日摘要信息
     *
     * @return {@link DailySummaryFeedRest}
     */
    public List<DailySummaryFeedRest> dailySummaryData() {

        ResponseEntity<String> forEntity = restTemplate.getForEntity(rescueTimeApiConfig.getDaily_summary_url()
                + "?key=" + apikey, String.class);
        String body = forEntity.getBody();
        List<DailySummaryFeedRest> dailySummaryFeedRests = JSONArray.parseArray(body, DailySummaryFeedRest.class);
        log.info("每日摘要信息={}", dailySummaryFeedRests);

        for (DailySummaryFeedRest dailySummaryFeedRest : dailySummaryFeedRests) {
            Date date = dailySummaryFeedRest.getDate();
            int year = date.getYear();
            int month = date.getMonth();
            int day = date.getDay();
            TDailysummaryfeedrest one = tDailysummaryfeedrestMapper.findByYearModDay(year, month, day);
            if (one == null) {
                TDailysummaryfeedrest tDailysummaryfeedrest = new TDailysummaryfeedrest();
                tDailysummaryfeedrest.setYear(year);
                tDailysummaryfeedrest.setMonth(month);
                tDailysummaryfeedrest.setDay(day);

                tDailysummaryfeedrest.setProductivityPulse(dailySummaryFeedRest.getProductivityPulse());
                tDailysummaryfeedrest.setVeryproductivePercentage(dailySummaryFeedRest.getVeryProductivePercentage());
                tDailysummaryfeedrest.setProductivePercentage(dailySummaryFeedRest.getProductivePercentage());
                tDailysummaryfeedrest.setNeutralPercentage(dailySummaryFeedRest.getNeutralPercentage());
                tDailysummaryfeedrest.setDistractingPercentage(dailySummaryFeedRest.getDistractingPercentage());
                tDailysummaryfeedrest.setVerydistractingPercentage(dailySummaryFeedRest.getVeryDistractingPercentage());
                tDailysummaryfeedrest.setAllproductivePercentage(dailySummaryFeedRest.getAllProductivePercentage());
                tDailysummaryfeedrest.setAlldistractingPercentage(dailySummaryFeedRest.getAllDistractingPercentage());
                tDailysummaryfeedrest.setUncategorizedPercentage(dailySummaryFeedRest.getUncategorizedPercentage());
                tDailysummaryfeedrest.setBusinessPercentage(dailySummaryFeedRest.getBusinessPercentage());
                tDailysummaryfeedrest.setCommunicationandschedulingPercentage(dailySummaryFeedRest.getCommunicationAndSchedulingPercentage());
                tDailysummaryfeedrest.setSocialnetworkingPercentage(dailySummaryFeedRest.getSocialNetworkingPercentage());
                tDailysummaryfeedrest.setDesignandcompositionPercentage(dailySummaryFeedRest.getDesignAndCompositionPercentage());
                tDailysummaryfeedrest.setEntertainmentPercentage(dailySummaryFeedRest.getEntertainmentPercentage());
                tDailysummaryfeedrest.setNewsPercentage(dailySummaryFeedRest.getNewsPercentage());
                tDailysummaryfeedrest.setSoftwaredevelopmentPercentage(dailySummaryFeedRest.getSoftwareDevelopmentPercentage());
                tDailysummaryfeedrest.setReferenceandlearningPercentage(dailySummaryFeedRest.getReferenceAndLearningPercentage());
                tDailysummaryfeedrest.setShoppingPercentage(dailySummaryFeedRest.getShoppingPercentage());
                tDailysummaryfeedrest.setUtilitiesPercentage(dailySummaryFeedRest.getUtilitiesPercentage());
                tDailysummaryfeedrest.setTotalHours(dailySummaryFeedRest.getTotalHours());
                tDailysummaryfeedrest.setVeryproductiveHours(dailySummaryFeedRest.getVeryProductiveHours());
                tDailysummaryfeedrest.setProductiveHours(dailySummaryFeedRest.getProductiveHours());
                tDailysummaryfeedrest.setNeutralHours(dailySummaryFeedRest.getNeutralHours());
                tDailysummaryfeedrest.setDistractingHours(dailySummaryFeedRest.getDistractingHours());
                tDailysummaryfeedrest.setVerydistractingHours(dailySummaryFeedRest.getVeryDistractingHours());
                tDailysummaryfeedrest.setAllproductiveHours(dailySummaryFeedRest.getAllProductiveHours());
                tDailysummaryfeedrest.setAlldistractingHours(dailySummaryFeedRest.getAllDistractingHours());
                tDailysummaryfeedrest.setUncategorizedHours(dailySummaryFeedRest.getUncategorizedHours());
                tDailysummaryfeedrest.setBusinessHours(dailySummaryFeedRest.getBusinessHours());
                tDailysummaryfeedrest.setCommunicationandschedulingHours(dailySummaryFeedRest.getCommunicationAndSchedulingHours());
                tDailysummaryfeedrest.setSocialnetworkingHours(dailySummaryFeedRest.getSocialNetworkingHours());
                tDailysummaryfeedrest.setDesignandcompositionHours(dailySummaryFeedRest.getDesignAndCompositionHours());
                tDailysummaryfeedrest.setEntertainmentHours(dailySummaryFeedRest.getEntertainmentHours());
                tDailysummaryfeedrest.setNewsHours(dailySummaryFeedRest.getNewsHours());
                tDailysummaryfeedrest.setSoftwaredevelopmentHours(dailySummaryFeedRest.getSoftwareDevelopmentHours());
                tDailysummaryfeedrest.setReferenceandlearningHours(dailySummaryFeedRest.getReferenceAndLearningHours());
                tDailysummaryfeedrest.setShoppingHours(dailySummaryFeedRest.getShoppingHours());
                tDailysummaryfeedrest.setUtilitiesHours(dailySummaryFeedRest.getUtilitiesHours());
                tDailysummaryfeedrest.setTotaldurationFormatted(dailySummaryFeedRest.getTotalDurationFormatted());
                tDailysummaryfeedrest.setVeryproductivedurationFormatted(dailySummaryFeedRest.getVeryProductiveDurationFormatted());
                tDailysummaryfeedrest.setProductivedurationFormatted(dailySummaryFeedRest.getProductiveDurationFormatted());
                tDailysummaryfeedrest.setNeutraldurationFormatted(dailySummaryFeedRest.getSocialNetworkingDurationFormatted());
                tDailysummaryfeedrest.setDistractingdurationFormatted(dailySummaryFeedRest.getDistractingDurationFormatted());
                tDailysummaryfeedrest.setVerydistractingdurationFormatted(dailySummaryFeedRest.getVeryDistractingDurationFormatted());
                tDailysummaryfeedrest.setAllproductivedurationFormatted(dailySummaryFeedRest.getAllProductiveDurationFormatted());
                tDailysummaryfeedrest.setAlldistractingdurationFormatted(dailySummaryFeedRest.getAllDistractingDurationFormatted());
                tDailysummaryfeedrest.setUncategorizeddurationFormatted(dailySummaryFeedRest.getUncategorizedDurationFormatted());
                tDailysummaryfeedrest.setBusinessdurationFormatted(dailySummaryFeedRest.getBusinessDurationFormatted());
                tDailysummaryfeedrest.setCommunicationandschedulingdurationFormatted(dailySummaryFeedRest.getCommunicationAndSchedulingDurationFormatted());
                tDailysummaryfeedrest.setSocialnetworkingdurationFormatted(dailySummaryFeedRest.getSocialNetworkingDurationFormatted());
                tDailysummaryfeedrest.setDesignandcompositiondurationFormatted(dailySummaryFeedRest.getDesignAndCompositionDurationFormatted());
                tDailysummaryfeedrest.setEntertainmentdurationFormatted(dailySummaryFeedRest.getEntertainmentDurationFormatted());
                tDailysummaryfeedrest.setNewsdurationFormatted(dailySummaryFeedRest.getNewsDurationFormatted());
                tDailysummaryfeedrest.setSoftwaredevelopmentdurationFormatted(dailySummaryFeedRest.getSoftwareDevelopmentDurationFormatted());
                tDailysummaryfeedrest.setReferenceandlearningdurationFormatted(dailySummaryFeedRest.getReferenceAndLearningDurationFormatted());
                tDailysummaryfeedrest.setShoppingdurationFormatted(dailySummaryFeedRest.getShoppingDurationFormatted());
                tDailysummaryfeedrest.setUtilitiesdurationFormatted(dailySummaryFeedRest.getUtilitiesDurationFormatted());

                insert(tDailysummaryfeedrest);
            }
        }


        return dailySummaryFeedRests;
    }

    public void insert(TDailysummaryfeedrest record) {
        tDailysummaryfeedrestMapper.insert(record);
    }

}
