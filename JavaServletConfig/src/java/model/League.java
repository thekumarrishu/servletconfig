/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Admin
 */
public class League {
    int year;
    String season;
    String title;
    
    public League(int year, String season, String title) {
        this.year = year;
        this.season = season;
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    public String getSeason() {
        return season;
    }
    public String getTitle() {
        return title;
    }
    
    public String toString() {
        return title;
    }
}
