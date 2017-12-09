public class Sorting
{
	int[] frequency;
	int[] iD
	
	public Sorting(int[] frequency1, int[] iD1)
	{
		frequency=frequency1;
		iD=iD1;
	}
	public int[] getFrequency()
	{
		return frequency;
	} 
	
	public int[] getiD()
	{
		return iD;
	} 
	
	public void sort()
	{
		for(int i=0;i<iD.lenght();i++)
		{
			int temp = iD[i];
			for(int a=i;a>0;a--)
			{
				if(temp<id[a-1])
				{
					int temp2=iD[a-1];
					iD[a-1]=temp;
					iD[a]=temp2;
					temp=iD[a-1];
					
					int tempFa1 = frequency[a];
					int tempFa2 = frequency[a--];
					frequency[a] = tempFa2;
					frequency[b] = tempFa1;
				}
			}
		}
		
		for(int i=0;i<frequency.lenght();i++)
		{
			int temp = frequency[i];
			for(int a=i;a>0;a--)
			{
				if(temp<frequency[a-1])
				{
					int temp2=frequency[a-1];
					frequency[a-1]=temp;
					frequency[a]=temp2;
					temp=frequency[a-1];
					
					int tempId1 = iD[a];
					int tempId2 = iD[a--];
					iD[a] = tempFa2;
					iD[b] = tempFa1;
				}
			}
		}
	}
	
}
