
/**
 * This class creates a candidate representative
 *
 * @author Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.16.2019)
 */
public class Candidate
{
    // instance variables
    private String name;
    private int voteCount;
    private Party party;

    /**
     * Constructor for objects of class Candidate
     * 
     * @param String name the name of the candidate
     * @param Party party the party the candidate belongs to 
     */
    public Candidate(String name, Party party)
    {
        // initialise instance variables
        this.name = name;
        voteCount = 0;
        this.party = party;
    }

    /**
     * Returns the name of the candidate
     * 
     * @return String the name of the candidate
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the party of the candidate
     * 
     * @return Party the party of the candidate
     */
    public Party getParty()
    {
        return party;
    }
    
    /**
     * Increment the vote count
       */
    public void vote()
    {
        voteCount++;
    }
    
    /**
     * Return the vote count
     * 
     * @return int the vote count
       */
    public int getVoteCount()
    {
        return voteCount;
    }
}
