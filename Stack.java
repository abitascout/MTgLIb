
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
}
