public class TTNode<Type>
{
	private List<Type> Data;
	private List<TTNode<Type>> Children;
	
	// constructor
	public TTNode(Type x)
	{
		this.Data.InsertAfter(x);
	}
	public TTNode(Type x, TTNode<Type> left, TTNode<Type> right)
	{
		this.Data.InsertAfter(x);
		this.Children.InsertAfter(left);
		this.Children.InsertAfter(right);
		this.Children.InsertAfter(null);
	}
	public String toString()
	{
		this.Data.First();
		String answer = "[";
		for (int i = 0; i < this.Data.GetSize(); i++)
		{
			if(i != 0)
			{
				answer += ", ";
			}
			if(this.Children.GetSize() != 0)
			{
				answer += this.Children.GetValue();
			}
			answer += this.Data.GetValue();
			this.Data.Next();
		}
		if(this.Children.GetSize() != 0)
		{
			int pos = this.Children.GetPos() - 2;
			this.Children.SetPos(pos);
			answer += this.Children.GetValue();
		}
		return answer + "]";
	}
	public void getVals(List<Type> iteratorList)
	{
		this.Data.First();
		this.Children.First();
		for (int i = 0; i < this.Data.GetSize(); i++)
		{
			if(this.Children.GetSize() != 0)
			{
				this.Children.GetValue().getVals(iteratorList);
				this.Children.Next();
			}
			iteratorList.InsertAfter(this.Data.GetValue());
			this.Data.Next();	
		}
		if (this.Children.GetSize() != 0)
		{
			int pos = (this.Children.GetPos() -2);
			this.Children.SetPos(pos);
			this.Children.GetValue().getVals(iteratorList);
		}
	}
	public boolean add(Type x)
	{
		if(isLeaf())
		{
			return addToLeaf(x);
		}
		else
		{
			return addToInterior(x);
		}
	}
	public boolean addToLeaf(Card x)
	{
		int cmp;
		//size is 1 for a 2 node, or 2 for a 3 node
		for(int i = 0; i < this.Data.GetSize(); i++)
		{
			cmp = x.toString().compareTo(this.Data.GetValue().toString());
			
		}
	}
	}
	//boolean functions
	public boolean isLeaf()
	{
		return Children.GetSize() == 0;
	}
	public boolean is4Node()
	{
		return Data.GetSize() == 3;
	}
	
	// accessor and mutator for the data 
	
	
	
	// accessor and mutator for the link
	
}
