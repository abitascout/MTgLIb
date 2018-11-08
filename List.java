/* /***************************************************
 * Matthew Gerber
 * 9/26/2018
 *
 * List Class - handles any form of data
 *************************************************** */

public class List<Type>
{
    // We don't actually have to set a max size with linked lists
    // But it is a good idea.
    // Just picture an infinite loop adding to the list! :O
    public static final int MAX_SIZE = 200;

    private Node<Type> head;
    private Node<Type> tail;
    private Node<Type> curr;
    private int num_items;

    // constructor
    // remember that an empty list has a "size" of -1 and its "position" is at -1
    public List()
    {
        this.head = this.tail = this.curr = null;
        this.num_items = 0;
    }

    // copy constructor
    // clones the list l and sets the last element as the current
    public List(List<Type> l)
    {
        Node<Type> n = l.head;
        this.head = this.tail = this.curr = null;
        this.num_items = 0;

        while (n != null)
        {
            this.InsertAfter(n.getData());
            n = n.getLink();
        }
    }

    // navigates to the beginning of the list
    public void First()
    {
        try
        {
            this.curr = this.head.getLink();
        }
        catch(NullPointerException e)
        {
            ;
        }
    }

    // navigates to the end of the list
    // the end of the list is at the last valid item in the list
    public void Last()
    {
        try
        {
            this.curr = this.tail.getLink();
        }
        catch(NullPointerException e)
        {
            ;
        }
    }

    // navigates to the specified element (0-index)
    // this should not be possible for an empty list
    // this should not be possible for invalid positions
    public void SetPos(int pos)
    {
        if(pos < GetSize())
        {
            First();
            for(int x = 0; x<pos; x++)
            {
                this.curr = this.curr.getLink();
            }
        }
    }

    // navigates to the previous element
    // this should not be possible for an empty list
    // there should be no wrap-around
    public void Prev()
    {
        Node<Type> temp = this.curr;
        this.curr = this.head;
        boolean found = false;
        try
        {
            while(!found)
            {
                if(this.curr.getLink().equals(temp))
                {
                    found = true;
                }
                else
                {
                    this.Next();
                }
            }
        }
        catch(NullPointerException e)
        {
           ;
        }
    }
    
    // navigates to the next element
    // this should not be possible for an empty list
    // there should be no wrap-around
    public void Next()
    {
        if(this.curr.getLink() != null)
        {
            this.curr = this.curr.getLink();
        }
    }

    // returns the location of the current element (or -1)
    public int GetPos()
    {
        Node<Type> temp = this.curr;
        First();
        try
        {
            for(int i = 0; i<num_items;i++)
            {
                if(this.curr == temp)
                {
                    return i;
                }
                else
                {
                   this.curr = this.curr.getLink();
                }
            }
        }
        catch(NullPointerException e)
        {
            ;
        }
        return -1;
    }
    // returns the value of the current element (or -1)
    public Type GetValue()
    {
        try
        {
            return this.curr.getData();
        }
        catch(NullPointerException e)
        {
            return null;
        }
    }

    // returns the size of the list
    // size does not imply capacity
    public int GetSize()
    {
        int count = 0;
        boolean NotEnd=true;
        Node<Type> scroller = new Node<Type>();
        scroller = this.head;
        try
        {
            while(NotEnd)
            {
                if(scroller.getLink() != null)
                {
                    count++;
                    scroller = scroller.getLink();
                }
                else
                {
                    this.tail.setLink(scroller);
                    NotEnd = false;
                    num_items = count;
                    return count;
                }
            }
        }
        catch(NullPointerException e)
        {
            ;
        }
        return 0;
    }

    // inserts an item before the current element
    // the new element becomes the current
    // this should not be possible for a full list
    public void InsertBefore(Type data)
    {
        if(GetSize() != MAX_SIZE)
        {
            Prev();
            this.InsertAfter(data);
        }
    }

    // inserts an item after the current element
    // the new element becomes the current
    // this should not be possible for a full list
    public void InsertAfter(Type data)
    {
        Node<Type> newNode = new Node<Type>();
        newNode.setData(data);
        if(newNode.getData() != null)
        {
            if(GetSize() != MAX_SIZE)
            {
                if(this.head == null)
                {
                    this.head = new Node<Type>();
                    this.tail = new Node<Type>();
                    this.curr = new Node<Type>();
                    this.tail.setLink(newNode);
                    this.head.setLink(newNode);
                    this.curr = this.head.getLink();
                }
                else
                {
                    newNode.setLink(this.curr.getLink());
                    this.curr.setLink(newNode);
                    this.tail.setLink(newNode);
                    this.curr = this.curr.getLink();
                }
            }
        }
    }

