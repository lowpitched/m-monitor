package com.example.monitor;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.monitor.common.CommonResult;
import com.example.monitor.controller.BaseController;
import com.example.monitor.perm.controller.MtaUserController;
import com.example.monitor.perm.entity.MtaUser;
import com.example.monitor.utils.QueryWrapperUtils;
import com.example.monitor.utils.ServiceStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MMonitorApplicationTests {

	@Autowired
	private MtaUserController controller;

	@Test
	public void contextLoads() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		IService<MtaUser> service = ServiceStore.getService(MtaUser.class);
		List<MtaUser> list = service.list();
		System.out.println("----------------"+JSON.toJSONString(list));
		MtaUser query = new MtaUser();
		//query.setPin("2");
		query.setCreateTime_GE(df.parse("20190915000000"));
		query.setCreateTime_LE(df.parse("20190915235959"));
		CommonResult cr = controller.list(3, 1, query);
		System.out.println(JSON.toJSONString(cr.getData()));
	}

}
