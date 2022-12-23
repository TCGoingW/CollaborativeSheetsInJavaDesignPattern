package java_collaborativeSheet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//limited 只能一個運算元，運算員跟數字要黏一起，可以共同編輯但有各自edit模式

public class demo {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	String userName, sheetName;
    	String junk;
    	
    	// store users in main
    	HashMap<String, User> users = new HashMap<String, User>();
    	
    	while(true)
    	{
    		System.out.print(
    				"---------------Menu---------------\n" + 
    				"1. Create a user.\n" +
    				"2. Create a sheet.\n" +
    				"3. Check a sheet.\n" +
    				"4. Change a value in a sheet.\n" +
    				"5. Change a sheet's access right.\n" +
    				"6. Collaborate with an other user.\n" +
    				"----------------------------------\n");
    		
    		int commandNum = scanner.nextInt();
    		if(commandNum == 1)// create user
    		{   			
    			userName = scanner.next();
    			// create user object
    			User user = new User();
    			user.setName(userName);
    			// store user in users in main hashMap
    			users.put(userName, user);
    			
    			System.out.println("Create a user named \"" + user.name + "\".");
    		}
    		else if(commandNum == 2)// create sheet
    		{
    			userName = scanner.next();
    			sheetName = scanner.next();
    			// check the user exist in local main hashMap
    			if(users.get(userName).name.equals(userName))
    			{
    				//found the direct user to createSheet
    				users.get(userName).createSheet(sheetName);
    			}
    			else
    			{
    				System.out.println("Cannot find the user.");
    				continue;
    			}
    			System.out.println("Create a sheet named \"" + users.get(userName).sheet.name + "\" for \"" + users.get(userName).name + "\"");
    		}
    		else if(commandNum == 3)// check sheet
    		{
    			userName = scanner.next();
    			sheetName = scanner.next();
    			// check the user exist in local main hashMap
    			if(users.get(userName).name.equals(userName))
    			{
    				// check the sheet exist in user
    				if(users.get(userName).sheet.name.equals(sheetName))
    					users.get(userName).sheet.state.printSheet();
    				else
    					System.out.println("Cannot find the user's sheet.");
    			}
    			else
    			{
    				System.out.println("Cannot find the user.");
    				continue;
    			}
    		}
    		else if(commandNum == 4)// edit a value in sheet
    		{
    			userName = scanner.next();
    			sheetName = scanner.next();
    			
    			// check the user exist in local main hashMap
    			if(users.get(userName).name.equals(userName))
    			{
    				// print sheet
    				users.get(userName).sheet.state.printSheet();
    				
    				// read string and split
    				junk = scanner.nextLine();
    				String editString = new String();
    				editString = scanner.nextLine();
    				StringTokenizer st = new StringTokenizer(editString, " ");
    				String [] editSplitString = new String[3];
    				int t = 0;
    				while(st.hasMoreTokens())
    					editSplitString[t++] = st.nextToken();
    				// put split string into edit function
    				users.get(userName).editSheet(userName, sheetName, editSplitString);
    			}
    			else
    			{
    				System.out.println("Cannot find the user.");
    				continue;
    			}
    		}
    		else if(commandNum == 5) // change sheet permission
    		{
    			userName = scanner.next();
    			sheetName = scanner.next();
    			// read permission mode
    			String sheetPermission = scanner.next();
    			// check the user exist in local main storage
    			if(users.get(userName).name.equals(userName))
    			{	// change the sheet state a.k.a permission
    				users.get(userName).sheet.setState(sheetPermission);
    			}
    			else
    			{
    				System.out.println("Cannot find the user.");
    				continue;
    			}
    		}
    		else if(commandNum == 6)
    		{
    			userName = scanner.next();
    			sheetName = scanner.next();
    			// create new user
    			User newUser = new User();
    			// set user
    			newUser.setName(scanner.next());
    			// set sheet
    			newUser.setSheet(sheetName);
    			// duplicate sheet array
    			newUser.sheet.array = users.get(userName).sheet.array;
    			// store user in users in main hashMap
    			users.put(newUser.name, newUser);
    			// add sheet's user list
    			users.get(userName).sheet.add(newUser.name, newUser);
    			System.out.println("Share \"" + userName  + "\"'s \"" + sheetName + "\" with \"" + newUser.name + "\" .");
    		}
    		else
    		{
    			System.out.println("Unexpected command.");
    		}
    	}
    }
}


