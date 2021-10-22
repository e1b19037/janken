package oit.is.z1214.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import oit.is.z1214.kaizi.janken.model.Entry;
import oit.is.z1214.kaizi.janken.model.Janken;


/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */

@Controller

@RequestMapping("/lec02")

public class Lec02Controller {

  @Autowired
  private Entry entry;



    /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */

 @GetMapping("step1")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", "Hi "+loginUser);


    model.addAttribute("room", this.entry);
    return "lec02.html";
  }

  @GetMapping("gu")
public String Sample1(ModelMap model){
  String b="gu";
  int a=1;
Janken janken = new Janken(a);
  model.addAttribute("player","あなたの手 "+b );
   model.addAttribute("judge",janken.getJudge() );
    model.addAttribute("cpu","相手の手  "+janken.getcpu() );
  return "lec02.html";
}
@GetMapping("choki")
public String Sample2(ModelMap model){
  String b="choki";
  int a=2;
  Janken janken = new Janken(a);
  model.addAttribute("player","あなたの手 "+b );
   model.addAttribute("judge",janken.getJudge() );
   model.addAttribute("cpu","相手の手  "+janken.getcpu() );
  return "lec02.html";
}
@GetMapping("pa")
public String Sample3(ModelMap model){
  String b="pa";
  int a=3;
  Janken janken = new Janken(a);
  model.addAttribute("player","あなたの手 "+b );
  model.addAttribute("judge",janken.getJudge() );
  model.addAttribute("cpu","相手の手 "+janken.getcpu() );
  return "lec02.html";
}

}
