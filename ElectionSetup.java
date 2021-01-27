import java.util.ArrayList;
import java.util.Iterator;
/**
 * This class creates a fictional country, sets up provinces, parties, and 
 * candidates.
 *
 * @author Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version (11.16.2019)
 */
public class ElectionSetup
{
    /**
     * Constructor for objects of class ElectionSetup
     */
    Country country;
    ArrayList<Province> provinces;
    ArrayList<Party> parties;
    
    public ElectionSetup()
    {
        // initialise instance variables
        country = new Country("The Candy Kingdom");
        System.out.println("-----------" + country.getName() + "------------");
        provinces = new ArrayList();
        createProvinces();
        parties = new ArrayList();
        createParties();
        createCandidates();
        createRepresentatives();
        System.out.println("-----------BEFORE ELECTION-------------");
        printInfo();
    }
    
    /**
     * create the provinces
       */
    private void createProvinces()
    {
        if (country == null){
            System.out.println("You dont have a country");
        }
        Province province1 = new Province("Nerdiana", 3);
        Province province2 = new Province("Toffee Land", 2);
        Province province3 = new Province("Marshmallow World", 2);
        
        country.addProvince(province1);
        country.addProvince(province2);
        country.addProvince(province3);
        
        provinces.add(province1);
        provinces.add(province2);
        provinces.add(province3);
    }
    
    /**
     * create the parties
       */
    private void createParties()
    {
        Party party1 = new Party("Kit Kat Kings");
        Party party2 = new Party("Jawbreakers");
        Party party3 = new Party("Starburst Alliance");
        Party party4 = new Party("Nonpartisan Heads");
        
        parties.add(party1);
        parties.add(party2);
        parties.add(party3);
        parties.add(party4);
    }
    
    /**
     * create the candidates
       
       */
    private void createCandidates()
    {
        Candidate candidate1 = new Candidate("Reese Peanutbutter", parties.get(0));
        Candidate candidate2 = new Candidate("Hershey Kisston", parties.get(0));
        Candidate candidate3 = new Candidate("Cadbury Eggson III", parties.get(0));
        Candidate candidate4 = new Candidate("Gummi Bear", parties.get(1));
        Candidate candidate5 = new Candidate("Laffi Taffi", parties.get(1));
        Candidate candidate6 = new Candidate("Jolly De La Rancher", parties.get(2));
        Candidate candidate7 = new Candidate("Star Burst", parties.get(3));
        Candidate candidate8 = new Candidate("Candy McCorn", parties.get(2));
        Candidate candidate9 = new Candidate("Andy Mints", parties.get(0));
        Candidate candidate10 = new Candidate("Chewie Charleston", parties.get(3));
        Candidate candidate11 = new Candidate("Henry Oh", parties.get(2));
        Candidate candidate12 = new Candidate("Cinnamon Bearenstein", parties.get(3));
        
        parties.get(0).addCandidate(candidate1);
        parties.get(0).addCandidate(candidate2);
        parties.get(0).addCandidate(candidate3);
        parties.get(1).addCandidate(candidate4);
        parties.get(1).addCandidate(candidate5);
        parties.get(2).addCandidate(candidate6);
        parties.get(3).addCandidate(candidate7);
        parties.get(2).addCandidate(candidate8);
        parties.get(0).addCandidate(candidate9);
        parties.get(3).addCandidate(candidate10);
        parties.get(2).addCandidate(candidate11);
        parties.get(3).addCandidate(candidate12);
        
    }
    
    /**
     * add candidates to provinces that they will run in
       */
    private void createRepresentatives()
    {
        provinces.get(0).addRunner(parties.get(0)
            .getCandidate("Reese Peanutbutter"));
        provinces.get(0).addRunner(parties.get(1)
            .getCandidate("Gummi Bear"));
        provinces.get(0).addRunner(parties.get(2)
            .getCandidate("Jolly De La Rancher"));
        provinces.get(0).addRunner(parties.get(0)
            .getCandidate("Andy Mints"));
        provinces.get(0).addRunner(parties.get(3)
            .getCandidate("Chewie Charleston"));
            
        provinces.get(1).addRunner(parties.get(0)
            .getCandidate("Hershey Kisston"));
        provinces.get(1).addRunner(parties.get(1)
            .getCandidate("Laffi Taffi"));
        provinces.get(1).addRunner(parties.get(3)
            .getCandidate("Star Burst"));
        provinces.get(1).addRunner(parties.get(2)
            .getCandidate("Candy McCorn"));
            
        provinces.get(2).addRunner(parties.get(0)
            .getCandidate("Cadbury Eggson III"));
        provinces.get(2).addRunner(parties.get(2)
            .getCandidate("Henry Oh"));
        provinces.get(2).addRunner(parties.get(3)
            .getCandidate("Cinnamon Bearenstein"));
    }
    
    /**
     * print the info of all the runners
       */
    public void printInfo()
    {
        provinces.stream()
        .forEach(province -> province.getRunners());
    }
    
    /**
     * return the country
     * 
     * @return Country the country 
       */
    public Country getCountry()
    {
        return country;
    }
    
