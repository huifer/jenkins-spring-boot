package com.huifer.jenkinsspringboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2019-10-08
 */
@Data
@Configuration
public class SenboRestConfig {

    @Value("${senbo.rest.host_port}")
    private String hostPort;
    @Value("${senbo.rest.ticket.base_url}")
    private String ticketBaseUrl;
    @Value("${senbo.rest.ticket.list}")
    private String ticketList;
    @Value("${senbo.rest.ticket.details}")
    private String ticketDetails;
    @Value("${senbo.rest.ticket.price}")
    private String ticketPrice;
    @Value("${senbo.rest.ticket.activeiet}")
    private String ticketActiveiet;
    @Value("${senbo.rest.ticket.notice}")
    private String ticketNotice;
    @Value("${senbo.rest.ticket.activity_quota}")
    private String ticketActivityQuota;
    @Value("${senbo.rest.ticket.activity_list}")
    private String ticketActivityList;

}
