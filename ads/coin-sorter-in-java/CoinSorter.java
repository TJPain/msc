import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoinSorter {
	
	// attributes
    private String currency;
    private int minCoinIn;
    private int maxCoinIn;
    private ArrayList<Integer> coinList;
     
    // set keyboard scanner
	static Scanner keyboard = new Scanner(System.in);
	//Scanner object for string inputs
	Scanner keyboardString = new Scanner(System.in);
    
    // constructor
    public CoinSorter(String currencyIn, int minCoinInput, int maxCoinInput, ArrayList<Integer> coinListIn)
    {
    	currency = currencyIn;
    	minCoinIn = minCoinInput;
    	maxCoinIn = maxCoinInput;
    	coinList = coinListIn;
    }
    
    // default constructor
    public CoinSorter()
    {
    	
    }
	
	// setters
    public void setCurrency(String currencyIn) 
    {
    	currency = currencyIn;
    }
    
    public void setMinCoinIn(int minCoinInput) 
    {
    	minCoinIn = minCoinInput;
    }
    
    public void setMaxCoinIn(int maxCoinInput) 
    {
    	maxCoinIn = maxCoinInput;
    }    
    
    // getters
    public String getCurrency()
    {
    	return currency;
    }
    
    public int getMinCoinIn()
    {
    	return minCoinIn;
    }
    
    public int getMaxCoinIn()
    {
    	return maxCoinIn;
    }
    
    
    // returns a string of the valid coin denominations
    public String printCoinList()
    {
        // use the StringBuilder class to create a better looking string that just returning and printing the array 
    	StringBuilder coinString = new StringBuilder();
        coinString.append("Valid coin denominations: ");
        // loop through the coins in the coinList, format each value and append to the new string 
        for(int i=0; i<coinList.size(); i++)
        {
        	// reformat £2 and £1 from 200p and 100p
        	if (coinList.get(i) == 200) {
        		coinString.append("£2, ");
        	} else if (coinList.get(i) == 100) {
        		coinString.append("£1, ");
        	} else {
        	// add the p sign to all other values 	
        	coinString.append(coinList.get(i) + "p, ");
        	}
        }	
        // return the new string with improved formatting
        return coinString.toString();
    }

    
    // calculates a coin exchange for a given value and a single coin type
    public String coinCalculator(int valueIn, int coinIn)
    {
    	// use the StringBuilder class to correctly format the returned string
    	StringBuilder coinCalc = new StringBuilder();
    	// use a new class for the coin name / value in order to format it correctly
    	String coinName;
    	// use modulo to calculate the remainder 
    	int remainder = valueIn % coinIn; 
    	// remove the calculated remainder from the total value and divide by the coin value to get the number of coins
    	int coinCount = (valueIn - remainder) / coinIn; 
    	// adjust coin name for £1 and £2 coins. Add p to other coins
		if (coinIn == 200) {
			coinName = "£2";
		} else if (coinIn == 100) {
			coinName = "£1";
		} else {
			coinName = Integer.toString(coinIn) + "p";
		}
    	// return the well formatted string
    	return  coinCalc.toString() + "A total of " + coinCount + " x " + coinName + " coins can be exchanged for " + valueIn + "p, with a remainder of " + remainder + "p";
    }
    
    
    // calculates a coin exchange for a given value and multiple coins with one coin value excluded
    public String multiCoinCalculator(int valueIn, int excludedCoin)
    {
    	// use the StringBuilder class to correctly format the returned string
    	StringBuilder coinCalc = new StringBuilder("The coins exchanged for " + valueIn + "p are: ");
    	// setup an integer for remaining value. After looping through each coin in descending order, this value is then used for the next coin's calculations
    	int remainingValue = valueIn;
    	// create a remainder value and initialise it to 0
    	int remainder = 0;
    	// create a coin count value for the number of each coin type the user will receive 
    	int coinCount; 
    	// create a coin name value to reformat the pence integer values 
    	String coinName;
    	// create new ArrayList without the excluded coin
    	ArrayList<Integer> newCoinList = new ArrayList<>();
    	for (int i=0; i<coinList.size(); i++) {
    		if (coinList.get(i) != excludedCoin) {
    			newCoinList.add(coinList.get(i));
    		}
    	}
    	// sort the new ArrayList into descending size (to ensure that they are in priority order)
    	Collections.sort(newCoinList, Collections.reverseOrder());
    	// loop through included coins while the exchange value remains positive
    	for (int i=0; i<newCoinList.size(); i++) {
    		if (remainingValue > 0) 
    		{
    			remainder = remainingValue % newCoinList.get(i);
        		coinCount = (remainingValue - remainder) / newCoinList.get(i);
        		// if the quantity of the current coin value in the exchange is greater than zero, include in the string
        		if(coinCount > 0) {
        			// adjust remaining value
            		remainingValue -= (newCoinList.get(i) * coinCount);
            		// adjust coin name for £1 and £2 coins
            		if (newCoinList.get(i) == 200) {
            			coinName = "£2";
            		} else if (newCoinList.get(i) == 100) {
            			coinName = "£1";
            		} else {
            			coinName = Integer.toString(newCoinList.get(i)) + "p";
            		}
            		// append the coin name and quantity to the string
            		coinCalc.append(coinCount + " x " + coinName + ", ");
        		} 
    		}
    	}
    	// append the remainder after all coins have been converted
    	coinCalc.append("with a remainder of " + remainder + "p");
    	// return the string
    	return coinCalc.toString();
    }
    
    
    // returns the currency and the current minimum and maximum accepted values
    public String displayProgramConfigs()
    {
    	// use the StringBuilder class to format the returned string
    	StringBuilder status = new StringBuilder();
    	status.append("Currency: " + currency + "\nMinimum value: " + minCoinIn + "\nMinimum value: " + maxCoinIn);
    	return status.toString();
    }

    
    // main text-based menu 
    public void mainMenu()
    {
    	char response;
        System.out.println("*** Coin Sorter - Main Menu ***");
        System.out.println();
        do 
        {
	        // menu options
        	System.out.println("1 - Coin calculator");
	        System.out.println("2 - Multiple coin calculator");
	        System.out.println("3 - Print coin list");
	        System.out.println("4 - Set details");
	        System.out.println("5 - Display program configurations");
	        System.out.println("6 - Quit the program");
	        System.out.println();
	        System.out.println("Enter choice from 1-6: ");
	        // get response
	        response = keyboard.next().charAt(0);  
	        System.out.println();
	        // process response and call the correct method
	        switch(response) 
	        {
	        	case '1':	singleCoinValidation(); 
	        				break;
	        	case '2':	multiCoinValidation(); 
							break;
	        	case '3':	System.out.println(printCoinList()); 
	        				System.out.println();
							break;
	        	case '4':	subMenu();
							break;
	        	case '5':	System.out.println(displayProgramConfigs()); 
							System.out.println();
							break;
	        	case '6':	System.out.println("Thank you");
	        				break;
	        	default:	System.out.println("Enter only numbers from 1 - 6");
	        				System.out.println();
	        }
        } while (response != '6');
    }
    
    
    // a value validation method to be used for both option 1 and option 2 from the menu
    public int valueValidation()
    {
    	// set impossible (negative) dummy amount for do while loop
    	int value = -999; 
    	do 
    	{
    		System.out.println();
    		System.out.println("How much money would you like to exchange (in pence)?");
    		// check that the input is an integer
    		if(keyboard.hasNextInt()){
    			   value = keyboard.nextInt();
    			   // check that the input is between the minimum and maximum value and isn't negative
    			   if (value < 0 || value < minCoinIn || value > maxCoinIn) {
    				   value = -999;
    				   System.out.println("You must enter a non-negative value between " + minCoinIn + " and " + maxCoinIn);
    				   System.out.println();
    			   }
    			}else{
    				// if the input wasn't a value, print a warning and loop again
    			   System.out.println("You must enter an integer. '"+keyboard.next() + "' is invalid");
    			   System.out.println();
    			   value = -999;
    			}
    	} while (value == -999);
    	return value;
    }
    
 
    // for menu option 1 - validate inputs for a single coin exchange and call the coinCalculator method
    public void singleCoinValidation()
    {
    	int value;
    	int coin = 0;
    	// set match value to false for do while validation loop
    	boolean coinMatch = false;
    	// validate the exchange value input with the above method
    	value = valueValidation();    	
    	// validate the coin value input
    	do 
    	{
    		System.out.println();
    		System.out.println("What value of coin would you like to exchange your money for (in pence)?");
    		// check that the input is an integer
    		if(keyboard.hasNextInt()){
    			coin = keyboard.nextInt();
    			// check that the input matches a coin from the list of coins
    			if(coinList.contains(coin)){
    		        coinMatch = true;
    		    } else {
    		    	System.out.println("You must enter a valid coin value.");
    		    	System.out.println(printCoinList());
    		    	System.out.println();
    		    }    			
    		} else {
    			System.out.println("You must enter an integer. '"+keyboard.next() + "' is invalid");
    			System.out.println();
    		}
    	} while (!coinMatch);
    	// call and print the coin calculator method
    	System.out.println(coinCalculator(value, coin));
    	System.out.println();
    	// back to the main menu
    	mainMenu();
    }
    
    
    // for menu option 2 - validate inputs for a multiple coin exchange and call the multiCoinCalculator method
    public void multiCoinValidation()
    {
    	// set impossible (negative) dummy amount for do while loop 
    	int value; 
    	int coin = 0;
    	// set match value to false for do while validation loop
    	boolean coinMatch = false;
    	// validate the exchange value input with the above method
    	value = valueValidation(); 
    	// validate the coin value input
    	do 
    	{
    		System.out.println();
    		System.out.println("What value of coin would you like to exclude from the exchange (in pence)?");
    		// check that the input is an integer
    		if(keyboard.hasNextInt()){
    			coin = keyboard.nextInt();
    			// check that the input matches a coin from the list of coins
    			if(coinList.contains(coin)){
    		        coinMatch = true;
    		    } else {
    		    	System.out.println("You must enter a valid coin value.");
    		    	System.out.println(printCoinList());
    		    	System.out.println();
    		    }    			
    		} else {
    			System.out.println("You must enter an integer. '"+keyboard.next() + "' is invalid");
    			System.out.println();
    		}
    	} while (!coinMatch);
    	// call and print the coin calculator method
    	System.out.println(multiCoinCalculator(value, coin));
    	System.out.println();
    	// back to the main menu
    	mainMenu();
    }
    
    
    // for menu option 4 - a sub-menu of setter methods
    public void subMenu()
    {
    	char response;
        System.out.println("*** Set Details Sub-Menu ***");
        System.out.println();
        do 
        {
	        // menu options
        	System.out.println("1 - Set currency");
	        System.out.println("2 - Set minimum coin input value");
	        System.out.println("3 - Set maximum coin input value");
	        System.out.println("4 - Return to main menu");
	        System.out.println();
	        System.out.println("Enter choice from 1-4: ");
	        // get response
	        response = keyboard.next().charAt(0);  
	        System.out.println();
	        // process response
	        switch(response) 
	        {
	        	case '1':	currencySetter();
	        				break;
	        	case '2':	validateMinCoinIn();
							break;
	        	case '3':	validateMaxCoinIn();
							break;
	        	case '4':	mainMenu(); 
	        				break;
	        	default:	System.out.println("Enter only numbers from 1 - 4");
	        				System.out.println();
	        }
        } while (response != '4');
    }
    
    
    // for sub-menu option 1 - set currency
    public void currencySetter()
    {
    	// create a temporary String to hold the currency input
    	String newCurrency = "";
    	System.out.println();
		System.out.println("Which currency would you like to exchange?");
		// use the Scanner method that is reserved for strings
		newCurrency = keyboardString.nextLine();
		// check that the user input is at least one character and isn't a number 
		if (newCurrency.length() > 0 && !newCurrency.matches("-?\\d+(\\.\\d+)?")) {
			// if it passes validation, set the currency 
			setCurrency(newCurrency);
			System.out.println();
			System.out.println("Currency set to: " + getCurrency());
			System.out.println();
		} else {
			// if it fails validation, ask again
			System.out.println();
			System.out.println("You entered an invalid currency. Please try again.");
			currencySetter();
		}	
		// return to sub-menu
		subMenu();
    }
    
    // for sub-menu option 2 - set minimum input value
    public void validateMinCoinIn()
    {
    	int newMin;
    	// add a boolean to manage the do while loop
    	boolean validInput = false;
    	do 
    	{
	    	System.out.println();
			System.out.println("Please input a new minimum exchange value (in pence)?");
			// check that the input is an integer
			if(keyboard.hasNextInt()){
				newMin = keyboard.nextInt();
				// check that the input is above zero and less than the current maximum
				if(newMin >= 0 && newMin < maxCoinIn){
					// call the setMinCoinIn with the validated value and alter boolean to exit do while loop
					setMinCoinIn(newMin);
					validInput = true;
			    } else {
			    	System.out.println("You must enter a number between zero and the current maximum of " + maxCoinIn + "p");
			    	System.out.println();
			    }    			
			} else {
				System.out.println("You must enter an integer. '"+keyboard.next() + "' is invalid");
				System.out.println();
			}
		} while (!validInput);
		// call the setMinCoinIn method
    	System.out.println();
    	System.out.println("Minimum value updated to " + getMinCoinIn() + "p") ;
		System.out.println();
		// return to sub-menu
		subMenu();
    }
    
    // for sub-menu option 3 - set maximum input value
    public void validateMaxCoinIn()
    {
    	int newMax;
    	// add a boolean to manage the do while loop
    	boolean validInput = false;
    	do 
    	{
	    	System.out.println();
			System.out.println("Please input a new maximum exchange value (in pence)?");
			// check that the input is an integer
			if(keyboard.hasNextInt()){
				newMax = keyboard.nextInt();
				// check that the input is above zero and more than the current minimum
				if(newMax >= 0 && newMax > minCoinIn){
					// call the setMaxCoinIn with the validated value and alter boolean to exit do while loop
					setMaxCoinIn(newMax);
					validInput = true;
			    } else {
			    	System.out.println("You must enter a number above the current minimum of " + minCoinIn + "p");
			    	System.out.println();
			    }    			
			} else {
				System.out.println("You must enter an integer. '"+keyboard.next() + "' is invalid");
				System.out.println();
			}
		} while (!validInput);
		// call the setMinCoinIn method
    	System.out.println();
    	System.out.println("Maximum value updated to " + getMaxCoinIn() + "p") ;
		System.out.println();
		// return to sub-menu
		subMenu();
    	
    }  
}