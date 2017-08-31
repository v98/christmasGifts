import java.util.*;





class Xtree<T extends Comparable<T>> implements Comparable<xtree<T>>{
	private T val;
	private Xtree<T> rt;
	private Xtree<T> lt;

	public Xtree(T v){
		val=v;
	}

	public T getval(){
		return val;
	}

	// public void setrt(Xtree<T> t){
	// 	rt=t;
	// }

	// public void setlt(Xtree<T> t){
	// 	lt=t;
	// }
	public T showrt(){
		return rt.getval();

	}

	public T showlt(){
		return lt.getval();
	}
	public void add(T v){
		Xtree<T> temp=new Xtree(v);
		int k=compareTo(temp);
		if(k<0){
			if (lt!=null){
				lt.add(v);
			}
			else{
				lt=temp;
			}
		}
		else{
			if(rt!=null){
				rt.add(v);
			}
			else {
				rt=temp;
			}
		}
	}

	@Override
	public String toString(){
		return "val: "+val;
	}

	@Override
	public int compareTo(xtree<T> b){
		return val.compareTo(b.getval());
	}





	
}


public class Book<T extends Comparable<T>> implements Comparable<Book<T>>{
	private T val;
	
	public Book(T v){
		val=v;
	}

	public T getval(){
		return val;
	}

	// public int getpages(){
	// 	return pages;
	// }

	@Override
	public String toString(){
		return "val: "+val;
	}

	@Override
	public int compareTo(Book<T> b){
		return val.compareTo(b.getval());
	}