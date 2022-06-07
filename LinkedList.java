// Team member: Chia Long Lin, Yu Han Lai - final part1
package final_part1;

public class LinkedList<Type> {
    private int size;
    private Node<Type> head;
    private Node<Type> last;
    
    // initialize the LList
    LinkedList(){
        this.size = 0;
        head = null;
        last = null;
    }

    public void add(Type element){
    	// add first node in empty List
        if(head == null){
            this.head = new Node<Type>(element,null);
            this.last = this.head;
            this.size++;
            return;
        }
    	// add new node in not empty List
        Node<Type> node = new Node<Type>(element,null);
        this.last.next = node;
        this.last = node;
        this.size++;
        return;
    }

    
    public void remove(int index){
        
    	
    	// remove not first entry
    	if(index > this.size){
            return;
        }
    	// remove first entry
    	else if(index == 0){
            this.head = this.head.next;
            this.size--;
            
            // after removing the list become empty
            if(this.size == 0){
                this.head = this.last = null;
            }
            return;
        }
        
    	// move every elements ahead 1 position via while loop
        int i=0;

        Node<Type> temp = this.head;
        Node<Type> prevTemp = temp;
        while(i != index){
            prevTemp = temp;
            temp = temp.next;
            i++;
        }

        prevTemp.next = temp.next;
        this.size--;

    }
    
    public Type get(int index){
        if(index > this.size){
            return null;
        }
        // go through and return elements via while loop
        int i = 0;
        Node<Type> temp = this.head;
        while (i != index){
            temp = temp.next;
            i++;
        }
        return temp.info;
    }

    public int size(){
        return this.size;
    }

    class Node<E>{
        public E info;
        public Node<E> next;

        Node(E info, Node<E> node){
            this.info = info;
            this.next  = null;
        }
    }

    public boolean isEmpty() {
    	boolean result;
    	if (size ==0 ) {
    		result = true;
    	}
    	else {
    		result = false;
    	}
    	return result;
		//return size == 0; // Or getLength() == 0
	}
}

