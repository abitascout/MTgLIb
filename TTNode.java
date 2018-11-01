public class TTNode<Type>
{
	private Type Ldata,Rdata;
	private TTNode<Type> Llink,Mlink,Rlink;
	
	// constructor
	public TTNode()
	{
		this.Ldata = this.Rdata = null;
		this.Llink = this.Rlink = null;
	}
	
	// accessor and mutator for the data 
	public void set_rightData(Type data)
	{
		this.Rdata = data;
	}
	public Type get_rightData()
	{
		return this.Rdata;
	}
	public void set_leftData(Type data)
	{
		this.Ldata = data;
	}
	public Type get_leftData()
	{
		return this.Ldata;
	}
	
	// accessor and mutator for the link
	public void set_leftLink(TTNode<Type> link)
	{
		this.Llink = link;
	}
	public TTNode<Type> get_leftLink()
	{
		return this.Llink;
	}
	public void set_rightLink(TTNode<Type> link)
	{
		this.Rlink = link;
	}
	public TTNode<Type> get_rightLink()
	{
		return this.Rlink;
	}
	public void set_middleLink(TTNode<Type> link)
	{
		this.Mlink = link;
	}
	public TTNode<Type> get_middle()
	{
		return this.Mlink;
	}
}
