import java.lang.reflect.Array;
import java.util.*;
class Edge implements Comparable<Edge>{
    int weight;
    int x;
    int y;
    public Edge(int w,int a,int b){
        weight=w;
        x=a;
        y=b;
    }
    public int compareTo(Edge item){
        return this.weight-item.weight;
    }
    public String toString(){
        return x+" "+y+" "+weight;
    }
}
public class Kruskal
{
    static int[][] graph;
    public static void formGraph(int v1,int v2,int w){
        graph[v1][v2]=w;
        graph[v2][v1]=w;
    }
    public static boolean isDisjoint(HashSet<Integer> s1,HashSet<Integer> s2){
        s1.retainAll(s2);
        if(s1.size()==0){
            return true;
        }
        return false;
    }
    public static int find(ArrayList<HashSet<Integer>> sets,int a){
        for(int i=0;i<sets.size();i++){
            if(sets.get(i).contains(a)){
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
	    int v=s.nextInt();
        ArrayList<HashSet<Integer>> sets=new ArrayList<>();
        for(int i=0;i<v;i++){
            HashSet<Integer> hs=new HashSet<>();
            hs.add(i);
            sets.add(hs);
        }
        int e=s.nextInt();
		graph=new int[v][v];
        ArrayList<Edge> al=new ArrayList<>();
        int c=0;
        for(int i=0;i<e;i++){
            int x=s.nextInt();
            int y=s.nextInt();
            int w=s.nextInt();
            formGraph(x,y,w);
            al.add(new Edge(w,x,y));
        }
        Collections.sort(al);
        System.out.println(al);
        ArrayList<Integer> st=new ArrayList<>();
        ArrayList<Integer> end=new ArrayList<>();
        int cost=0;
        while(!al.isEmpty()&&c<v){
            Edge val=al.remove(0);
            HashSet<Integer> seta=new HashSet<>();
            seta.addAll(sets.get(find(sets,val.x)));
            int x=find(sets,val.x);
            int y=find(sets,val.y);
            HashSet<Integer> setb=sets.get(find(sets,val.y));
            if(isDisjoint(sets.get(find(sets,val.x)),setb)){
                cost+=val.weight;
                st.add(val.x);
                end.add(val.y);
                HashSet<Integer> temp=new HashSet<>();
                temp.addAll(seta);
                temp.addAll(setb);
                sets.set(x, temp);
                sets.remove(y);
                c++;
            }
        }
        System.out.println(st);
        System.out.println(end);
        System.out.println(cost);
	}
}
