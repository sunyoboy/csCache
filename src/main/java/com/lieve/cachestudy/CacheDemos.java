package com.lieve.cachestudy;
/**
 * @version 1.0
 * @author <a> href="mailto:sunlijiang@didichuxing.com">sunlijiang</a>
 * @since 2018/11/25 上午12:39
 */

import static javax.cache.expiry.Duration.ONE_HOUR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.invoke.MethodHandles;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.spi.CachingProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Greg Luck
 */
public class CacheDemos {


    @Test
    public void simpleAPITypeEnforcement() {

        //resolve a cache manager
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        //configure the cache
        MutableConfiguration<String, Integer> config = new MutableConfiguration<>();
        //uses store by reference
        config.setStoreByValue(false)
            .setTypes(String.class, Integer.class)
            .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(ONE_HOUR))
            .setStatisticsEnabled(true);

        //create the cache
        cacheManager.createCache("simpleOptionalCache", config);

        //... and then later to get the cache
        Cache<String, Integer> cache = Caching.getCache("simpleOptionalCache",
            String.class, Integer.class);

        //use the cache
        String key = "key";
        Integer value1 = 1;
        cache.put("key", value1);
        Integer value2 = cache.get(key);
        assertEquals(value1, value2);

        cache.remove("key");
        assertNull(cache.get("key"));
    }




}
