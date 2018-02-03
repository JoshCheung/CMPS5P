import java.util.ArrayList;

public class IntegerList1 implements IntegerList{
	private ArrayList<Integer> items;
	
	public boolean isEmpty(){
		return items.isEmpty();
	}

	// size
	// pre: none
	// post: returns the number of elements in this IntegerList
	public int size(){
		return items.size();
	}

	// get
	// pre: 1 <= index <= size()
	// post: returns item at position index
	public int get(int index) {
		return items.get(index);
	}
	           

	// add
	// inserts newItem in this IntegerList at position index
	// pre: size() < MAX_LENGTH, 1 <= index <= size()+1
	// post: !isEmpty(), items to the right of newItem are renumbered
	public void add(int index, int newItem) {
		items.add(index, newItem);
	}
	           
	// remove
	// deletes item from position index
	// pre: 1 <= index <= size()
	// post: items to the right of deleted item are renumbered
	public void remove(int index) {
		items.remove(index);
	}
	           
	// removeAll
	// pre: none
	// post: isEmpty()
	public void removeAll() {
		items.removeAll(items);
	}
}

  