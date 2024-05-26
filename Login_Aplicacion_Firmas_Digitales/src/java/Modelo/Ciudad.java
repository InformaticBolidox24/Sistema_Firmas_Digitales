/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author andre
 */
public class Ciudad 
{
    private String CityCode;
    private String CityName;
    private int CityRegion;

    public Ciudad() 
    {
        
    }

    public Ciudad(String CityCode, String CityName) 
    {
        this.CityCode = CityCode;
        this.CityName = CityName;
    }
    
    public Ciudad(String CityCode, String CityName, int CityRegion) 
    {
        this.CityCode = CityCode;
        this.CityName = CityName;
        this.CityRegion = CityRegion;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getCityRegion() {
        return CityRegion;
    }

    public void setCityRegion(int CityRegion) {
        this.CityRegion = CityRegion;
    }
    
    
    
}
