package org.apache.ibatis.demo;

import org.apache.ibatis.demo.entity.Blog;
import org.apache.ibatis.demo.mapper.BlogMapper;
import org.apache.ibatis.demo.mapper.BlogMapperInterface;
import org.apache.ibatis.demo.mapper2.BlogMapperPackage;
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

    //xml文件方式
    //映射器一：<mapper resource="BlogMapper.xml"/>
    Object o1 = sqlSession.selectOne("org.apache.ibatis.demo.mapper.BlogMapper.selectBlogById", 101);
    System.out.println("sqlSession.selectOne:" + o1);

    //接口+xml文件方式
    BlogMapper mapper1 = sqlSession.getMapper(BlogMapper.class);
    System.out.println("BlogMapperXml,sqlSession.selectOne:" + mapper1.selectBlogById(101L));

    //接口+注解@Select
    ///映射器二：<mapper class="org.apache.ibatis.demo.mapper.BlogMapperInterface"/>
    BlogMapperInterface mapper = sqlSession.getMapper(BlogMapperInterface.class);
    Blog blog = mapper.selectBlogById(101L);
    System.out.println("BlogMapperInterface,sqlSession.getMapper：" + blog);


    //映射器三： <package name="org.apache.ibatis.demo.mapper2"/>
    BlogMapperPackage mapper3 = sqlSession.getMapper(BlogMapperPackage.class);
    System.out.println(mapper3.selectBlogById3(101L));

    //映射器四：    <mapper url="file:///xxxxx.xml"></mapper>
    Object file = sqlSession.selectOne("org.apache.ibatis.demo.mapper.BlogMapperFile.selectBlogByIdFile", 101L);
    System.out.println(file);


  }

}
