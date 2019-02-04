import java.io.*;
import java.util.*;
class crc1
{
 public static void main(String args[])
 {
  int n,m,msb,flag=1,i,j,k;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the no of bits in the generator");
  m=sc.nextInt();
  System.out.println("Enter the no of bits in the dataword");
  n=sc.nextInt();
  int g[]=new int[m];
  int d[]=new int[n+m];
  int z[]=new int[m];
  System.out.println("Enter the generator");
  for(i=0;i<m;i++)
  {
    g[i]=sc.nextInt();
  }
  System.out.println("Enter the dataword");
  for(j=0;j<n;j++)
  {
   d[j]=sc.nextInt();
  }
  //for initial codeword
  for(i=n;i<m+n-1;i++)
  {
   d[i]=0;
  }
  int r[]=new int[m+n];
  for(i=0;i<n;i++)
  {
    r[i]=d[i];
  }
  for(i=0;i<m;i++)
  {
    z[i]=0;
  }
  //code for division
  for(i=0;i<n;i++)
  {
    k=0;
    msb=r[i];
    for(j=i;j<m+i;j++)
    {
      if(msb==0)
         r[j]=xor(r[j],z[k]);
      else
         r[j]=xor(r[j],g[k]);
            k++;
    }

   r[m+i]=d[m+i];
 }
 //store all remainder to dataword ie. codeword=dataword+remainder;
 for(i=n;i<m+n-1;i++)
 {
   d[i]=r[i];
 }
 
 System.out.println("The Code word obtained is ");
 for(i=0;i<m+n-1;i++)
 {
  System.out.print(""+d[i]);
 }
 int x[]=new int[n+m];
 System.out.println("Enter the data received at reciever side");
 for(i=0;i<m+n-1;i++)
 {
  x[i]=sc.nextInt();
 } 
 for(i=0;i<n+m;i++)
 {
  if(d[i]!=x[i])
          flag=0;
         //break;
}
 if(flag==1)
 {
  System.out.println("No error");
 }
 else
 System.out.println("Eorror");

}  
 

static int xor(int x,int y)
{
  if(x==y)
     return 0;
  else 
    return 1;
}

}
