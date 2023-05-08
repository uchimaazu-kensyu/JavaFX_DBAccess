package com.example.javafxtest2;

public class User{
    //id用
    private static int idCounter = 1;


    private int id;
    private String affiliation;
    private String name;
    private int score;

    public User( String affiliation, String name, int score) {
        this.id = idCounter;
        this.affiliation= affiliation;
        this.name =name;
        this.score = score;
        idCounter++;
    }



    //getter,setter
    public int getId(){return id;}
    public String getAffiliation(){return affiliation;}
    public String getName(){return name;}
    public int getScore(){return score;}

    public void setID(int score){this.score =score;}
    public void setAffiliation(String affiliation){this.affiliation =affiliation;}
    public void setName(String name){this.name = name;}
    public void setScore(int score){this.score =score;}





}
