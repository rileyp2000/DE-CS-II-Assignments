import java.util.ArrayList;

/**
 * Implements a priority queue based on a min-heap.
 */


public class HeapInt
{
	ArrayList<Integer> list;
	
	public HeapInt() {
		list = new ArrayList<Integer>();
	}
	
	
	public void add(Integer i ) {
		list.add(insert(i),i);
	}


	private int insert(Integer i) {
		if(list.size() == 0)
			return 0;
		int l = 0, r = list.size()-1, mid = 0, diff = 0;
		while(l <= r) {
			mid = (l+r) / 2;
			
			if(i > list.get(mid))
				r = mid -1;
			else if(i < list.get(mid))
				l = mid + 1;
		}
		return l;
	}
	
	public static void main(String[] args) {
		HeapInt h = new HeapInt();
		h.add(1);
		h.add(12);
		h.add(3);
		h.add(5);
		h.add(33);
		h.add(7);
		
		System.out.println(h.list);
		
	}
}
