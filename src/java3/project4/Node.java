

package java3.project4;

/**
 * Node for OrderedList
 * @author Volan Nnanpalle
 */
public class Node<T>
{
    private T data;
    private Node link;
    
    public Node(T d, Node l)
    {
        data = d;
        link = l;
    }
    public T getData()
    {
        return data;
    }
    public Node getLink()
    {
        return link;
    }
    
    public void setData(T d)
    {
        data =d ;
    }
    
    public void setLink(Node l)
    {
        link = l;
    }
}

