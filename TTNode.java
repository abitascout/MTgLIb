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
	//recursively adds to a subtree
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
	//new values are always added to a leaf. the result may be a 4-node leaf.
	public boolean addToLeaf(Type x)
	{
		int cmp;
		//size is 1 for a 2 node, or 2 for a 3 node
		for(int i = 0; i < this.Data.GetSize(); i++)
		{
			cmp = x.toString().compareTo(this.Data.GetValue().toString());
			if (cmp == 0)
			{
				return false;
			}
			else if(cmp < 0)
			{
				this.Data.SetPos(i);
				this.Data.InsertAfter(x);
				return true;
			}
			this.Data.Next();
		}
		this.Data.InsertAfter(x);
		return true;
	}
	//adds a value to a subtree. if the addition results in a 4-node then adjustments are made.
	boolean addToInterior(Type x)
	{
		int cmp;
		//size 1 = 2-node size 2 = 3 node
		for(int i = 0; i<=this.Data.GetSize(); i++)
		{
			if(i == this.Data.GetSize())
			{
				cmp = -1; //because there is no Data[2]
			}
			else
			{
				this.Data.SetPos(i);
				cmp = x.toString().compareTo(this.Data.GetValue().toString());
			}
			if(cmp == 0)
			{
				return false;
			}
			else if(cmp < 0)
			{
				this.Children.SetPos(i);
				this.Children.GetValue().InsertAfter(x);
				boolean retVal = 
				if(Children.GetValue().is4Node())
				{
					childIs4Node(i);
				}
				return retVal;
			}
		}
		return false; //unreachable but compiler complains
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
