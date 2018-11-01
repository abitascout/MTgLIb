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
	
	// this is far as I have gotten without doing som research
	
}