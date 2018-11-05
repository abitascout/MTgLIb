
/**
 * Write a description of class Stack here.
 *
 * @author Matthew Gerber
 * @date 10/18/2018
 */
//suppress warnings used so IDE doesn't complain
@SuppressWarnings("all")
public class Stack<Type> extends List
{
    // instance variables - replace the example below with your own
	public void Push(Type data)
    {
        super.Last();
        super.InsertAfter(data);
    }
    public void Pop()
    {
        super.Last();
        super.Remove();
    }
    public Type Peek()
    {
        super.Last();
		Type data = (Type) super.GetValue();
        return data;
    }
    public Type reversePeek()
    {
        super.First();
		Type data = (Type) super.GetValue();
        return data;
    }
    public String toString()
    {
    	super.Last();
    	String output = "";
    	try
    	{
    		for(int i = 0; i < super.GetSize(); i++)
    		{
    			output += super.GetValue()+"\n";
    			super.Prev();
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Something broke somehow.");
    	}
    	return output;
    }
}
