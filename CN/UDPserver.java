import java.io.*;
import java.net.*;
class UDPserver{
	public static void main(String [] a)throws IOException{
		int i=2000;
		String fooString1=new String("exit");
		while(true){
			InetAddress clientIP=InetAddress.getLocalHost();
                        System.out.println(clientIP);
			int clientPort=i;
			byte buf[]=new byte[1024];
			DatagramSocket ds=new DatagramSocket();
			BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("server is running.....");
			String str1=new String (dis.readLine());
			if (str1.equals(fooString1)){
				ds.close();
				break;
			}
			else{
				buf=str1.getBytes();
				DatagramPacket packet=new DatagramPacket(buf,str1.length(),clientIP,clientPort);
				ds.send(packet);
				
			}
		} 

    }
}
