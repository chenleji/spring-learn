package net.ljchen.learn.Utils;

import net.ljchen.learn.Configuration.RedisConfig;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;


public class DistributedLock {
    private static Logger LOGGER = LoggerFactory.getLogger(DistributedLock.class);

    private RedisConfig redisConfig;

    private static final String LOCK_SUCCESS = "OK";

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    @Autowired
    public DistributedLock(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }

    private Jedis getJedis() {
        Jedis jedis = null;

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort());

        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return jedis;
    }

    public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
        Jedis jedis = getJedis();
        String result;

        try {
            result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            jedis.close();
            return false;
        }

        jedis.close();

        LOGGER.info(LOCK_SUCCESS.equals(result) ? "get lock success!" : "get lock failed!");

        return LOCK_SUCCESS.equals(result);
    }

    public boolean releaseDistributedLock(String lockKey, String requestId) {
        Jedis jedis = getJedis();
        Object result;

        try {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            jedis.close();
            return false;
        }

        jedis.close();

        LOGGER.info(RELEASE_SUCCESS.equals(result) ? "release lock success!" : "release lock failed!");

        return RELEASE_SUCCESS.equals(result);
    }
}
