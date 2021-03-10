package org.apache.ibatis.demo.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.demo.entity.Blog;

/**
 * @fileName: BlogMapperXml
 * @author: zengqf3
 * @date: 2021-3-9 17:38
 * @description:
 */
public interface BlogMapperInterface {

  @Select("SELECT * FROM blog WHERE id = #{id}")
  Blog selectBlogById(Long id);
}
