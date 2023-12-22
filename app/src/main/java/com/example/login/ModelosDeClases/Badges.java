package com.example.login.ModelosDeClases;

public class Badges {
    String naame;
    String aavatar;
    public Badges(){

    }
    public Badges(String naame, String aavatar){
        this.naame = naame;
        this.aavatar=aavatar;

    }
    public String getNaame(){return this.naame;}
    public void setNaame(String naame){this.naame = naame;}
    public String getAavatar(){return this.aavatar;}
    public void setAavatar(String aavatar){this.aavatar = aavatar;}
}
