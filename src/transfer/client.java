package transfer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class client {
 
	public static void main(String[] args) throws UnknownHostException, IOException {	
		Socket socket = new Socket("127.0.0.1", 8000);
		OutputStream b_out = socket.getOutputStream();
		System.out.println("Client start!");				
		while(true) {
			try {//     D:\z\tf\transfer\\portrait.png
				Scanner scanner = new Scanner(System.in);	
				String img_path = scanner.nextLine();			//读入路径
				if("end".equals(img_path)){						//end退出
					b_out.write("end".getBytes());
					socket.close();
					System.out.println("Client end.");
					break;
				}
				
				byte[] b_img = function.read_b_img(img_path);	//读入二进制图片	
//				function.write_b_img(b_img);
				String str2 = "8000|portrait.png|"+String.valueOf(b_img.length);
				byte[] str_first = str2.getBytes();
				
							
				b_out.write(str_first);							//第一次数据，发送图片的信息
				b_out.write(b_img, 0, b_img.length);			//第二次数据，发送图片
				b_out.flush();// 刷缓冲输出，to 服务器
				System.out.println("Client continue..");
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
		

	}
 
}
