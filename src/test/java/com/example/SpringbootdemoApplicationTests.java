package com.example;

import com.alibaba.fastjson.JSON;
import com.example.test.entity.Node;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootdemoApplicationTests {

	@Test
	void contextLoads() {
		ArrayList<Long> listA = Lists.newArrayListWithCapacity(10);
		Integer integer = 1;
		listA.contains(integer);

		log.info("测试={}", listA.contains(integer));
    }
}
