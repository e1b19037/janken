package oit.is.z1214.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1214.kaizi.janken.model.Janken;

/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */

@Controller

public class Lec02Controller {
  @GetMapping("lec02")
  public String lec02(){
    return "lec02.html";
  }

  @PostMapping("lec02")
  public String postRequest(@RequestParam("text1")String str, ModelMap model){
    model.addAttribute("user_name","Hi"+str );
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
