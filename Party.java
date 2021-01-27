import java.util.ArrayList;
import java.util.Random;
/**
 * This class creates a party
 *
 * @author Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.16.2019)
 */
public class Party
{
    // instance variables
    private String name;
    private ArrayList<Candidate> reps;

    /**
     * Constructor for objects of class Party
     */
    public Party(String name)
    {
        // initialise instance variables
        this.name = name;
        reps = new ArrayList();
    }

    /**
     * Returns the name of the party
     * 
     * @return String the name of the party
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Adds a candidate to a party
     * 
     * @param Candidate rep the representative
       */
    public void addCandidate(Candidate rep)
    {
        reps.add(rep);
    }
    
    /**
     * Returns a candidate belonging to the party
     * 
     * @param String name the name of the candidate
     * @return Candidate the candidate belonging to a party
       */
    public Candidate getCandidate(String name)
    {
        Candidate repX = null;
        for (Candidate rep : reps){
            if (rep.getName().equals(name))
            {
                repX = rep;
            }
        }
        
        return repX;
    }
    
    /**
     * Returns a random candidate from the party
     * 
     * @return Candidate a randomly picked candidate
      */
    public Candidate randCandidate()
    {
        Random rand = new Random();
        int index = rand.nextInt() % reps.size();
        return reps.get(index);
    }
    
    /**
     * Prints all the candidates
       */
    public void printCandidates()
    {
        for (Candidate rep : reps)
        {
            System.out.println(rep.getName());
        }
    }
}
