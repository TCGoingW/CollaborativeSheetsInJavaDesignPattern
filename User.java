package java_collaborativeSheet;

public class User implements Observer{
	String name;
	Sheet sheet;

	public User(){}
	
	public void setSheet(String sheetName)
	{
		sheet = new Sheet(sheetName);
	}
	
	// constructor to set user name and permission
	public void setName(String userName)
	{
		this.name = userName;
	}
	
	public void createSheet(String sheetName)
	{
		sheet = new Sheet(sheetName);
		// call the sheet's function add()
		sheet.add(this.name, this);
	}
	
	
	public void editSheet(String userName, String sheetName, String[] editSplitString)
	{
		if(sheet.name.equals(sheetName))
		{
			sheet.state.editSheet(userName, sheetName, editSplitString);
		}
		else
		{
			System.out.println("Cannot find the user's sheet.");
		}
	}
	
	@Override
	public void update(double[][] arr)
	{
		sheet.array = arr;
	}
}
