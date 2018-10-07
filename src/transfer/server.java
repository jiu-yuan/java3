package transfer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class server {
 
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("Server start!");
			Socket socket = server.accept(); //阻塞等待, 直到一个客户端 socket过来
			System.out.println("There comes a socket!");
			InputStreamReader in = new InputStreamReader(socket.getInputStream()); //输入，from 客户端
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //输出，to 客户端
			System.out.println(in.toString());  // 打印 客户 socket 发过来的字符，按行(\n,\r,或\r\n)
			out.println("Server reponse! ^_^ "); 
			out.flush(); // to 客户端，输出
			socket.close();
			server.close();
			System.out.println("Server end!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}