package oit.is.z1214.kaizi.janken.model;

public class Janken {
   String g = "choki";
   String c;

  public Janken(int a){


    if(a==1){
       c =  "You Win!";
    }else if(a==2){
      c ="draw!";
    }else if(a==3){
     c ="You Lose!";
    }
  }

  public String getJudge(){
    return c;
  }

  public void setJudge(String c){
    this.c = c;
  }

  public String getcpu(){
    return g;
  }

  public void setcpu(String g){
    this.g=g;
  }



}
