import java.util.ArrayList;
/**
 * This class simulates a fake election in a fake country.
 *
 * @Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.18.2019)
 */
public class ElectionSimulator
{
    // instance variables
    private int votes;
    private ElectionSetup country;
    

    /**
     * Constructor for objects of class ElectionSimulator
     */
    public ElectionSimulator(ElectionSetup country, int votes)
    {
        // initialise instance variables
        this.votes = votes;
        this.country = country;
        electionNight();
    }

    /**
     * electionNight runs the simulation
     */
    public void electionNight()
    {
        for (int i = 0; i<votes; i++){
            country.getCountry().vote();
        }
        System.out.println("-----------AFTER ELECTION-------------");
        country.printInfo();
        System.out.println("-----------AFTER TALLY-------------");
        country.tally();
    }
}
