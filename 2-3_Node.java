public class 2-3_Node
{
	private Type data;
	private Node<Type> link;
	
	// constructor
	public Node()
	{
		this.data = null;
		this.link = null;
	}
	
	// acccessor and mutator for the data 
	public void set_rightData(Type data)
	{
		this.data = data;
	}
	public Type get_rightData()
	{
		return this.data;
	}
	public void set_leftData(Type data)
	{
		this.data = data;
	}
	public Type get_leftData()
	{
		return this.data;
	}
	
	// accessor and mutator for the link
	public void set_leftLink(Node<Type> link)
	{
		this.link = link;
	}
	public Node<Type> get_leftLink()
	{
		return this.link;
	}
	public void set_rightLink(Node<Type> link)
	{
		this.link = link;
	}
	public Node<Type> get_rightLink()
	{
		return this.link;
	}
	public void set_middleLink(Node<Type> link)
	{
		this.link = link;
	}
	public Node<Type> get_middle()
	{
		return this.link;
	}
}