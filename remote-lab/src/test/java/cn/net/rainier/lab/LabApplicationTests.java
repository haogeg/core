package cn.net.rainier.lab;

import cn.net.rainier.global.entity.User;
import cn.net.rainier.global.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class LabApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }


    @Cacheable(value="ZhangSan",key="#name")
    public String getUser(String name1){
        User user = new User("LiSi",22);
        String name = user.getName();
        return name;
    }

    @Test
    public void testInsert(){
        User user = new User("ZhangSan1",21);
        redisUtil.set("ZhangSan1",user);
        System.out.println(getUser("ZhangSan1"));
        cleanBaseCodeCache();
    }

    @CacheEvict(value="ZhangSan",allEntries=true)
    public String cleanBaseCodeCache(){
        System.out.println("清除缓存");
        return "ok";
    }

}
