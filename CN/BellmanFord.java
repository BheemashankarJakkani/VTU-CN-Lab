import java.util.Scanner;
public class BellmanFord
{
    private int d[];
    private int n;
    public static final int MAX_VALUE = 999;

    public BellmanFord(int n)
    {
        this.n = n;
        d = new int[n + 1];
    }

    public void shortest(int s, int a[][])
    {
     for (int i = 1; i <= n; i++)
        {
            d[i] = MAX_VALUE;
        }
        d[s] = 0;
        for (int i = 1; i <= n - 1; i++)
        {
            for (int u = 1; u <= n; u++)
            {
               for (int v = 1; v <= n; v++)
                {
                    if (a[u][v] != MAX_VALUE)
                    {
                        if (d[v] > d[u]  + a[u][v])

                           d[v] = d[u]  + a[u][v];
                    }
                }
            }
        }

        for (int u = 1; u <= n; u++)
        {
           for (int v = 1; v <= n; v++)
            {
                if (a[u][v] != MAX_VALUE)
                {
             if (d[v] > d[u]+ a[u][v])
                        System.out.println("The Graph contains negative egde cycle");

                }

            }

        }
        for (int vertex = 1; vertex <= n; vertex++)
        {

            System.out.println("distance of source  " + s + " to " + vertex + " is " + d[vertex]);
        }

    }
    public static void main(String args[])
    {

        int n = 0;

        int s;

        Scanner sc = new Scanner(System.in); 

        System.out.println("Enter the number of vertices");

        n = sc.nextInt();

        int a[][] = new int[n + 1][n+ 1];

        System.out.println("Enter the adjacency matrix");

        for (int u = 1; u <= n; u++)

        {
          for (int v = 1; v <= n; v++)
          {
            a[u][v] = sc.nextInt();
            if (u == v)
            {
             a[u][v] = 0;
             continue;
             }
          if (a[u][v] == 0)
          {
            a[u][v] = MAX_VALUE;
          }

         }

       }
       System.out.println("Enter the source vertex");
       s = sc.nextInt();
       BellmanFord b = new BellmanFord(n);
       b.shortest(s, a);
       sc.close();	

    }
}
