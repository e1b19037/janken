package oit.is.z1214.kaizi.janken.model;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select id,name from users where id=#{id}")
  User select(int id);

  @Select("select id,name from users where name=#{name}")
  User selectByName(String name);

  @Select("select * from users;")
  ArrayList<User> selectAllUser();

}
