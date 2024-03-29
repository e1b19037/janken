package oit.is.z1214.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT * FROM matchinfo WHERE id = #{id}")
  MatchInfo select(int id);

  @Select("SELECT * FROM matchinfo WHERE isActive = #{isActive}")
  ArrayList<MatchInfo> selectActive(boolean isActive);

  @Select("SELECT * FROM matchinfo WHERE isActive = #{isActive} and user2 = #{user}")
  ArrayList<MatchInfo> selectActiveUser(boolean isActive, int user);

  @Insert("INSERT INTO matchinfo (user1, user2, user1Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchInfo);

}
