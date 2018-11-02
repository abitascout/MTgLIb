public class TTtree<Type>
{
	
	private TTNode<Type> root;
	private TTNode<Type> curr;
	// constructor
	// empty list has a size of -1 and its position is at -1
	public TTtree()
	{
		this.root = null;
	}
	// copy constructor
	// clones the list l 
	public TTtree(TTtree<Type> l)
	{
		TTNode<Type> n = l.root;
		this.root = null;
	}
	//go to root
	public void Root()
	{
		this.curr = this.root;
	}
	public void Parent()
	{
		Root();
		
	}
	//move left
	public void Left()
	{
		this.curr = this.curr.get_leftLink();
	}
	//move right
	public void Right()
	{
		this.curr = this.curr.get_rightLink();
	}
	
	// this is far as I have gotten without doing som research
	public void add(Type x)
	{
		if (root == null)
		{
			root = new TTNode<Type>();
			root.set_leftData(x);
		}
		else
		{
		}
		}
	}
}