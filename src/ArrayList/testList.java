package ArrayList;

import java.util.ArrayList;

public class testList {
    public static void main(String[] args) {
        MyList list = new MyList();
        System.out.println(list);
        System.out.println(list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);
        System.out.println(list.size());
        list.add(1,15);
        System.out.println(list);
        System.out.println(list.size());
        list.add(3,25);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.remove(3));
        System.out.println(list);
        System.out.println(list.size());

    }
}
