import java.util.*;
class Item implements Comparable<Item>{
    int value;
    int index;
    public Item(int a,int b){
        value=a;
        index=b;
    }
    public int compareTo(Item item){
        if(this.value<item.value){
            return -1;
        }
        if(this.value>item.value){
            return 1;
        }
        else{
            return 0;
        }
    }
    public String toString(){
        return index+" "+value;
    }
}
public class Djikstra
{
    static int[][] graph;
    public static void formGraph(int v1,int v2,int w){
        graph[v1][v2]=w;
        graph[v2][v1]=w;
    }
	public static void main(String[] args) {
	    Scanner s=new Scanner(System.in);
	    int v=s.nextInt();
		graph=new int[v][v];
		formGraph(0,1,3);
		formGraph(0,8,4);
		formGraph(1,2,2);
		formGraph(2,3,8);
		formGraph(2,4,1);
		formGraph(3,4,4);
		formGraph(3,5,12);
		formGraph(3,6,11);
		formGraph(4,7,7);
		formGraph(4,8,8);
		formGraph(5,6,10);
		boolean vis[]=new boolean[v];
		int dis[]=new int[v];
		int path[]=new int[v];
		Arrays.fill(path,-1);
		Arrays.fill(dis,Integer.MAX_VALUE);
        TreeSet<Item> al=new TreeSet<Item>();
        al.add(new Item(graph[2][2], 2));
        dis[2]=0;
        while(!al.isEmpty()){
            Item val=al.pollFirst();
            vis[val.index]=true;
            for(int i=0;i<v;i++){
                if(graph[val.index][i]!=0&&!vis[i]){
                    if(dis[i]>dis[val.index]+graph[val.index][i]){
                        al.add(new Item(graph[val.index][i],i));
                        path[i]=val.index;
                        dis[i]=Math.min(dis[val.index]+graph[val.index][i],dis[i]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(path));
        System.out.println(Arrays.toString(dis));
	}
}
