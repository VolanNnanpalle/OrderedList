package java3.project4;

/**
 *  This main program tests all the OrderedList class methods 
 * @author Volan Nnanpalle
 */
public class Java3_OrderedList
{

    public static void main(String[] args) throws OutOfBounds
    {

        OrderedList list=new OrderedList();
        OrderedList list1=new OrderedList();
        int k=2;
        list.insert(2);
        list.insert(8);
        list.insert(9);
        list.insert(3);
        list.insert(1);

        System.out.println("First list \n"+list);
        System.out.println("The largest "+k+" values in the list is \n"+list.
            getkLargest(k));
        list.remove(1);
        System.out.println("The value 2 was removed");
        System.out.println(list);
        System.out.println("The number of elements in the first list is "+list.
            getNumOfElements());
        System.out.println("Is the list empty "+list.isEmpty());
        try
        {
            System.out.println("The value at positon 2 in the first list is "+
                list.get(2));
        }catch(OutOfBounds e)
        {
            System.out.println(e);

        }
        list1.insert(6);
        list1.insert(2);
        list1.insert(7);
        list1.insert(1);
        list1.insert(123123123);
        System.out.println("Second List");
        System.out.println(list1);
        System.out.println("The value at position 3 in the second list is "+
            list1.get(3));
        System.out.println("First list and Second list combined");
        list.add(list1);
        System.out.println(list);



    }

}
