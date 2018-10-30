
/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue<Type> extends List
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

}
