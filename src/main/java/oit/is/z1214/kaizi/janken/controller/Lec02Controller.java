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

    return "lec02.html";
  }

  @Transactional
  @GetMapping("match")
  public String Match(@RequestParam Integer id, ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    User login_user = userMapper.selectByName(loginUser);
    User id_user = userMapper.select(id);
    model.addAttribute("login_user", login_user);
    model.addAttribute("id_user", id_user);

    return "match.html";
  }

  @Transactional
  @GetMapping("battle")
  public String battle(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    int login_id = 0;
    String cpu_hand = "GU";
    String result;
    String loginUser = prin.getName(); // ログインユーザ情報

    if (loginUser.equals("ほんだ")) {
      login_id = 2;
    }
    Match te = new Match();
    te.setUser1(login_id);
    te.setUser2(id);
    te.setUser1Hand(hand);
    te.setUser2Hand(cpu_hand);
    matchMapper.insertMatch(te);
    ArrayList<Match> match = matchMapper.selectAllMatch();
    model.addAttribute("match", match);
    model.addAttribute("yourhand", hand);
    model.addAttribute("cpuhand", cpu_hand);

    if (hand.equals("Gu")) {
      result = "draw!";
      model.addAttribute("result", result);
    } else if (hand.equals("Choki")) {
      result = "You Lose!";
      model.addAttribute("result", result);
    } else if (hand.equals("Pa")) {
      result = "You Win!";
      model.addAttribute("result", result);
    }
    return "match.html";

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
