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

@Controller

@RequestMapping("/lec02")

public class Lec02Controller {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  private Entry entry;

  /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  // @Transactional
  @GetMapping("step1")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", "Hi " + loginUser);

    model.addAttribute("room", this.entry);

    ArrayList<User> Users7 = userMapper.selectAllUser();
    model.addAttribute("Users7", Users7);

    ArrayList<Match> Matches7 = matchMapper.selectAllMatch();
    model.addAttribute("Matches7", Matches7);

    return "lec02.html";
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

  @GetMapping("match")
  public String Match(ModelMap model) {
    return "match.html";
  }

}
