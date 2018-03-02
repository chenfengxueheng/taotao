package com.taotao.mybatis.pagehelper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbUser;

public class TestPageHelper {

	@Test
	public void testPageHelper(){
		
		//初始化Spring容器
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		// 从容器中获得mapper代理对象
		TbItemMapper itemMapper=applicationContext.getBean(TbItemMapper.class);
		//执行查询
		TbItemExample example =new TbItemExample();
		System.out.println(example);
		//查询之前进行分页处理
		PageHelper.startPage(1, 30);// 注意，分页插件仅对最近的这一次查询有效，下一次查询就无效了。怎么实现的呢？使用了LocalThread。
		List<TbItem> list = itemMapper.selectByExample(example);
		 // 取分页信息
        System.out.println("结果集中的记录数：" + list.size());
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
	}
	
	@Test
	public void testSQL(){
		//初始化Spring容器
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		// 从容器中获得mapper代理对象
		TbUserMapper userMapper =applicationContext.getBean(TbUserMapper.class);
		 TbUser user=userMapper.selectByPrimaryKey((long) 7);
		 System.out.println(user.toString());
	}
	
	
	
	
	@Test
	public void getSelect(){
		String sql = "select * from tb_user"; 
		Connection conn = getCon();
		PreparedStatement pst = null;
		try {
			pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String s=rs.getString("username");
				System.out.println(s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	 public Connection getCon() {
	        //数据库连接名称
	        String username="root";
	        //数据库连接密码
	        String password="123";
	        String driver="com.mysql.jdbc.Driver";
	        //其中test为数据库名称
	        String url="jdbc:mysql://localhost:3306/taotao";
	        Connection conn=null;
	        try{
	            Class.forName(driver);
	            conn=(Connection) DriverManager.getConnection(url,username,password);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return conn;
	    }  
}
