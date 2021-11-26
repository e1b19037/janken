package oit.is.z1214.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  @Select("select id, user1, user2, user1Hand, user2Hand from matches where id = #{id}")
  Match select(int id);

  @Select("select * from matches;")
  ArrayList<Match> selectAllMatch();

  @Insert("insert into matches (user1, user2, user1Hand, user2Hand) values (#{user1}, #{user2},#{user1Hand}, #{user2Hand});")
  void insertMatch(Match match);
}
