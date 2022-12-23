package java_collaborativeSheet;

public class readOnly implements State{
	Sheet sheet;
	String stateName;
	
	public readOnly(Sheet sheet)
	{
		this.sheet = sheet;
		this.sheet.state = this;
		this.stateName = "ReadOnly";
	}
	
	@Override
    public void editSheet(String userName, String sheetName, String[] editSplitString) 
	{
		System.out.println("This sheet is not accessible");
		this.printSheet();
    }
	
	@Override
	public void printSheet()
	{
		for(int i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 3; ++j)
			{
				System.out.print(" " + sheet.array[i][j]);
			}
			System.out.println();
		}
	}
}
