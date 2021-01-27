import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 * This class creates a province
 *
 * @author Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.16.2019)
 */
public class Province
{
    // instance variables
    private String name;
    private ArrayList<Party> parties;
    private ArrayList<Integer> tally;
    private ArrayList<Candidate> candidates;
    private int seats;

    /**
     * Constructor for objects of class Province
     */
    public Province(String name, int seats)
    {
        // initialise instance variables
        this.name = name;
        parties = new ArrayList();
        candidates = new ArrayList();
        tally = new ArrayList();
        this.seats = seats;
    }

    /**
     * Returns the name of the province
     * 
     * @return String the name of the province
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the number of seats in a province
     * 
     * @return int number of seats in a province
       */
    public int getSeats()
    {
        return seats;
    }
    
    /**
     * Returns the numbers of parties running in a province
     * 
     * @return int the number of parties in a province
       */
    public int getNumberOfParties()
    {
        return parties.size();
    }
    
    /**
     * Returns an array list of parties running in the province
     * 
     * @return ArrayList the list of parties
       */
    public ArrayList getParties()
    {
        return parties;
    }
    
    /**
     * Adds a candidate running in the province
     * 
     * @param Candidate representative the candidate 
      */
    public void addRunner(Candidate representative)
    {
        candidates.add(representative);
        if (!parties.contains(representative.getParty()));
    }
    
    /**
     * Returns a party running in the province
     * 
     * @param String name the name of the party in the province
     * @Return the party
     */
    public Party getParty(String name)
    {
        Party partyX = null;
        for (Party party : parties)
        {
            if (party.getName().equals(name))
            {
                partyX = party;
            }
        }
        return partyX;
    }
    
    /**
     * Prints all the runners in the province
       */
    public void getRunners()
    {
        System.out.println("Province: " + name);
        for (Candidate runner : candidates)
        {
            System.out.println(runner.getVoteCount() + " Candidate: " 
            + runner.getName() + 
            "---" + runner.getParty().getName());
        }
        System.out.println();
    }
    
    /**
     * Returns a random candidate
     * 
     * @Candidate a randomly picked candidate
      */
    public Candidate randRunner()
    {
        Random rand = new Random();
        int index = Math.abs(rand.nextInt() % candidates.size());
       
        Candidate runnerX = candidates.get(index);
       
        return runnerX;
    }
    
    /**
     * Returns the total votes for a party in a province
     * 
     * @param String partyName the name of the party you want votes for
     * 
     * @return int the total number of votes a party got in a province
       */
    public int getPartyTally(String partyName)
    {
        int tally = 0;
        for (Candidate candidate : candidates)
        {
            if (candidate.getParty().getName().equals(partyName)){
                tally = tally + candidate.getVoteCount();
            }
        }
        return tally;
    }
    
}
