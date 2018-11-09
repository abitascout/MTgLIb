
/**
 * Write a description of class Queue here.
 *
 * @author Matthew Gerber
 * @date 10/18/2018
 */
//suppresswarnings so IDE doesn't complain
public class Queue<Type> extends List<Type>
{
    // instance variables - replace the example below with your own
    public void Enqueue(Type data)
    {
        super.Last();
        super.InsertAfter(data);
    }
    public void Dequeue()
    {
        super.First();
        super.Remove();
    }
    public String toString()
    {
    	super.First();
    	String output = "";
    	for(int i = 0; i < super.GetSize(); i++)
    	{
    		output += super.GetValue();
    		super.Next();
    		
    	}
    	super.First();
    	return output;
    }

}
