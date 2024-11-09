package ArrayList;

import java.util.Arrays;

public class MyList {
    private int data[];
    private int last = 0;

    public MyList(){
        data = new int[10];
    }
    public MyList(int initialCapacity){
        data = new int[initialCapacity];
    }

    public int size(){
        return last;
    }
    public void ensureCapacity(){
        if(last== data.length){
            int temp[]= new int [data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data =temp;
        }
    }

    public void add(int element){
        ensureCapacity();
        data[last++]=element;
    }
    public void add(int index , int element){
        if(index<0 || index>last)
            throw new IndexOutOfBoundsException(index +"index out of bound for last");
        ensureCapacity();
        for(int i=last;i>index;i--){
            data[i]=data[i-1];
        }
        data[index] = element;
        last++;
    }

    @Override
    public String toString() {
        if(last == 0)return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0;i<last;i++){
            sb.append(data[i] +" ");
        }
        sb.delete(sb.length()-2,sb.length());
        return sb + "]";
    }
    public int remove(int index){
        if(index < 0 || index >=last)
            throw new IndexOutOfBoundsException("cannot delete" + index);
        int temp = data[index];
        for(int i = index; i < last; i++){
            data[i] = data[i+1];
        }
        data[last-1] = 0;
        last--;
        return temp;
    }
}
