public class 2-3tree<Type>
{
	
	private 2-3Node<Type> root;
	// constructor
	// empty list has a size of -1 and its position is at -1
	public List()
	{
		this.root = null;
	}
	// copy constructor
	// clones the list l 
	public List(2-3tree<Type> l)
	{
		Node<Type> n = l.root;
		this.root = null;
	}
	
	// this is far as I have gotten without doing som research
	
}