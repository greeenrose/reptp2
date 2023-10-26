package tprepartie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s= new Socket("localhost",123);
		
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		System.out.println("client has connected");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("donner deux operateur:");
		
		int a= sc.nextInt();
		int b= sc.nextInt();
		String op;
		do {
			System.out.println("donner l'operation (+,-,*,/");
			 op= sc.nextLine();
		}while(!op.equals("+")&&!op.equals("-")&&!op.equals("*")&&!op.equals("/"));
		
		PrintWriter pw = new PrintWriter(os,true);
		pw.println(a);
		pw.println(b);
		pw.println(op);
		/*
		os.write(a);
		
		int a1=is.read();
		System.out.println(a1);
		*/
		
		System.out.println(a+op+b+"="+(new BufferedReader(new InputStreamReader(is)).readLine()));
		s.close();
	}

}
