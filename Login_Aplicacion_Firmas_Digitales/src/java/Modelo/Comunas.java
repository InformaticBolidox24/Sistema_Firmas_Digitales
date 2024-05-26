
package Modelo;

/**
 *
 * @author andre
 */
public class Comunas 
{
    private int CommonCode;  
    private String CommonName; 
    private String CommonRegion;

    public Comunas() 
    {
        
    }

    public Comunas(int CommonCode, String CommonName) 
    {
        this.CommonCode = CommonCode;
        this.CommonName = CommonName;
    }

    public Comunas(int CommonCode, String CommonName, String CommonRegion) 
    {
        this.CommonCode = CommonCode;
        this.CommonName = CommonName;
        this.CommonRegion = CommonRegion;
    }

    public int getCommonCode() {
        return CommonCode;
    }

    public void setCommonCode(int CommonCode) {
        this.CommonCode = CommonCode;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setCommonName(String CommonName) {
        this.CommonName = CommonName;
    }

    public String getCommonRegion() {
        return CommonRegion;
    }

    public void setCommonRegion(String CommonRegion) {
        this.CommonRegion = CommonRegion;
    }
    
    
    
    
    
    
}