    /**
     * tally all the votes using the d'Hondt system and show the results
       */
    public void tally()
    {
        //Using the d'Hondt system, tally the votes and assign seats
        //Nerdiana
        Province nerdiana = provinces.get(0);
        ArrayList<Integer> n = new ArrayList();
        //get the total number of votes a party got in a province
        n.add(nerdiana.getPartyTally("Kit Kat Kings"));
        n.add(nerdiana.getPartyTally("Jawbreakers"));
        n.add(nerdiana.getPartyTally("Starburst Alliance"));
        n.add(nerdiana.getPartyTally("Nonpartisan Heads"));
        //every party starts with 0 seats
        ArrayList<Integer> s = new ArrayList();
        for (int i=0; i<4; i++)
        {
            s.add(0);
        }
        //keep track of the highest quota
        int highest = 0;
        //keep track of who won the quota
        int index = 0;
        int seat = 0;
        //the calculations
        for (int i=0; i<nerdiana.getSeats(); i++)
        {
            //for each party calculate the quota
            for (int j=0; j<n.size(); j++){
                seat = n.get(j)/(s.get(j)+1);
                if (seat>highest){
                    highest = seat;
                    index = j;
                }
                seat = 0;
                //give a seat to the party that won the quota
                if (j == n.size()-1)
                {
                    s.set(index, s.get(index)+1);
                    highest = 0;
            }}
        }
        System.out.println("Province: Nerdiana -- 3 seats");
        System.out.println("Kit Kat Kings won " + s.get(0) + " seat(s)");
        System.out.println("Jawbreakers won " + s.get(1) + " seat(s)");
        System.out.println("Starburst Alliance won " + s.get(2) + " seat(s)");
        System.out.println("Nonpartisan Heads won " + s.get(3) + " seat(s)");
        System.out.println();
        
        //Toffee Land
        Province toffee = provinces.get(1);
        //total all the votes a party got in a province
        ArrayList<Integer> n1 = new ArrayList();
        n1.add(toffee.getPartyTally("Kit Kat Kings"));
        n1.add(toffee.getPartyTally("Jawbreakers"));
        n1.add(toffee.getPartyTally("Starburst Alliance"));
        n1.add(toffee.getPartyTally("Nonpartisan Heads"));
        //every party starts with 0 seats
        ArrayList<Integer> s1 = new ArrayList();
        for (int i=0; i<4; i++)
        {
            s1.add(0);
        }
        //keep track of the highest quota
        int highest1 = 0;
        //keep track of who won the quota
        int index1 = 0;
        int seat1;
        //the calculations
        for (int i=0; i<toffee.getSeats(); i++)
        {
            //for each party, calculate the quota
            for (int j=0; j<n1.size(); j++){
                seat1 = n1.get(j)/(s1.get(j)+1);
                if (seat1>highest1){
                    highest1 = seat1;
                    index1 = j;
                }
                seat1 = 0;
                //if the party won the quota, give them a seat
                if (j == n1.size()-1)
                {
                    s1.set(index1, s1.get(index1)+1);
                    highest1 = 0;
            }}
        }
        System.out.println("Province: Toffee Land -- 2 seats");
        System.out.println("Kit Kat Kings won " + s1.get(0) + " seat(s)");
        System.out.println("Jawbreakers won " + s1.get(1) + " seat(s)");
        System.out.println("Starburst Alliance won " + s1.get(2) + " seat(s)");
        System.out.println("Nonpartisan Heads won " + s1.get(3) + " seat(s)");
        System.out.println();
        
        //Marshmallow World
        Province marsh = provinces.get(2);
        //total the votes a party got in a province
        ArrayList<Integer> n2 = new ArrayList();
        n2.add(marsh.getPartyTally("Kit Kat Kings"));
        n2.add(marsh.getPartyTally("Starburst Alliance"));
        n2.add(marsh.getPartyTally("Nonpartisan Heads"));
        //every party has 0 seats initially
        ArrayList<Integer> s2 = new ArrayList();
        for (int i=0; i<3; i++)
        {
            s2.add(0);
        }
        //keep track of the highest quota
        int highest2 = 0;
        //keep track of who won the seat
        int index2 = 0;
        int seat2=0;
        for (int i=0; i<marsh.getSeats(); i++)
        {
            //for each party, calculate the quota
            for (int j=0; j<n2.size(); j++){
                seat2 = n2.get(j)/(s2.get(j)+1);
                if (seat2>highest2){
                    highest2 = seat2;
                    index2 = j;
                }
                seat2 = 0;
                //award a seat to the party that won the quota
                if (j == n2.size()-1)
                {
                    s2.set(index2, s2.get(index2)+1);
                    highest2 = 0;
            }}
        }
        System.out.println("Province: Marshmallow World -- 2 seats");
        System.out.println("Kit Kat Kings won " + s2.get(0) + " seat(s)");
        System.out.println("Starburst Alliance won " + s2.get(1) + " seat(s)");
        System.out.println("Nonpartisan Heads won " + s2.get(2) + " seat(s)");
        System.out.println();
    }
}
