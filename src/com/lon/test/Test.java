package com.lon.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.lon.dao.ArchiveDao;
import com.lon.dao.ArchiveTypeDao;
import com.lon.dao.EmployeeDao;
import com.lon.dao.impl.ArchiveDaoImpl;
import com.lon.dao.impl.ArchiveTypeDaoImpl;
import com.lon.dao.impl.EmployeeDaoImpl;
import com.lon.entity.Archive;
import com.lon.entity.ArchiveType;
import com.lon.entity.Employee;


public class Test {

	public static void main(String[] args) {
		
//		List<Employee> list = new ArrayList<>();
//		Random r = new Random();
//		for(int i=1;i<=50;i++) {
//			Employee e = new Employee();
//			e.setName("张松"+i);
//			e.setSex(i%2);
//			int age = r.nextInt(10)+20;
//			Calendar c = Calendar.getInstance();
//			c.add(Calendar.YEAR, -age);
//			e.setAge(age);
//			e.setEdu(1);
//			e.setDegree(1);
//			e.setJob("技术");
//			e.setDeptid(01+i);
//			e.setState(1);
//			e.setPhone("123564789");
//			e.setAddress("南宁"+i);
//			e.setCreateTime(new Timestamp(System.currentTimeMillis()));
//			list.add(e);
//			System.out.println("插入100条数据"+i+"记录");
//		}
//		EmployeeDao dao = new EmployeeDaoImpl();
//		dao.addMore(list);
//		System.out.println("成功添加数据");
		
		
		
//		List<ArchiveType> list = new ArrayList<>();
//		for(int i=1;i<=10;i++) {
//			ArchiveType a = new ArchiveType();
//			a.setName("A");
//			a.setRemark("机密文件");
//			list.add(a);
//			System.out.println("插入10条数据"+i+"记录");
//		}
//		ArchiveTypeDao dao = new ArchiveTypeDaoImpl();
//		dao.addMore(list);
//		System.out.println("成功添加数据");
		
		
		
		
		List<Archive> list = new ArrayList<>();
		for(int i=1;i<=10;i++) {
			Archive a = new Archive();
			a.setEmpid(i);
			a.setCode("01");
			a.setName("张松"+i);
			a.setContent("个人档案");
			a.setType(i);
			a.setRemark("个人档案...");
			
			a.setCreateTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
			System.out.println("插入10条数据"+i+"记录");
		}
		ArchiveDao dao = new ArchiveDaoImpl();
		dao.addMore(list);
		System.out.println("成功添加数据");
		
		
		
	}
}
