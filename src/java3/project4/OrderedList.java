package java3.project4;

/**
 * This is a Ordered List class which uses a linked list of generic nodes to
 * maintain an ordered list i.e, the nodes are ordered in the list so that the
 * data values they contain are in ascending order (from smallest to largest) as
 * you tranverse the list from its first node to its last.
 *
 * @author Volan Nnanpalle
 */
public class OrderedList<T extends Comparable<T>>
{
    //attributes
    private Node<T> firstNode;
    private int length;

    //Defualt constructor 
    public OrderedList()
    {
        firstNode=null;
        length=0;
    }

    /**
     * This method returns the length of the list
     *
     * @return the length of the list
     */
    public int getLength()
    {
        return length;
    }

    /**
     * This method checks weather the list is empty or not
     *
     * @return true if the list is empty. false otherwise
     */
    public boolean isEmpty()
    {

        return length==0;
    }

    /**
     * This method returns the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int getNumOfElements()
    {
        return length;
    }

    /**
     * This method creates a new node with a given element and inserts it into
     * its correct position in the list so that the list is still in its
     * ascending order.
     *
     * @param e the element being supplied by the user
     */
    public void insert(T e)
    {

        Node<T> eNode=new Node(e, null); //create a new node of the given element

        if(isEmpty()) //checks if the list is empty
        {
            firstNode=eNode;
            length++;

        }else
        {
            Node<T> tempFirstNode=firstNode;
            //checks if its greater than everything
            for(int i=0; i<length; i++)
            {
                //checks if the element supplied is less than the first element
                if(e.compareTo(firstNode.getData())<=0)
                {
                    eNode.setLink(firstNode);
                    firstNode=eNode;
                    length++;
                    return;
                }

                if(tempFirstNode.getLink()==null) //if at the end of the list
                {
                    tempFirstNode.setLink(eNode);
                    //sets the link of the element passed to tempFirstNode 
                    length++;
                    return;
                }
                //checks if the element supplied is greater than the first element
                if(e.compareTo(tempFirstNode.getData())>=0)
                {
                    //check if the element supplied is less than the second element
                    if(e.compareTo((T)tempFirstNode.getLink().getData())<=0)
                    {
                        eNode.setLink(tempFirstNode.getLink());
                        tempFirstNode.setLink(eNode);
                        length++;
                        return;
                    }
                }

                tempFirstNode=tempFirstNode.getLink(); //increment 
            }

        }

    }
    /**
     * This method removes the first instance of a given element from the list
     * @param e the element supplied by the user
     */
    public void remove(T e)
    {
        Node currentFirstNode=null, prev=null;
        if(this.length==0)
        {
            return;
        }
        //if the first element and the supplied element are not equal set what 
        //the prev as the element before what currentFirstNode is set to 
        for(currentFirstNode=this.firstNode; currentFirstNode!=null&&
            !e.equals(currentFirstNode.getData()); currentFirstNode=currentFirstNode.getLink())
        {
            prev=currentFirstNode;
        }
        if(currentFirstNode==null)
        {
            return;
        }
        if(e.equals(firstNode.getData()))
        {
            firstNode=firstNode.getLink();
        }else
        {
            prev.setLink(currentFirstNode.getLink());
        }
        length--;
    }
    /**
     * This method combines the largestList in this class and another largestList and 
     * return the new OrderedList 
     * @param largestList the OrderedList being supplied by the user
     */
    public void add(OrderedList largestList)
    {
        if(largestList.length==0)
        {
            return;
        }
        //loop though the largestList and insert each element in the largestList supplied to
        //the largestList in this class until you are at the end 
        for(Node<T> n=largestList.firstNode; n!=null; n=n.getLink())
        {
            this.insert(n.getData());
        }
    }

    /**
     * This method returns a copy of the element at a given index
     * @param k the index
     * @return  a copy of the element at the given index 
     * @throws OutOfBounds if the index passes is greater than the length
     */
    public T get(int k) throws OutOfBounds
    {

        Node<T> n=this.firstNode;
        for(int i=0; i<length; i++)
        {
            //checks if the index passed is greater than the length
            if(k>length-1)
            {
                throw new OutOfBounds("THE INDEX "+k+" IS OUT OF BOUNDS!!!!");
            }
            if(i==k) 
            {
                return n.getData();
            }

            n=n.getLink(); //increment


        }

        return n.getData();
    }
    /**
     * This method returns an OrderedList that contains the k largest elements of this list
     * @param k the number of largest element the user wants to find in the list
     * @return the number of largest elements the user wants to find in the list
     */
    public OrderedList<T> getkLargest(int k)
    {
        OrderedList list=new OrderedList(); //declare a new OrderedList
        Node<T> n=this.firstNode;
        for(int i=0; i<length; i++)
        {
            /*
            checks if i is greater than or equal to length minus k which will 
            leave all the greatest k element is the list 
            */
            if(i>=length-k) 
            {
                list.insert(n.getData()); //insets the data in the new list
            }
            n=n.getLink(); //increment 
        }
        return list; //returns the largest k elements

    }
    /**
     * This method returns a string of the format [data1,data2,....] that contains all the
     * data in this list in ascending order 
     * @return 
     */
    @Override
    public String toString()
    {
        String s="[";
        for(Node n=firstNode; n!=null; n=n.getLink())
        {
            s+=n.getData()+((n.getLink()!=null)?", ":"]");

        }
        return s;
    }

}
