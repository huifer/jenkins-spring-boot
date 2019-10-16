//package com.huifer.jenkinsspringboot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
///**
// * @Date: 2019-10-16
// */
//@Configuration
//public class RedisConfig {
////    @Bean
////    public RedisSentinelConfiguration redisSentinelConfiguration() {
////        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
////        String[] host = redisNodes.split(",");
////        for (String redisHost : host) {
////            String[] item = redisHost.split(":");
////            String ip = item[0];
////            String port = item[1];
////            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
////        }
////        configuration.setMaster(master);
////        return configuration;
////    }
////
////    /**
////     * 连接redis的工厂类
////     *
////     * @return
////     */
////    @Bean
////    public JedisConnectionFactory jedisConnectionFactory() {
////        //构造方法中注入RedisSentinelConfiguration对象
////        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
////        factory.setHostName(host);
////        factory.setPort(port);
////        factory.setTimeout(timeout);
////        factory.setPassword(password);
////        factory.setDatabase(database);
////        return factory;
////    }
//}
