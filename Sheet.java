package java_collaborativeSheet;

import java.util.HashMap;

public class Sheet implements Subject {
	HashMap<String, User> userList = new HashMap<String, User>();
	double [][] array = new double[3][3];
	String name;
	State state;
	
	final State read = new readOnly(this);
	final State edit = new editable(this);
	
	public Sheet(String sheetName)
	{
		this.name = sheetName;
		this.state = edit;
	}
	
	public void setState(String state)
	{
		if(state.equals("ReadOnly") || state.equals("readOnly") || state.equals("readonly")) {
			this.state = read;
		} else if(state.equals("Editable") || state.equals("editable")) {
			this.state = edit;
		} else {
			System.out.println("Cannot find the user's sheet.");
		}
	}
	
    @Override
    public void add(String userName, User user) {
        userList.put(userName, user);
    }
    
    @Override
    public void notifyUser(double[][] arr)
    {
    	for(String i: userList.keySet())
    	{
    		userList.get(i).update(arr);
    	}
    }
}
