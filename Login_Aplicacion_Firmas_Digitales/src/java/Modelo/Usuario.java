/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author andre
 */
public class Usuario {
    
    private String UserRUT,UserName,UserPaternalSurname,UserMaternalSurname;
    private int UserGender;
    private String UserGenderWord,UserBirthDate, UserEmail,UserCommune, UserCity, UserCountry,UserPassword;

    public Usuario() 
    {
        
    }

    public Usuario(String UserName) 
    {
        this.UserName = UserName;
    }
    
    public Usuario(String UserRUT, String UserPassword) 
    {
        this.UserRUT = UserRUT;
        this.UserPassword = UserPassword;
    }

    public Usuario(String UserName, String UserPaternalSurname, String UserMaternalSurname) 
    {
        this.UserName = UserName;
        this.UserPaternalSurname = UserPaternalSurname;
        this.UserMaternalSurname = UserMaternalSurname;
    }
    
    public Usuario(String UserRUT, String UserName, String UserPaternalSurname, String UserMaternalSurname, int UserGender, String UserBirthDate, String UserEmail, String UserCommune, String UserCity, String UserCountry, String UserPassword) {
        this.UserRUT = UserRUT;
        this.UserName = UserName;
        this.UserPaternalSurname = UserPaternalSurname;
        this.UserMaternalSurname = UserMaternalSurname;
        this.UserGender = UserGender;
        this.UserBirthDate = UserBirthDate;
        this.UserEmail = UserEmail;
        this.UserCommune = UserCommune;
        this.UserCity = UserCity;
        this.UserCountry = UserCountry;
        this.UserPassword = UserPassword;
    }

    public Usuario(String UserRUT, String UserName, String UserPaternalSurname, String UserMaternalSurname, String UserGenderWord, String UserBirthDate, String UserEmail, String UserCommune, String UserCity, String UserCountry, String UserPassword) {
        this.UserRUT = UserRUT;
        this.UserName = UserName;
        this.UserPaternalSurname = UserPaternalSurname;
        this.UserMaternalSurname = UserMaternalSurname;
        this.UserGenderWord = UserGenderWord;
        this.UserBirthDate = UserBirthDate;
        this.UserEmail = UserEmail;
        this.UserCommune = UserCommune;
        this.UserCity = UserCity;
        this.UserCountry = UserCountry;
        this.UserPassword = UserPassword;
    }
    
    

    public String getUserRUT() {
        return UserRUT;
    }

    public void setUserRUT(String UserRUT) {
        this.UserRUT = UserRUT;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPaternalSurname() {
        return UserPaternalSurname;
    }

    public void setUserPaternalSurname(String UserPaternalSurname) {
        this.UserPaternalSurname = UserPaternalSurname;
    }

    public String getUserMaternalSurname() {
        return UserMaternalSurname;
    }

    public void setUserMaternalSurname(String UserMaternalSurname) {
        this.UserMaternalSurname = UserMaternalSurname;
    }

    public int getUserGender() {
        return UserGender;
    }

    public void setUserGender(int UserGender) {
        this.UserGender = UserGender;
    }

    public String getUserGenderWord() {
        return UserGenderWord;
    }

    public void setUserGenderWord(String UserGenderWord) {
        this.UserGenderWord = UserGenderWord;
    }
    
    

    public String getUserBirthDate() {
        return UserBirthDate;
    }

    public void setUserBirthDate(String UserBirthDate) {
        this.UserBirthDate = UserBirthDate;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getUserCommune() {
        return UserCommune;
    }

    public void setUserCommune(String UserCommune) {
        this.UserCommune = UserCommune;
    }

    public String getUserCity() {
        return UserCity;
    }

    public void setUserCity(String UserCity) {
        this.UserCity = UserCity;
    }

    public String getUserCountry() {
        return UserCountry;
    }

    public void setUserCountry(String UserCountry) {
        this.UserCountry = UserCountry;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }
    
    
    
    
}
