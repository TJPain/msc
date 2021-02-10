import java.util.Arrays;
import java.util.ArrayList;
import javafx.application.Application; 
import javafx.geometry.Pos; 
import javafx.geometry.Insets;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.stage.Stage; 
	
public class CoinSorterGUI extends Application {

	// create an object of the CoinSorter class as an attribute    
	private CoinSorter sorter = new CoinSorter("GBP", 0, 10000, (new ArrayList<Integer>(Arrays.asList(200, 100, 50, 20, 10)))); 

	// to hold the menu stack pane cards:
	private StackPane menuStack = new StackPane(); 
	// to hold the action stack pane cards:
	private StackPane actionsStack = new StackPane(); 
	
	@Override    
	public void start(Stage stage)
	{
		// Main menu items and styling: 
		
		// create title
		Label mainTitle = new Label("Main menu"); 
		mainTitle.setTextFill(Color.GRAY); 
		mainTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox titleContainer = new HBox(15); 
		titleContainer.getChildren().addAll(mainTitle);
		titleContainer.setStyle("-fx-padding: 10");
		titleContainer.setAlignment(Pos.CENTER);
		
		// create buttons to perform the calculations
        Button coinCalcButton = new Button("Coin calculator");
        coinCalcButton.setPrefSize(150, 30);
        coinCalcButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
        Button multiCalcButton = new Button("Multiple coin calculator");
        multiCalcButton.setPrefSize(150, 30);
        multiCalcButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
        Button printCoinsButton = new Button("Print coin list");
        printCoinsButton.setPrefSize(150, 30);
        printCoinsButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
        Button setDetailsButton = new Button("Set details");
        setDetailsButton.setPrefSize(150, 30);
        setDetailsButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
        Button showConfigsButton = new Button("Display configurations");
        showConfigsButton.setPrefSize(150, 30);
        showConfigsButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
        Button quitButton = new Button("Quit the program");
        quitButton.setPrefSize(150, 30);
        quitButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
       
        //create a HBox to hold the top three buttons 
        HBox topButtons = new HBox(15); 
        topButtons.getChildren().addAll(coinCalcButton, multiCalcButton, printCoinsButton);
        topButtons.setAlignment(Pos.CENTER);
        
        //create a HBox to hold the bottom three buttons 
        HBox bottomButtons = new HBox(15); 
        bottomButtons.getChildren().addAll(setDetailsButton, showConfigsButton, quitButton);
        bottomButtons.setAlignment(Pos.CENTER);
        
        //create a VBox as the main menu card to hold the rows of buttons
        VBox mainMenu = new VBox(10);
        mainMenu.getChildren().addAll(titleContainer, topButtons, bottomButtons);
        mainMenu.setAlignment(Pos.TOP_CENTER);
        mainMenu.setStyle("-fx-padding: 10");
	
        
        
        // Sub menu items and styling: 
		
 		// create title
 		Label subMenuTitle = new Label("Set details menu"); 
 		subMenuTitle.setTextFill(Color.GRAY); 
 		subMenuTitle.setFont(Font.font("Arial", 20));
 		
 		// create a HBox to hold the title - allowing for extra styling
 		HBox subTitleContainer = new HBox(15); 
 		subTitleContainer.getChildren().addAll(subMenuTitle);
 		subTitleContainer.setStyle("-fx-padding: 10");
 		subTitleContainer.setAlignment(Pos.CENTER);
 		
 		// create buttons to perform the calculations
 		Button setCurrencyButton = new Button("Set currency");
 		setCurrencyButton.setPrefSize(150, 30);
 		setCurrencyButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
 		Button setMinButton = new Button("Set minimum input");
 		setMinButton.setPrefSize(150, 30);
 		setMinButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
 		Button setMaxButton = new Button("Set maximum input");
 		setMaxButton.setPrefSize(150, 30);
 		setMaxButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
 		Button backToMainButton = new Button("Return to main menu");
 		backToMainButton.setPrefSize(150, 30);
 		backToMainButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");

		//create a HBox to hold the top two buttons 
		HBox topSubButtons = new HBox(15); 
		topSubButtons.getChildren().addAll(setCurrencyButton, setMinButton);
		topSubButtons.setAlignment(Pos.CENTER);
		 
		//create a HBox to hold the bottom two buttons 
		HBox bottomSubButtons = new HBox(15); 
		bottomSubButtons.getChildren().addAll(setMaxButton, backToMainButton);
		bottomSubButtons.setAlignment(Pos.CENTER);
		 
		//create a VBox as the sub menu card to hold the rows of buttons
		VBox subMenu = new VBox(10);
		subMenu.getChildren().addAll(subTitleContainer, topSubButtons, bottomSubButtons);
		subMenu.setAlignment(Pos.TOP_CENTER);
		subMenu.setStyle("-fx-padding: 10");
    
		
		
		// non menu items:
		
		// cards for inputs: 
		
		// default card: 
		Label selectAButtonTitle = new Label("Please select a button from the menu"); 
		selectAButtonTitle.setTextFill(Color.GRAY); 
		selectAButtonTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox selectTitleContainer = new HBox(15); 
		selectTitleContainer.getChildren().addAll(selectAButtonTitle);
		selectTitleContainer.setStyle("-fx-padding: 10");
		selectTitleContainer.setAlignment(Pos.CENTER);
		
		//create a VBox as the default card
		VBox defaultActionsCard = new VBox(10);
		defaultActionsCard.getChildren().addAll(selectTitleContainer);
		defaultActionsCard.setAlignment(Pos.TOP_CENTER);
		defaultActionsCard.setStyle("-fx-padding: 0");
	
		
		
		// single coin counter inputs card
		
		// create title
		Label coinCounterTitle = new Label("Input your choices"); 
		coinCounterTitle.setTextFill(Color.GRAY); 
		coinCounterTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox coinTitleContainer = new HBox(15); 
		coinTitleContainer.getChildren().addAll(coinCounterTitle);
		coinTitleContainer.setStyle("-fx-padding: 10");
		coinTitleContainer.setAlignment(Pos.CENTER);
		
		// drop down coin selector - declare a String type for a combo box, add choices and text
		ComboBox<String> coinBox = new ComboBox<>();
		// added set value / holding text into items so that it is shown again when the combo box is cleared / reset
		coinBox.getItems().addAll("Choose coin value", "£2", "£1", "50p", "20p", "10p"); 
		
		// create and configure labels for the value text field        
		Label coinValueLabel = new Label("Exchange value (p):");         
		coinValueLabel.setTextFill(Color.GRAY);         
		coinValueLabel.setFont(Font.font("Arial", 15));   
		
		// text field for exchange value input          
		TextField coinValueField = new TextField();         
		coinValueField.setMaxWidth(100);  
		
		// create a HBox for the inputs 
		HBox coinInputs = new HBox(10);
		coinInputs.getChildren().addAll(coinValueLabel, coinValueField, coinBox);
		coinInputs.setAlignment(Pos.CENTER);
		coinInputs.setStyle("-fx-padding: 10");
		
		// create a run button
		Button coinCalcRunButton = new Button("Run");
		coinCalcRunButton.setPrefSize(150, 30);
		coinCalcRunButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
		
		//create a VBox as the coin selectors input card
		VBox coinSelectorInputs = new VBox(10);
		coinSelectorInputs.getChildren().addAll(coinTitleContainer, coinInputs, coinCalcRunButton);
		coinSelectorInputs.setAlignment(Pos.TOP_CENTER);
		coinSelectorInputs.setStyle("-fx-padding: 0");
	
		
		
		// multiple coin counter inputs card
		// create title
		Label multiCounterTitle = new Label("Input your choices"); 
		multiCounterTitle.setTextFill(Color.GRAY); 
		multiCounterTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox multiTitleContainer = new HBox(15); 
		multiTitleContainer.getChildren().addAll(multiCounterTitle);
		multiTitleContainer.setStyle("-fx-padding: 10");
		multiTitleContainer.setAlignment(Pos.CENTER);
		
		// drop down coin selector - declare a String type for a combo box, add choices and text
		ComboBox<String> multiCoinBox = new ComboBox<>();
		// added set value / holding text into items so that it is shown again when the combo box is cleared / reset
		multiCoinBox.getItems().addAll("Choose excluded coin", "£2", "£1", "50p", "20p", "10p");  
		
		// create and configure labels for the value text field        
		Label multiValueLabel = new Label("Exchange value (p):");         
		multiValueLabel.setTextFill(Color.GRAY);         
		multiValueLabel.setFont(Font.font("Arial", 15));   
		
		// text field for exchange value input          
		TextField multiValueField = new TextField();         
		multiValueField.setMaxWidth(100);  
		
		// create a HBox for the inputs 
		HBox multiInputs = new HBox(10);
		multiInputs.getChildren().addAll(multiValueLabel, multiValueField, multiCoinBox);
		multiInputs.setAlignment(Pos.CENTER);
		multiInputs.setStyle("-fx-padding: 10");
		
		// create a run button
		Button multiCalcRunButton = new Button("Run");
		multiCalcRunButton.setPrefSize(150, 30);
		multiCalcRunButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
		
		//create a VBox as the multiple coin selectors input card
		VBox multiSelectorInputs = new VBox(10);
		multiSelectorInputs.getChildren().addAll(multiTitleContainer, multiInputs, multiCalcRunButton);
		multiSelectorInputs.setAlignment(Pos.TOP_CENTER);
		multiSelectorInputs.setStyle("-fx-padding: 0");
		
		
		
		// set currency input card
		// create title
		Label currencyTitle = new Label("Input your choice"); 
		currencyTitle.setTextFill(Color.GRAY); 
		currencyTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox currencyTitleContainer = new HBox(15); 
		currencyTitleContainer.getChildren().addAll(multiCounterTitle);
		currencyTitleContainer.setStyle("-fx-padding: 10");
		currencyTitleContainer.setAlignment(Pos.CENTER);
		
		// create and configure label for the value text field        
		Label currencyLabel = new Label("New currency:");         
		currencyLabel.setTextFill(Color.GRAY);         
		currencyLabel.setFont(Font.font("Arial", 15));   
		
		// text field for currency input          
		TextField currencyField = new TextField();         
		currencyField.setMaxWidth(100);  
		
		// create a HBox for the inputs 
		HBox currencyInputs = new HBox(10);
		currencyInputs.getChildren().addAll(currencyLabel, currencyField);
		currencyInputs.setAlignment(Pos.CENTER);
		currencyInputs.setStyle("-fx-padding: 10");
		
		// create a run button
		Button currencyRunButton = new Button("Run");
		currencyRunButton.setPrefSize(150, 30);
		currencyRunButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
		
		//create a VBox as the currency input card
		VBox setCurrencyInputs = new VBox(10);
		setCurrencyInputs.getChildren().addAll(currencyTitleContainer, currencyInputs, currencyRunButton);
		setCurrencyInputs.setAlignment(Pos.TOP_CENTER);
		setCurrencyInputs.setStyle("-fx-padding: 0");
		
		
		
		// set minimum input card
		// create title
		Label minimumTitle = new Label("Input your choice"); 
		minimumTitle.setTextFill(Color.GRAY); 
		minimumTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox minimumTitleContainer = new HBox(15); 
		minimumTitleContainer.getChildren().addAll(minimumTitle);
		minimumTitleContainer.setStyle("-fx-padding: 10");
		minimumTitleContainer.setAlignment(Pos.CENTER);
		
		// create and configure label for the value text field        
		Label minimumLabel = new Label("New minimum input (p):");         
		minimumLabel.setTextFill(Color.GRAY);         
		minimumLabel.setFont(Font.font("Arial", 15));   
		
		// text field for value input          
		TextField minimumField = new TextField();         
		minimumField.setMaxWidth(100);  
		
		// create a HBox for the inputs 
		HBox minimumInputs = new HBox(10);
		minimumInputs.getChildren().addAll(minimumLabel, minimumField);
		minimumInputs.setAlignment(Pos.CENTER);
		minimumInputs.setStyle("-fx-padding: 10");
		
		// create a run button
		Button minimumRunButton = new Button("Run");
		minimumRunButton.setPrefSize(150, 30);
		minimumRunButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
		
		//create a VBox as the minimum input card
		VBox setMinimumInputs = new VBox(10);
		setMinimumInputs.getChildren().addAll(minimumTitleContainer, minimumInputs, minimumRunButton);
		setMinimumInputs.setAlignment(Pos.TOP_CENTER);
		setMinimumInputs.setStyle("-fx-padding: 0");
				
		
		
		// set maximum input card
		// create title
		Label maximumTitle = new Label("Input your choice"); 
		maximumTitle.setTextFill(Color.GRAY); 
		maximumTitle.setFont(Font.font("Arial", 20));
		
		// create a HBox to hold the title - allowing for extra styling
		HBox maximumTitleContainer = new HBox(15); 
		maximumTitleContainer.getChildren().addAll(maximumTitle);
		maximumTitleContainer.setStyle("-fx-padding: 10");
		maximumTitleContainer.setAlignment(Pos.CENTER);
		
		// create and configure label for the value text field        
		Label maximumLabel = new Label("New maximum input (p):");         
		maximumLabel.setTextFill(Color.GRAY);         
		maximumLabel.setFont(Font.font("Arial", 15));   
		
		// text field for value input          
		TextField maximumField = new TextField();         
		maximumField.setMaxWidth(100);  
		
		// create a HBox for the inputs 
		HBox maximumInputs = new HBox(10);
		maximumInputs.getChildren().addAll(maximumLabel, maximumField);
		maximumInputs.setAlignment(Pos.CENTER);
		maximumInputs.setStyle("-fx-padding: 10");
		
		// create a run button
		Button maximumRunButton = new Button("Run");
		maximumRunButton.setPrefSize(150, 30);
		maximumRunButton.setStyle("-fx-background-color: #52B4B4; -fx-background-radius: 6px; -fx-text-fill: #ffffff;");
		
		//create a VBox as the minimum input card
		VBox setMaximumInputs = new VBox(10);
		setMaximumInputs.getChildren().addAll(maximumTitleContainer, maximumInputs, maximumRunButton);
		setMaximumInputs.setAlignment(Pos.TOP_CENTER);
		setMaximumInputs.setStyle("-fx-padding: 0");		
		
		
		
		// warnings and results area
		Label warningLabel = new Label("");         
		warningLabel.setTextFill(Color.RED);         
		warningLabel.setFont(Font.font("Arial", 15));
		
		
		// non editable text result area   
		TextArea resultsArea = new TextArea();        
		resultsArea.setEditable(false);         
		resultsArea.setMinSize(500,65);         
		resultsArea.setMaxSize(500,65); 
		
		
		
		// configure the menuStack stack pane
		menuStack.setPadding(new Insets(10, 10, 10, 10)); 
		menuStack.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		menuStack.setAlignment(Pos.CENTER);
        
		// add the cards to the menuStack stack pane
		menuStack.getChildren().addAll(mainMenu, subMenu);
        
		// show the menuStack card and hide the subMenu card
		menuStack.getChildren().get(0).setVisible(true);
		menuStack.getChildren().get(1).setVisible(false);
        
		// configure the subMenuStack stack pack
		actionsStack.setPadding(new Insets(10, 10, 10, 10)); 
		actionsStack.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		actionsStack.setAlignment(Pos.CENTER);
        
		// add the cards to the menuStack stack pane
		actionsStack.getChildren().addAll(defaultActionsCard, coinSelectorInputs, multiSelectorInputs, setCurrencyInputs, setMinimumInputs, setMaximumInputs);
        
		// show the menuStack card and hide the subMenu card
		actionsStack.getChildren().get(0).setVisible(true);
		actionsStack.getChildren().get(1).setVisible(false);
		actionsStack.getChildren().get(2).setVisible(false);
		actionsStack.getChildren().get(3).setVisible(false);
		actionsStack.getChildren().get(4).setVisible(false);
		actionsStack.getChildren().get(5).setVisible(false);
		
		// add event handlers to call the relevant helper methods
		// main menu items:
        coinCalcButton.setOnAction (e -> {
        	// reset defaults in case it has been used before
        	coinBox.getSelectionModel().selectFirst();
        	coinValueField.setText("");
        	// show correct action card
        	setActionCard(1);
        	// clear warning and results area
        	warningLabel.setText("");
        	resultsArea.setText("");
        }); 
		multiCalcButton.setOnAction (e -> {
			// reset defaults in case it has been used before
        	multiCoinBox.getSelectionModel().selectFirst();
        	multiValueField.setText("");
        	// show correct action card
        	setActionCard(2);
        	// clear warning and results area
        	warningLabel.setText("");
        	resultsArea.setText("");
        }); 
		printCoinsButton.setOnAction (e -> {
			// print coins to text area
			resultsArea.setText(sorter.printCoinList());
			// show default actions card
			setActionCard(0);
			// clear warning area
			warningLabel.setText("");
		});
        setDetailsButton.setOnAction (e -> {
        	// show sub menu
        	subMenu();
        	// show default actions card
        	setActionCard(0);
			// clear warning and results area
			warningLabel.setText("");
        	resultsArea.setText("");
        }); 
		showConfigsButton.setOnAction (e -> {
			// print configurations to the text area
			resultsArea.setText(sorter.displayProgramConfigs());
			// show default actions card
			setActionCard(0);
			// clear warning area
			warningLabel.setText("");
		});
		quitButton.setOnAction (e -> quitProgram());
		
		// sub menu items
		setCurrencyButton.setOnAction (e -> {
			// reset defaults in case it has been used before
			currencyField.setText("");
			// display correct action card pane			
			setActionCard(3);
			// clear warning and results area
			warningLabel.setText("");
		   	resultsArea.setText("");
		});
		setMinButton.setOnAction (e -> {
			// reset defaults in case it has been used before
			minimumField.setText("");
			// display correct action card pane			
			setActionCard(4);
			// clear warning and results area
			warningLabel.setText("");
			resultsArea.setText("");
		});
		setMaxButton.setOnAction (e -> {
			// reset defaults in case it has been used before
			maximumField.setText("");
			// display correct action card pane			
			setActionCard(5);
			// clear warning and results area
			warningLabel.setText("");
			resultsArea.setText("");
		});
		backToMainButton.setOnAction (e -> {
			// show default actions card
			setActionCard(0);
			// return to main menu
			mainMenu();
			// clear warning and results area
			warningLabel.setText("");
			resultsArea.setText("");
		});
		
		
		// run buttons on action cards
		// run coin calculation button 
		coinCalcRunButton.setOnAction (e -> {
			// temporary values for the input value and coin choice
			int valueInput;
			int coinChoice = 0;
			// get the current minimum and maximum
			int minValue = sorter.getMinCoinIn();
			int maxValue = sorter.getMaxCoinIn();
			// check that inputs have been made
			if(coinValueField.getText().isEmpty() || coinBox.getValue() == "Choose coin value")
			{
				// display warning if either input is empty
				warningLabel.setText("You must enter an exchange value and select a coin type");
			} else {
				// remove any warning text if both inputs are entered
				warningLabel.setText("");
				// set the coinChoice variable to the correct value in pence
				switch (coinBox.getValue()) {
				case "£2":
					coinChoice = 200;
				    break;
				case "£1":
					coinChoice = 100;
				    break;  
				case "50p":
					coinChoice = 50;
				    break;
				case "20p":
					coinChoice = 20;
				    break;
				case "10p":
					coinChoice = 10;
				    break;
				}
				// test whether the text input is an integer
				try{
					// if the text input was an integer save the value to the valueInput variable
					valueInput = Integer.parseInt(coinValueField.getText());
					// test whether the input is a valid number between the minimum and maximum
					if(valueInput >= minValue && valueInput <= maxValue) {
						// call the coinCalculator from the CoinSorter class
						resultsArea.setText(sorter.coinCalculator(valueInput, coinChoice));
						// reset valueInput to an invalid number in case this method is used again
						valueInput = -999;
					} else {
						warningLabel.setText("You must enter a value between " + minValue + "p and " + maxValue + "p");
					}
				// if the text input wasn't an integer return a warning 	
				}catch (NumberFormatException ex) {
					warningLabel.setText("You must enter an integer for the exchange value");
				}
			}
		});
		
		// run multiple coin calculation button 
		multiCalcRunButton.setOnAction (e -> {
			// temporary values for the input value and coin choice
			int valueInput;
			int coinChoice = 0;
			// get the current minimum and maximum
			int minValue = sorter.getMinCoinIn();
			int maxValue = sorter.getMaxCoinIn();
			// check that inputs have been made
			if(multiValueField.getText().isEmpty() || multiCoinBox.getValue() == "Choose excluded coin")
			{
				// display warning if either input is empty
				warningLabel.setText("You must enter an exchange value and select a coin type to exclude");
			} else {
				// remove any warning text if both inputs are entered
				warningLabel.setText("");
				// set the coinChoice variable to the correct value in pence
				switch (multiCoinBox.getValue()) {
				case "£2":
					coinChoice = 200;
				    break;
				case "£1":
					coinChoice = 100;
				    break;  
				case "50p":
					coinChoice = 50;
				    break;
				case "20p":
					coinChoice = 20;
				    break;
				case "10p":
					coinChoice = 10;
				    break;
				}
				// test whether the text input is an integer
				try{
					// if the text input was an integer save the value to the valueInput variable
					valueInput = Integer.parseInt(multiValueField.getText());
					// test whether the input is a valid number between the minimum and maximum
					if(valueInput >= minValue && valueInput <= maxValue) {
						// call the coinCalculator from the CoinSorter class
						resultsArea.setText(sorter.multiCoinCalculator(valueInput, coinChoice));
						// reset valueInput to an invalid number in case this method is used again
						valueInput = -999;
					} else {
						warningLabel.setText("You must enter a value between " + minValue + "p and " + maxValue + "p");
					}
				// if the text input wasn't an integer return a warning 	
				}catch (NumberFormatException ex) {
					warningLabel.setText("You must enter an integer for the exchange value");
				}
			}
		});
		
		// run set currency button
		currencyRunButton.setOnAction (e -> {
			// create a temporary String to hold the currency input
	    	String newCurrency = "";
	    	// check that an input has been made and that it isn't numeric
	    	if(currencyField.getText().isEmpty()) {
	    		// display warning if input is empty
				warningLabel.setText("You must enter a new currency");
	    	// check that input is a string
	    	} else {
	    		newCurrency = currencyField.getText();
	    		// check that the user input isn't a number 
	    		if (!newCurrency.matches("-?\\d+(\\.\\d+)?")) {
	    			// if it passes validation, set the currency 
	    			sorter.setCurrency(newCurrency);
	    			// clear any warning and print update
	    			warningLabel.setText("");
	    			resultsArea.setText("Currency set to: " + sorter.getCurrency());
	    		} else {
	    			// if it fails validation print warning
	    			warningLabel.setText("You entered an invalid currency. Please try again.");
	    		}
	    	}
		});

		// run set minimum button
		minimumRunButton.setOnAction (e -> {
			int newMinimum;
			// get the current minimum and maximum
			int maxValue = sorter.getMaxCoinIn();
			if(minimumField.getText().isEmpty())
			{
				warningLabel.setText("You must enter a new minimum value");
			} else {
				try{
					// if the text input was an integer save the value to the newMinimum variable
					newMinimum = Integer.parseInt(minimumField.getText());
					// test whether the input is a valid number zero and the maximum
					if(newMinimum >= 0 && newMinimum < maxValue) {
						// call the coinCalculator from the CoinSorter class
						sorter.setMinCoinIn(newMinimum);
						resultsArea.setText("Minimum input set to: " + newMinimum + "p");
						// reset warning
						warningLabel.setText("");
						// reset newMinimum to an invalid number in case this method is used again
						newMinimum = -999;
					} else {
						warningLabel.setText("You must enter a value between zero and " + (maxValue -1) + "p");
					}
				// if the text input wasn't an integer return a warning 	
				}catch (NumberFormatException ex) {
					warningLabel.setText("You must enter an integer for the new value");
				}
			}
		});
		
		// run set maximum button
		maximumRunButton.setOnAction (e -> {
			int newMaximum;
			// get the current minimum and maximum
			int minValue = sorter.getMinCoinIn();
			if(maximumField.getText().isEmpty())
			{
				warningLabel.setText("You must enter a new maximum value");
			} else {
				try{
					// if the text input was an integer save the value to the newMaximum variable
					newMaximum = Integer.parseInt(maximumField.getText());
					// test whether the input is a valid number that is greater than the current minimum
					if(newMaximum > minValue) {
						// call the coinCalculator from the CoinSorter class
						sorter.setMaxCoinIn(newMaximum);
						resultsArea.setText("Maximum input set to: " + newMaximum + "p");
						// reset warning
						warningLabel.setText("");
						// reset newMinimum to an invalid number in case this method is used again
						newMaximum = -999;
					} else {
						warningLabel.setText("You must enter a value greater than " + minValue + "p");
					}
				// if the text input wasn't an integer return a warning 	
				}catch (NumberFormatException ex) {
					warningLabel.setText("You must enter an integer for the new value");
				}
			}
		});
		
		
		// create and configure a root HBox
		VBox root = new VBox(20); root.setBackground(Background.EMPTY); root.setAlignment(Pos.TOP_CENTER);
		// add the "previous" button, the stack of cards and the "next" button
		root.getChildren().addAll(menuStack, actionsStack, warningLabel, resultsArea);	
		
        // create a new scene
        Scene scene = new Scene(root);
        
        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Coin counter");
        stage.setWidth(700);
        stage.setHeight(600);
        stage.show();  
	}
	
	// helper to set the correct action card stack pane
	private void setActionCard(int indexIn) 
	{
		// loop through and check the index
		for (int i=0; i<=5; i++) {
			if (i == indexIn) {
				// set visibility to true for selected pane
				actionsStack.getChildren().get(i).setVisible(true);
			} else {
				// set visibility to false for all other panes
				actionsStack.getChildren().get(i).setVisible(false);
			}
		}
	}
	
	// define the helper method for the main menu button setDetailsButton
	private void subMenu() 
	{
		// hide the main menu card 
		menuStack.getChildren().get(0).setVisible(false);
		// show the sub menu card 
		menuStack.getChildren().get(1).setVisible(true);	
	}
	
	// define the helper method for the sub menu backToMainButton
	private void mainMenu() 
	{
		// hide the main menu card 
		menuStack.getChildren().get(0).setVisible(true);
		// show the sub menu card 
		menuStack.getChildren().get(1).setVisible(false);
		// show actions default
	}
	
	// define the helper method for the main menu button quitButton
	private void quitProgram()
	{
		System.exit(0);
	}
}
