import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model 
{
	private Map<Human,AddressPhone> PB=new HashMap<Human, AddressPhone>();
	private String result;
	

	public boolean PBadd(String n, String sn, String a, String p)throws Exception
	{
		PBM P=new PBM();
		return P.AddPB(n, sn, a, p);
	}
	public boolean RemovePB(String Name, int I) throws Exception
	{
		PBM P=new PBM();
		Set<Human> SH=P.showPBAll();
		boolean DONE=false;
		if (I==1)
		{
			for (Human HC: SH)
			{
				if ((HC.getName()).equals(Name))
				{
					P.RemovePB(HC);
					DONE=true;
					break;
				}
			}
		}
		else if (I==2)
		{
			for (Human HC: SH)
			{
				if ((HC.getSurname()).equals(Name))
				{
					P.RemovePB(HC);
					DONE=true;
					break;
				}
			}
		}
		return DONE;
		
	}
	public String[] showPBAll() throws Exception
	{
		PBM P=new PBM();
		Set<Human> SH=P.showPBAll();
		String[] ANS=new String[SH.size()];
		if (ANS.length==0)
		{
			String[] ANS1=new String[1];
			ANS1[0]="Phonebook is Empty";
			return ANS1;
		}
		else
		{
			int i=0;
			for (Human HC: SH)
			{
				ANS[i]=HC.getFullName();
				i++;
			}
		}
		return ANS;
	}
	public String show(String Whom, int I)  throws Exception
	{
		PBM P = new PBM();
		Set<Human> SH=P.showPBAll();
		result="None found";
		if (I==1)
		{
			for (Human HC: SH)
			{
				if ((HC.getName()).equals(Whom))
				{
					result=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
					break;
				}
			}
		}
		else if (I==2)
		{
			for (Human HC: SH)
			{
				if ((HC.getSurname()).equals(Whom))
				{
					result=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
					break;
				}
			}
		}
		return result;
	}
	
	public String show(String aName, String aSN)  throws Exception
	{
		Human Current=new Human(aName,aSN);
		return Current.getFullName()+" "+(PB.get(Current)).getAddressPhone(); 
	}
	public String[] find(String What, int I) throws Exception
	{
		PBM P=new PBM();
		Set<Human> SH=P.showPBAll();
		String[] ANS= new String[PB.size()];
		int i=0;
		if ((I==1)|(I==2))
		{
			if (I==1)
			{
				for (Human HC: SH)
				{
					if ((HC.getName()).contains(What))
					{
						ANS[i]=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
						i++;		
					}
				}
			}
			else if (I==2)
			{
				for (Human HC: SH)
				{
					if ((HC.getSurname()).contains(What))
					{
						ANS[i]=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
						i++;
					}
				}
			}
		}
		else if ((I==3)|(I==4))
		{
			if (I==3)
			{
				for (Human HC: SH)
				{
					if (((P.showPB1(HC)).getAddress()).contains(What))
					{
						ANS[i]=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
						i++;
					}
				}
			}
			else if (I==4)
			{
				for (Human HC: SH)
				{
					if (((P.showPB1(HC)).getPhone()).contains(What))
					{
						ANS[i]=HC.getFullName()+" "+(P.showPB1(HC)).getAddressPhone();
						i++;
					}
				}
			}
		}
		else
		{
			throw new Exception("Hacker Detected");
		}
		return ANS;
	}
	
	
class PBM
{
	public PBM()
	{}
	public boolean AddPB(String n, String sn, String a, String p)
	{
		Human HToAdd= new Human(n,sn);
		AddressPhone APToADD= new  AddressPhone(a,p);
		if (PB.containsKey(HToAdd)==false)
		{
			PB.put(HToAdd, APToADD);
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	public boolean RemovePB(Human aObj)
	{
		
		if (PB.containsKey(aObj))
		{
			PB.remove(aObj);
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public AddressPhone showPB1(Human aObj)
	{
		return (PB.get(aObj));
	}

	public Set<Human> showPBAll() throws Exception
	{
		return PB.keySet();
	}
	
	public void lookphone(Human Name) throws Exception
	{
		if (PB.containsKey(Name))
		{
			AddressPhone APH= PB.get(Name);
			result="Found Phone of "+Name.getFullName()+": "+APH.getPhone();
		}
		else
		{
			result="Not Found ";
		}
//		View.showresult(result,true);
	}
}
class Human
{
	public Human()
	{
	}
	public Human(String aName) 
	{
		Name=aName;
	}	
	public Human(String aName, String aSurname) 
	{
		Name=aName;
		Surname=aSurname;
	}
	
	public String getSurname()
	{
		return Surname;
	}
	public String getFullName()
	{
		return Name+" "+Surname;
	}
	public String getName()
	{
		return Name;
	}
	private String Name="";
	private String Surname="";
}

class AddressPhone
{
	public AddressPhone(String aAd, String aPh)
	{
		Address=aAd;
		Phone=aPh;
	}
	public AddressPhone(String aPh)
	{
		Phone=aPh;
	}
	public String getPhone()
	{
		return Phone;
	}
	public String getAddress()
	{
		return Address;
	}
	public String getAddressPhone()
	{
		return Address+" "+Phone;
	}
	private String Address="n/a";
	private String Phone="";
}
}

