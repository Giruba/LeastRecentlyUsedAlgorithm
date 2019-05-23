package LRUCache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
	private Deque<Integer> dequeue;
	private HashSet<Integer> hashSet;
	private int capacity;
	private int size;
	
	public LRUCache(int capacity) {
		dequeue = new LinkedList<Integer>();
		hashSet = new HashSet<Integer>();
		this.capacity = capacity;
		this.size =0;
	}
	
	public void SetSize(int value) {
		this.size = value;
	}
	
	public void SetCapacity(int value) {
		this.capacity = value;
	}
	
	public int GetLRUCacheCapacity() {
		return this.capacity;
	}
	
	public int GetLRUCacheSize() {
		return this.size;
	}
	
	public void ReferPage(int pageNumber) {
		//Two cases arise
		//1. Page is not present
		//2. Page is present
		if(!this.hashSet.contains(pageNumber)) {
			//If Deque is already full
			if(this.dequeue.size() == this.capacity) {
				int tobeRemoved = dequeue.removeLast();
				hashSet.remove(tobeRemoved);
			}
		}else {
			int foundIndex = 0;
			int count = 0;
			Iterator<Integer> dequeIterator = this.dequeue.iterator();
			while(dequeIterator.hasNext()) {
				if(dequeIterator.next() == pageNumber) {
					foundIndex = count;
					break;
				}
				count++;
			}
			dequeue.remove(foundIndex);
		}
		dequeue.push(pageNumber);
		hashSet.add(pageNumber);
	}
	
	public void PrintDequeueElements() {
		
		System.out.println("-----Printing Dequeue elements-------");
		
		Iterator<Integer> dequeueIteraror = dequeue.iterator();
		while(dequeueIteraror.hasNext()) {
			System.out.print(dequeueIteraror.next()+" ");			
		}
		
	}
}
