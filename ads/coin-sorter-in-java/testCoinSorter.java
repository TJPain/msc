import java.util.ArrayList;
import java.util.Arrays;
 
public class testCoinSorter {
	
    public static void main (String args[])
    {
    	// initialise a CoinSorter object with the default values specified in the brief 
    	CoinSorter sorter = new CoinSorter("GBP", 0, 10000, (new ArrayList<Integer>(Arrays.asList(200, 100, 50, 20, 10))));
    	// launch main menu
    	sorter.mainMenu();
    }
}
