package com.huifer.jenkinsspringboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 描述:
 * 日期工具
 *
 * @author huifer
 * @date 2019-09-30
 */
public class DateUtils {


    private DateUtils() {
        throw new RuntimeException("this is a utils");
    }

    public static void main(String[] args) {
        getYestday();
    }

    /**
     * 获取昨天的日期
     *
     * @return 昨日年月日
     */
    public static String getYestday() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        String yest = df.format(date);
        return yest;
    }

    /**
     * 返回事时间描述
     *
     * @param hours
     * @param minutes
     * @return xxx小时 xxx分钟
     */
    public static String timeText(int hours, int minutes) {
        return String.format("%d 小时 %d分钟", hours, minutes);
    }
}
