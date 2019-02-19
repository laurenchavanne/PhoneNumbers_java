// Filename: PhoneNumbers.java
// Author: Lauren
// Date: 2/11/19
// Application that serves as a phone directory for first names and phone numbers for up to 30 people. Application will prompt the user for a name, if the name matches the directory, the corresponding phone number will display. If no match is found, the user can enter the new name and number into the directory. User should be able to QUIT at any time.

import javax.swing.JOptionPane;

public class PhoneNumbers
{
	public static void main(String[] args)
	{
		// variables and constants
		String[] names = new String[30];
		names[0] = "Tom"; names[1] = "Kacy";
		names[2] = "Lauren"; names[3] = "John";
		names[4] = "Mike"; names[5] = "Jane";
		names[6] = "Megan"; names[7] = "Sarah";
		names[8] = "Chris"; names[9] = "David";
		
		String[] numbers = new String[30];
		numbers[0] = "(516)111-3212"; numbers[1] = "(526)222-4678";
		numbers[2] = "(516)333-5982"; numbers[3] = "(516)444-9825";
		numbers[4] = "(800)555-0917"; numbers[5] = "(800)666-1911";
		numbers[6] = "(800)777-7300"; numbers[7] = "(516)888-4826";
		numbers[8] = "(517)999-6789"; numbers[9] = "(517)000-1456";
		
		String entryName; // Name the user will be entering 
		String entryPhone; // New phone numbers the user will enter 
		boolean isMatch = false;
		int highestIndex = 10;
		final String QUIT = "QUIT";
		
		entryName = JOptionPane.showInputDialog(null, "Please enter a name to look up, or type " + QUIT + " to quit the program.");
		
		// While the user does not enter QUIT or we still have space in the array, enter the loop body. Otherwise skip to the end.
		while(highestIndex < 30 && !entryName.equalsIgnoreCase(QUIT))
		{
			// Loop through the existing names and see if there is a match 
			for(int x = 0; x < highestIndex; x++)
			{
				if(entryName.equalsIgnoreCase(names[x]))
				{
					isMatch = true;
					JOptionPane.showMessageDialog(null, "The phone number for " + names[x] + " is: " + numbers[x]);
					x = highestIndex;
				}
			} // End of the for loop that checks names 
			
			// Test the boolean of isMatch now that the loop is done
			if(isMatch == false)
			{
				// No match was found, have the user enter a number for the name they tried to put in
				entryPhone = JOptionPane.showInputDialog(null, "Could not find " + entryName + "\nPlease enter a phone number to add " + entryName + "to the directory.");
				names[highestIndex] = entryName;
				numbers[highestIndex] = entryPhone;
				highestIndex++;
			}
			
			// Regardless if there is a match or not, display the original dialog box prompt and then enter the while loop again
			entryName = JOptionPane.showInputDialog(null, "Please enter a name to look up, or type " + QUIT + " to quit the program.");
			isMatch = false; // Resets the boolean before it loops again
			
		}
		
		// End of program messages go here
		if(highestIndex == 30)
		{
			JOptionPane.showMessageDialog(null, "Directory is full, thank you for using this program.");
		}
		else
		{
			if(entryName.equalsIgnoreCase(QUIT))
			{
				JOptionPane.showMessageDialog(null, "Exiting program...");	
			}
		}
	}
}

