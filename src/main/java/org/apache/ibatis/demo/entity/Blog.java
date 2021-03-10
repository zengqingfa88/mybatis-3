package org.apache.ibatis.demo.entity;

/**
 * @fileName: Blog
 * @author: zengqf3
 * @date: 2021-3-9 17:43
 * @description:
 */
public class Blog {

  private Long id;

  private String name;

  private String title;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", title='" + title + '\'' +
      '}';
  }
}
