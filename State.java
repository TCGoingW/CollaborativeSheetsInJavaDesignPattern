package java_collaborativeSheet;

public interface State {
	public void editSheet(String userName, String sheetName, String[] editSplitString);
	public void printSheet();
}
