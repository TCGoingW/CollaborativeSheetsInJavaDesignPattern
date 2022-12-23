package java_collaborativeSheet;

import java.util.StringTokenizer;

public class editable implements State{
	Sheet sheet;
	String stateName;
	
	public editable(Sheet sheet)
	{
		this.sheet = sheet;
		this.sheet.state = this;
		this.stateName = "Editable";
	}
	
	@Override
	public void editSheet(String userName, String sheetName, String[] editSplitString)
	{
		double[] editSplitDouble = new double[3];
		double sum = 0;
		editSplitDouble[0] = Double.parseDouble(editSplitString[0]);
		editSplitDouble[1] = Double.parseDouble(editSplitString[1]);
		
		if(editSplitString[2].contains("+"))
		{
			StringTokenizer st = new StringTokenizer(editSplitString[2], "+");
			sum += Double.parseDouble(st.nextToken());
			sum += Double.parseDouble(st.nextToken());
			editSplitDouble[2] = sum;
		}
		else if(editSplitString[2].contains("-"))
		{
			StringTokenizer st = new StringTokenizer(editSplitString[2], "-");
			sum += Double.parseDouble(st.nextToken());
			sum -= Double.parseDouble(st.nextToken());
			editSplitDouble[2] = sum;
		}
		else if(editSplitString[2].contains("*"))
		{
			StringTokenizer st = new StringTokenizer(editSplitString[2], "*");
			sum += Double.parseDouble(st.nextToken());
			sum *= Double.parseDouble(st.nextToken());
			editSplitDouble[2] = sum;
		}
		else if(editSplitString[2].contains("/"))
		{
			StringTokenizer st = new StringTokenizer(editSplitString[2], "/");
			sum += Double.parseDouble(st.nextToken());
			sum /= Double.parseDouble(st.nextToken());
			editSplitDouble[2] = sum;
		}
		else
		{
			editSplitDouble[2] = Double.parseDouble(editSplitString[2]);
		}
		sheet.array[(int)editSplitDouble[0]][(int)editSplitDouble[1]] = editSplitDouble[2];
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
