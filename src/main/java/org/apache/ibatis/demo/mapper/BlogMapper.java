package org.apache.ibatis.demo.mapper;

import org.apache.ibatis.demo.entity.Blog;

/**
 * @fileName: BlogMapper
 * @author: zengqf3
 * @date: 2021-3-9 17:38
 * @description:
 */
public interface BlogMapper {


  Blog selectBlogById(Long id);
}
