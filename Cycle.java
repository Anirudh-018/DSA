import java.util.*;

public class Cycle {
    static int[][] graph;
    public static boolean cycle(){
        Queue<Integer> qu=new LinkedList<Integer>();
        boolean vis[]=new boolean[graph.length];
        int parent[]=new int[graph.length];
        Arrays.fill(parent,-1);
        qu.add(0);
        vis[0]=true;

        while(!qu.isEmpty()){
            System.out.println(qu);
            System.out.println(Arrays.toString(parent));
            int v=qu.poll();
            // System.out.println(v);
            for(int i=0;i<graph.length;i++){
                if(graph[v][i]>0){
                    if(!vis[i]){
                        vis[i]=true;
                        qu.add(i);
                        parent[i]=v;
                    }
                    else if(parent[v]!=i){
                        return true;
                    }
                }
            }
        }
        return false;
    }
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
        System.out.println(cycle());
    }
}
