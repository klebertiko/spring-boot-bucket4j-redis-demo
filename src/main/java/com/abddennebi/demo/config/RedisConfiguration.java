package com.abddennebi.demo.config;

import io.github.bucket4j.grid.GridBucketState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import java.net.URISyntaxException;

@Configuration
public class RedisConfiguration {

    @Bean
    Cache<String, GridBucketState> cache() throws URISyntaxException {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration<String, GridBucketState> config = new MutableConfiguration<>();
        Cache<String, GridBucketState> cache = cacheManager.createCache("buckets", config);
        return cache;
    }
}
