import java.util.*;
import java.io.*;


class Xtree<T extends Comparable<T>> implements Comparable<Xtree<T>>{
	private T val;
	Xtree<T> left;
	Xtree<T> right;
	int t;

	public Xtree (T v,int ty){
		val=v;
		left=null;
		right=null;
		t=ty;
	}

	public T getval(){
		return val;
	}



	
	public int compareTo(Xtree<T> b){
		return val.compareTo(b.getval());
	}

	public Xtree<T> insert(Xtree<T> root, T val){
		if(root==null){
			root=new Xtree<T>(val,t);
		}

		else{
			if(val.compareTo(root.getval())<0){
				root.left=insert(root.left,val);
				
			}
			else{
				root.right=insert(root.right,val);
			}
		}
		return root;
	}
	
	public void display(Xtree<T> root,ArrayList<Xtree> lol){
		if(root!=null){
			display(root.left,lol);
			lol.add(root);
			display(root.right,lol);
		}
	}

	
	
}


public class BSTFilesBuilder {

	public static void createBSTFiles(int numStudents, int numTrees) {
		Random rand = new Random();
		for (int i = 1; i <= numTrees; i++) {
		    try {
				PrintWriter w = new PrintWriter(i + ".txt", "UTF-8");
				int type = rand.nextInt(3) + 1;
				if(type == 1) {
					w.println("Integer");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextInt(1000));
						w.print(" ");
					}
				}
				else if(type == 2) {
					w.println("Float");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextFloat()*1000);
						w.print(" ");
					}
				}
				else {
					w.println("String");
					w.println(numStudents);
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 1; j <= numStudents; j++) {
						int len = rand.nextInt(10)+1;
						for (int k = 0; k < len; k++)
							w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
						w.print(" ");
					}
				}
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);

		int trees=sc.nextInt();
		int students=sc.nextInt();
		ArrayList<Xtree> tree=new ArrayList<Xtree>(trees);
		createBSTFiles(students,trees);
		for(int i=1;i<=trees;i++){
			BufferedReader rd=new BufferedReader(new FileReader(i+".txt"));
			String k=rd.readLine();
			//System.out.println(k);
			if (k.equals("Integer")){
				Xtree<Integer> root=intReader(rd);
				tree.add(root);

			}
			else if(k.equals("Float")){
				Xtree<Float> root=floatReader(rd);
				tree.add(root);
			}
			else{
				Xtree<String> root=stringReader(rd);
				tree.add(root);
			}


		}
		
		ArrayList<ArrayList<?>> bacche=new ArrayList<ArrayList<?>>();
		for(int i=0;i<students+1;i++){
			ArrayList yo=new ArrayList<String>();
			bacche.add(yo);
		}
		for(Xtree v :tree){
			ArrayList<Xtree> lolt=new ArrayList<Xtree>(students);
			Xtree temp=v;
			temp.display(temp, lolt);
		
			if(temp.t==0){
				Integer sum=0;
				for(Xtree k:lolt){
					sum=sum+Integer.parseInt((String) k.getval());
				}
				int k=lolt.indexOf(temp);
				ArrayList<String> l=(ArrayList<String>) bacche.get(k);
				l.add((sum).toString());
			}
			else if(temp.t==1){
				Float sum=(float) 0;
				for(Xtree k:lolt){
					sum=sum+Float.parseFloat((String) k.getval());
				}
				int k=lolt.indexOf(temp);
				ArrayList<String> l=(ArrayList<String>) bacche.get(k);
				l.add((sum).toString());
			}
			
			else{
				String s="";
				for(Xtree k:lolt){
					s=s+(String) k.getval();
				}
				int k=lolt.indexOf(temp);
				ArrayList<String> l=(ArrayList<String>) bacche.get(k);
				l.add(s);
			}
			
			
			
		}
		
		for(int i=0;i<students;i++){
			ArrayList<String> t=(ArrayList<String>) bacche.get(i);
			
			System.out.print(i);
			for(String s:t){
				System.out.print(" "+s);
			}
			System.out.println();
		}
	}

	public static Xtree<Integer> intReader(BufferedReader rd) throws IOException{
		int n=Integer.parseInt(rd.readLine());
		String[] data=rd.readLine().split(" ");

		Xtree<Integer> root1=new Xtree<Integer>(Integer.parseInt(data[0]),0);
		for(int i=1;i<n;i++){
			root1.insert(root1,Integer.parseInt(data[i]));
		}
		return root1;
	}

	public static Xtree<Float> floatReader(BufferedReader rd) throws IOException{
		int n=Integer.parseInt(rd.readLine());
		String[] data=rd.readLine().split(" ");

		Xtree<Float> root1=new Xtree<Float>(Float.parseFloat(data[0]),1);
		for(int i=1;i<n;i++){
			root1.insert(root1,Float.parseFloat(data[i]));
		}
		return root1;
	}

	public static Xtree<String> stringReader(BufferedReader rd) throws IOException{
		int n=Integer.parseInt(rd.readLine());
		String[] data=rd.readLine().split(" ");

		Xtree<String> root1=new Xtree<String>(data[0],2);
		for(int i=1;i<n;i++){
			root1.insert(root1,data[i]);
		}
		return root1;
	}

}