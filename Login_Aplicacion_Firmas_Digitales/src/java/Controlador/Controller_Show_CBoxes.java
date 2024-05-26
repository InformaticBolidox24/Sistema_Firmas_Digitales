
package Controlador;

import Modelo.Ciudad;
import Modelo.Comunas;
import Modelo.Pais;
import Modelo.Usuario;
import Persistencia.Ciudades_DAO;
import Persistencia.Comunas_DAO;
import Persistencia.Paises_DAO;
import Persistencia.Usuarios_DAO;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Controller_Show_CBoxes 
{
    Paises_DAO CountryDAO;
    ArrayList<Pais> COMBOPAIS;
    
    Comunas_DAO CommonDAO;
    ArrayList<Comunas> COMBOCOMUNAS;
    
    Ciudades_DAO CityDAO;
    ArrayList<Ciudad> COMBOCIUDADES;
    
    Usuarios_DAO UsersDAO;
    ArrayList<Usuario> COMBOUSERS;
    
    public ArrayList<Pais> TraerListadoPaises()
    {
        CountryDAO = new Paises_DAO();
        COMBOPAIS = CountryDAO.TraerNombresPaises();
        return COMBOPAIS;
    }
    
    public ArrayList<Comunas> TraerListadoComunas()
    {
        CommonDAO = new Comunas_DAO();
        COMBOCOMUNAS = CommonDAO.TraerNombresComunas();
        return COMBOCOMUNAS;
    }
    
    public ArrayList<Ciudad> TraerListadoCiudades()
    {
        CityDAO = new Ciudades_DAO();
        COMBOCIUDADES = CityDAO.TraerNombresComunas();
        return COMBOCIUDADES;
    }
    
    public ArrayList<Usuario> TraerListadoUsuariosRegistrados()
    {
        UsersDAO = new Usuarios_DAO();
        COMBOUSERS = UsersDAO.TraerUsuariosRegistrados();
        return COMBOUSERS;
    }
}
