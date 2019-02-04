import java.net.*;
import java.io.*;
public class Contentserver
{
public static void main(String args[])throws Exception
{
ServerSocket sersock=new ServerSocket(4000);
System.out.println("server ready for connection");
Socket sock=sersock.accept();
System.out.println("connection is succefull and waiting for chatting");
InputStream istream=sock.getInputStream();
BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
String fname=fileRead.readLine();
BufferedReader contentRead=new BufferedReader(new FileReader(fname));
OutputStream ostream=sock.getOutputStream();
PrintWriter pwrite=new PrintWriter(ostream,true);
//File f= (fname);
String str;
 while((str=contentRead.readLine())!=null)
{
 pwrite.println(str);
}
 contentRead.close();
 sock.close();
 sersock.close();
 pwrite.close();
 fileRead.close();
 } 
}


