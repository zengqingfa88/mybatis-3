package org.apache.ibatis.demo;

import org.apache.ibatis.demo.entity.Blog;
import org.apache.ibatis.demo.mapper.BlogMapper;
import org.apache.ibatis.demo.mapper.BlogMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @fileName: TestDemo
 * @author: zengqf3
 * @date: 2021-3-9 11:47
 * @description:
 */
public class TestDemo {

  public static void main(String[] args) throws Exception {

    // 加载mybatis配置文件，并创建SqlSessionFactory实例
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //这个build方法可以接受几种不同的参数，如Reader/InputSteam等
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = factory.openSession();
    Object o = sqlSession.selectOne("org.apache.ibatis.demo.mapper.BlogMapper.selectBlogById", 101);
    System.out.println("sqlSession.selectOne:" + o);
    BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
    Blog blog = mapper.selectBlogById(101L);
    System.out.println("sqlSession.getMapper：" + blog);

    BlogMapper2 mapper2 = sqlSession.getMapper(BlogMapper2.class);
    Blog blog2 = mapper2.selectBlogById(101L);
    System.out.println("sqlSession.getMapper：" + blog2);

  }

}
