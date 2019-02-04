import java.io.*;
import java.net.*;
import java.util.*;
class UDPclient
{
 public static void main(String args []) throws Exception
  {
   DatagramSocket ds=new DatagramSocket(2000);

   while(true)
   {
    byte buf[]=new byte[1024];
//    DatagramSocket ds=new DatagramSocket(2000);
    DatagramPacket dp=new DatagramPacket(buf,buf.length);
   
    ds.receive(dp);
    String str2=new String(dp.getData(),0,dp.getLength());
    System.out.println("Server:"+str2);
    System.out.println("******");
    }
   }

}

