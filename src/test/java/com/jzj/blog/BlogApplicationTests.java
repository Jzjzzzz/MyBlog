package com.jzj.blog;

import com.jzj.blog.dao.TypeRepository;
import com.jzj.blog.po.Type;
import com.jzj.blog.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BlogApplicationTests {
    @Resource
    TypeService typeService;

    @Test
    void contextLoads() {
    }

    @Test
    void test (){
        typeService.updateType(12L,new Type());
    }

}
