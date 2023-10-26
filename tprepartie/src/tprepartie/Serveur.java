package tprepartie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {

	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket ss= new ServerSocket(123);
		System.out.println("waiting for the client to connect");
		Socket s=ss.accept();
		
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		
		
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		
		int a =Integer.parseInt(br.readLine()); 
		int b =Integer.parseInt(br.readLine());
		String op= br.readLine();
		
		int res=0;
		switch (op) {
		case "+": res= a+b; break;
		case "-": res= a+b; break;
		case "*": res= a+b; break;
		case "/": res= a+b; break;
		}
		
		PrintWriter pw = new PrintWriter(os,true);
		pw.println(res);
		
		//int a=is.read();
		//os.write(a);
		
		ss.close();

	}

}
