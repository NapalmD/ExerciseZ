import java.util.List;
import java.util.ArrayList;

public class Controller {

	public static void main(String[] args) throws Exception
	{
		View V= new View();
		Model M= new Model();
		Controller C= new Controller();
		C.cmdlistfill();
		V.newcommand(C,V,M);
		
	}

	private static List<String> CmdList=new ArrayList<String>();
	
	public void cmdlistfill()
	{
		CmdList.add("add");
		CmdList.add("remove");
		CmdList.add("show");
		CmdList.add("showall");
		CmdList.add("help");
		CmdList.add("find");
	}
		
	public void command (String CMD, Controller C,View V,Model M)throws Exception
	{
		checkCommand(CMD);
		if (CMD.equals("add"))
		{
			add(C,V,M);
		}
		else if (CMD.equals("show"))
		{
			show(C,V,M);
		}
		else if (CMD.equals("showall"))
		{
			showall(C,V,M);
		}
		else if (CMD.equals("help"))
		{
			help(C,V,M);
		}
		else if (CMD.equals("remove"))
		{
		remove(C,V,M);
		}
		else if (CMD.equals("find"))
		{
		find(C,V,M);
		}
		else
		{
			throw new Exception("Wrong command Occured");
		}
		
	}
	
	
	public void add(Controller C,View V,Model M) throws Exception
	{
		Name=V.ask("Name:");
		checkName(Name);
		Surname=V.ask("Surname:");
		checkName(Surname);
		Address=V.ask("Address:");
		checkAddress(Address);
		Phone=V.ask("Phone:");
		checkPhone(Phone);
		boolean s=M.PBadd(Name,Surname,Address,Phone);
		if (s)
		{
			V.showresult("Succesfully Added", true, C,V,M);
		}
		else
		{
//			Name=V.ask("Overwrite "+M.show(Name, Surname)+" (y/n)?");
//			if ((Name.toLowerCase()).equals("y"))
//				{
//					result="Address(a), phone(p), or both:";
//				}
//			else
//			{
//				V.showresult("", true, C,V,M);
//			}
//			
//			
//			Name=V.ask(result);
//			
			V.showresult("Unable to Add", true, C,V,M);
		}
		
	}
	
	public void remove(Controller C,View V,Model M) throws Exception
	{
		Criteria=V.ask("Remove by Name or Surname:");
		boolean s=false;
		int I=1;
		if ((Criteria.toLowerCase()).equals("name"))
		{
		}
		else if ((Criteria.toLowerCase()).equals("surname"))
		{
			I=2;
		}
		else
		{
			throw new Exception("wrong words were typed");
		}
		Name=V.ask("Who to remove:");
		s=M.RemovePB(Name,I);
		if (s)
		{
			result="Succesfully removed";
		}
		else
		{
			result="Haven't found guy to delete";
		}
		V.showresult(result, true, C, V, M);
		
	}

	public void showall(Controller C,View V,Model M) throws Exception
	{
		String[] result=M.showPBAll();
		if (result.length>5)
		{
			String[] finalresult= new String[6];
			finalresult[0]="Too many Guys, gonna show you 5:";
			for(int i=1; i<6; i++)
			{
				finalresult[i]=result[i-1];
			}
			V.showresult(finalresult,true,C,V,M);
		}
		V.showresult(result,true,C,V,M);
		
		
		
	}
	
	public void show(Controller C,View V,Model M) throws Exception
	{	
		String Criteria=V.ask("Remove by Name or Surname:");
		int I=1;
		if ((Criteria.toLowerCase()).equals("name"))
		{
		}
		else if ((Criteria.toLowerCase()).equals("surname"))
		{
			I=2;
		}
		else
		{
			throw new Exception("wrong words were typed");
		}
		Name=V.ask("Who to look:");
		result=M.show(Name, I);
		V.showresult(result, true, C, V, M);
		
	}

	public void find(Controller C,View V,Model M) throws Exception
	{
		Criteria=V.ask("Serach by Name, Surname, Address or Phone?:");
		int I=1;
		if ((Criteria.toLowerCase()).equals("name"))
		{
		}
		else if ((Criteria.toLowerCase()).equals("surname"))
		{
			I=2;
		}
		else if ((Criteria.toLowerCase()).equals("address"))
		{
			I=3;
		}
		else if ((Criteria.toLowerCase()).equals("phone"))
		{
			I=4;
		}
		else
		{
			throw new Exception("wrong words were typed");
		}
		Name=V.ask("What to search:");
		String[] result=M.find(Name,I);
		if (result.length>5)
		{
			String[] finalresult= new String[6];
			finalresult[0]="Too many Guys, gonna show you 5:";
			for(int i=1; i<6; i++)
			{
				finalresult[i]=result[i-1];
			}
			V.showresult(finalresult,true,C,V,M);
		}
		V.showresult(result,true,C,V,M);		
	}
	
	public void help(Controller C,View V,Model M) throws Exception
	{
		Object[] ComList=CmdList.toArray();
		V.showresult("Command List:",false,C,V,M);
		for(Object comcurrent: ComList)
		{
			V.showresult(comcurrent.toString(),false,C,V,M);
		}
		V.showresult("",true,C,V,M);
	}

	

	
	public void checkCommand(String command) throws Exception
	{
		if (CmdList.contains(command)==false)
		{
			throw new Exception("Wrong Command");
			}
	}
	public boolean checkName(String Acc) throws Exception
	{
		boolean checkName=false;	
		int b=0;
		boolean b1;
		boolean b2;
		boolean b3;
		for (int i=0; i<Acc.length(); i++)
		{
				b=(int)Acc.charAt(i);
				b1=(b>=97)&(b<=122);
				b2=(b>=65)&(b<=90);
				b3=(b==95);
				if ((b1|b2|b3)==false)
						{throw new Exception("Wrong Name");}
		}
		checkName=true;
		return checkName;
	}
	public boolean checkPhone(String Phone) throws Exception
	{
	boolean checkName=false;	
	int b=0;
	boolean b1;
	boolean b2;
	b=(int)Phone.charAt(0);
	b1=(b==43);
	b2=(b>=48)&(b<=57);
	if ((b1|b2)==false) {throw new Exception("Wrong Phone");}
	for (int i=1; i<Phone.length(); i++)
	{
			b=(int)Phone.charAt(i);
			b2=(b>=48)&(b<=57);
			if (b2==false)
					{throw new Exception("Wrong Phone");}
	}
	checkName=true;
	return checkName;
	}
	public boolean checkAddress(String A) throws Exception
	{
	boolean checkAddress=false;	
	int b=0;
	boolean b1,b2,b3,b4;
	for (int i=0; i<A.length(); i++)
	{
			b=(int)A.charAt(i);
//			English letters a-z, A-z
			b1=(b>=97)&(b<=122);
			b2=(b>=65)&(b<=90);
//			"_",".","-"," "
			b3=(b==95)|(b==46)|(b==45)|(b==32);
//			Digits 0-9
			b4=(b>=48)&(b<=57);
			if ((b1|b2|b3|b4)==false)
					{throw new Exception("Wrong Adress");}
	}
	checkAddress=true;
	return checkAddress;
	}

	String Name;
	String Surname;
	String Address;
	String Phone;
	String Criteria;
	String result;
		
}
