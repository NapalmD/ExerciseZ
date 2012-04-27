import java.io.Console;

public class View
{

	public void showresult(String Result, boolean newcom, Controller C,View V,Model M) throws Exception
	{
		System.out.println(Result);
		if (newcom)
		{
			newcommand(C,V,M);
		}
	}

	public void showresult(String[] Result, boolean newcom, Controller C,View V,Model M) throws Exception
	{
		for(String row: Result)
		{
			System.out.println(row);
		}
		if (newcom)
		{
			newcommand(C,V,M);
		}
	}
	public void newcommand(Controller C,View V,Model M) throws Exception
	{
		System.out.println();
		Console console = System.console();
		String args=console.readLine("Input Command: ");
		C.command(args,C,V,M);
	}
	public String ask(String aWhat)
	{
		Console console = System.console();
		String ARGS=console.readLine(aWhat);
		return ARGS;
	}
}

