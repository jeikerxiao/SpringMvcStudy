package com.jeiker.demo.task;

import com.jeiker.demo.model.User;
import com.jeiker.demo.service.impl.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * spring task 定时任务测试，适用于单系统
 * 注意：不适合用于集群
 */
@Component
public class TestTask {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private TestService testService;

	@Scheduled(cron = "0/5 * * * * ?")
	public void cronTest() {
		logger.debug("===> 执行定时任务.");
		
		// 测试注解
		User user = testService.selectById(1L);

		logger.debug("===> user: {}",user);
	}
}