    // removes the current element 
    // this should not be possible for an empty list
    public void Remove()
    {
        if(this.head.getLink() != null)
        {
            Node<Type> temp = this.curr;
            int position = this.GetPos();
            this.curr = this.head;
            for(int search = 0; search<GetSize(); search++)
            {
                if(this.curr.getLink() == temp)
                {
                    this.curr.setLink(this.curr.getLink().getLink());
                    //break;
                }
                else
                {
                    Next();
                }
            }
            if(this.curr.getLink() != null)
            {
                    this.SetPos(position);
            }
            
        }
    }

    // replaces the value of the current element with the specified value
    // this should not be possible for an empty list
    public void Replace(Type data)
    {
        if(this.head.getLink() != null)
        {
            this.curr.setData(data);
        }
    }

    // returns if the list is empty
    public boolean IsEmpty()
    {
        if(this.head.getLink() != null)
        {
            return false;
        }
        return true;
    }

    // returns if the list is full
    public boolean IsFull()
    {
        int size=GetSize();
        if(size == MAX_SIZE)
        {
            return true;
        }
        return false;
    }

    // returns if two lists are equal (by value)
    public boolean Equals(List<Type> l)
    {
        Node<Type> origin = this.head.getLink();
        Node<Type> al = l.head.getLink();
        boolean same = true;
        if(this.GetSize() == l.GetSize())
        {
            for(int i = 0; i<GetSize(); i++)
            {
                if(origin.getData() != al.getData())
                {
                    same = false;
                    break;
                }
                origin = origin.getLink();
                al = al.getLink();
            }
        }
        else
        {
            same = false;
        }
        return same;
    }

    // returns the concatenation of two lists
    // l should not be modified
    // l should be concatenated to the end of *this
    // the returned list should not exceed MAX_SIZE elements
    // the last element of the new list is the current
    public List<Type> Add(List<Type> l)
    {
            List<Type> returning = new List<Type>(this);
            Node<Type> add = null;
            Node<Type> ition = null;
            if(returning.head != null)
            {
                add = returning.tail.getLink();
            }
            else
            {
                returning.head = new Node<Type>();
                returning.tail = new Node<Type>();
            }
            if(l.head != null)
            {
                ition = l.head.getLink();
            }
            
            if(this.GetSize() <= MAX_SIZE)
            {
                if(add == null && ition != null)
                {
                    returning.head.setLink(ition);
                }
                else if(add != null && ition == null)
                {
                    ;
                }
                else
                {
                    add.setLink(ition);
                }
            }
            else
            {
                ;
            }
            returning.GetSize();
            returning.Last();
            return returning;
    }
    
    public void insertSort()
    {
    	int n = this.GetSize();
    	for(int h =0; h < n; h++)
    	{
    		for (int i = 1; i<n; i++)
    		{
    			this.SetPos(i);
    			String key = this.GetValue().toString();
    			Type Keytype = this.GetValue();
    			int j = i-1;
    			this.SetPos(j);
    			while(j>=0 && this.GetValue().toString().toLowerCase().compareTo(key.toLowerCase()) > 0)
    			{
    				this.SetPos(j); //makes sure to switch to next item upon return
    				Type Temp = this.curr.getData();
    				this.Next();
    				this.Replace(Temp);
    				j = j-1;
    			}
    			this.SetPos(j+1);
    			this.Replace(Keytype);
    		}
    	}
    }
    // returns a string representation of the entire list (e.g., 1 2 3 4 5)
    // the string "NULL" should be returned for an empty list
    public String toString()
    {
        String output = "";
        int location = this.GetPos();
        boolean next = true;
        try
        {
           if(this.head == null || this.head.getLink() == null)
           {
               return "NULL";
           }
           First();
           do
           {
               output += this.curr.getData()+" ";
               next = this.curr.getLink() != null;
               this.Next();
           }while(next);
        }
        catch(NullPointerException e)
        {
            ;
        }
        this.SetPos(location);
        return output;
    }
}