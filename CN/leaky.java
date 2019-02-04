import java.util.*;
public class leaky
{
	static int min(int x,int y)
	{
		if(x<y)
		return x;
		else 
		return y;
	}
	public static void main(String [] args)
	{
		int drop=0,mini,nsec,cap,count=0,i,process;
		int inp[]=new int[25];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the bucket size\n");
		cap=sc.nextInt();
		System.out.println("enter the operation rate\n");
		process=sc.nextInt();
		System.out.println("enter no of seconds you want to simulate\n");
		nsec=sc.nextInt();
		for(i=0;i<nsec;i++)
		{
			System.out.println("enter the size of packet enterring as "+(i+1)+"sec");
			inp[i]=sc.nextInt();
		}
                //srsld
		System.out.println("\n second | Packet receivedn | packet sent | Packet left | Packet dropped | \n");
		for (i=0;i<nsec;i++)
		{
			count+=inp[i];
			if(count>cap)
			{
				drop=count-cap;
				count=cap;
			}
			System.out.println(i+1);
			System.out.print("\t\t" +inp[i]);
			mini=min(count,process);
			System.out.print("\t\t"+mini);
			count=count-mini;
			System.out.print("\t\t"+count);
			System.out.print("\t\t"+drop);
			drop=0;
			System.out.println();
		}
		for(;count!=0;i++)
		{
			if(count>cap)
			{
				drop=count-cap;
				count=cap;
			}
			System.out.println(i+1);
			System.out.print("\t\t0");
			mini=min(count,process);
			System.out.print("\t\t"+mini);
			count=count-mini;
			System.out.print("\t\t"+count);
			System.out.print("\t\t"+drop);
			System.out.println();
		}
	}
}


