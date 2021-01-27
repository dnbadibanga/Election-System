import java.util.ArrayList;
import java.util.Random;
/**
 * The Country class creates a country
 *
 * @author Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.16.2019)
 */
public class Country
{
    // instance variables
    private String name;
    private ArrayList<Province> provinces;
 
    /**
     * Constructor for objects of class Country
     */
    public Country(String name)
    {
        // initialise instance variables
        this.name = name;
        provinces = new ArrayList();
    }

    /**
     * Returns the name of the country
     * 
     * @return the name of the country
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Adds a province to the country
     * 
     * @param Province name the name of the province
      */
    public void addProvince(Province name)
    {
        provinces.add(name);
    }
    
    /**
     * Returns a province
     * 
     * @param String name the name of the province
     * @return Province the province object
      */
    public Province getProvince(String name)
    {
        Province provinceX = null;
        for (Province province : provinces)
        {
            if (province.getName().equals(name))
            {
                provinceX = province;
            }
        }
        return provinceX;
    }
    
    /**
     * Returns an arraylist of provinces
     * 
     * @return ArrayList list of provinces
       */
    public ArrayList getProvinces()
    {
        return provinces;
    }
    
    /**
     * Returns a random province
     * 
     * @return Province a randomly picked province
      */
    public Province randProvince()
    {
        Random rand = new Random();
        int index = Math.abs(rand.nextInt() % provinces.size()) ;
        
        return provinces.get(index);
    }
    
    /**
     * Votes for a specific candidate, in a particular party and province.
      */
    public void vote()
    {
        randProvince().randRunner().vote();
    }
}
