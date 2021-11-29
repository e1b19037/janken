package oit.is.z1214.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import oit.is.z1214.kaizi.janken.model.Entry;
import oit.is.z1214.kaizi.janken.model.Janken;
import oit.is.z1214.kaizi.janken.model.UserMapper;
import oit.is.z1214.kaizi.janken.model.User;
import oit.is.z1214.kaizi.janken.model.Match;
import oit.is.z1214.kaizi.janken.model.MatchMapper;
import oit.is.z1214.kaizi.janken.model.MatchInfo;
import oit.is.z1214.kaizi.janken.model.MatchInfoMapper;

@Controller

@RequestMapping("/lec02")

public class Lec02Controller {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  @Autowired
  private Entry entry;

  /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  @Transactional
  @GetMapping("step1")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", "Hi " + loginUser);
    model.addAttribute("entry", this.entry);
    ArrayList<User> users = userMapper.selectAllUser();
    model.addAttribute("users", users);
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    model.addAttribute("matches", matches);

    ArrayList<MatchInfo> matchInfo = matchInfoMapper.selectActive(true);
    model.addAttribute("matchinfo", matchInfo);

    return "lec02.html";
  }

  @Transactional
  @GetMapping("match")
  public String Match(@RequestParam Integer id, ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    User login_user = userMapper.selectByName(loginUser);
    User id_user = userMapper.select(id);

    MatchInfo matchInfo = new MatchInfo();
    matchInfo.setUser1(login_user.getId());
    matchInfo.setUser2(id);
    matchInfo.setActive(true);
    model.addAttribute("login_user", login_user);
    model.addAttribute("id_user", id_user);

    return "match.html";
  }

  @Transactional
  @GetMapping("battle")
  public String battle(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {

    String loginUser = prin.getName(); // ログインユーザ情報
    User login_user = userMapper.selectByName(loginUser);
    User id_user = userMapper.select(id);
    // ArrayList<MatchInfo> EMatchInfo = matchInfoMapper.selectActiveUser(true,
    // login_user.getId());
    model.addAttribute("yourHand", hand);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("id_user", id_user);
    MatchInfo matchInfo = new MatchInfo();
    matchInfo.setUser1(login_user.getId());
    matchInfo.setUser2(id_user.getId());
    matchInfo.setUser1Hand(hand);
    matchInfo.setActive(true);
    matchInfoMapper.insertMatchInfo(matchInfo);
    model.addAttribute("matchinfo", matchInfo);

    return "wait.html";

  }

  @GetMapping("gu")
  public String Sample1(ModelMap model) {
    String b = "gu";
    int a = 1;
    Janken janken = new Janken(a);
    model.addAttribute("player", "あなたの手 " + b);
    model.addAttribute("judge", janken.getJudge());
    model.addAttribute("cpu", "相手の手  " + janken.getcpu());
    return "lec02.html";
  }

  @GetMapping("choki")
  public String Sample2(ModelMap model) {
    String b = "choki";
    int a = 2;
    Janken janken = new Janken(a);
    model.addAttribute("player", "あなたの手 " + b);
    model.addAttribute("judge", janken.getJudge());
    model.addAttribute("cpu", "相手の手  " + janken.getcpu());
    return "lec02.html";
  }

  @GetMapping("pa")
  public String Sample3(ModelMap model) {
    String b = "pa";
    int a = 3;
    Janken janken = new Janken(a);
    model.addAttribute("player", "あなたの手 " + b);
    model.addAttribute("judge", janken.getJudge());
    model.addAttribute("cpu", "相手の手 " + janken.getcpu());
    return "lec02.html";
  }

}
