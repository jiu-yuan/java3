package transfer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

public class function {
//==========================================================================================
	//图片转化成二进制
	public static byte[] return_b_img(BufferedImage img) throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		boolean flag = ImageIO.write(img, "png", out);
		byte[] b = out.toByteArray();
		
		return b;
	}
//==========================================================================================
	//二进制图片获取
	public static byte[] read_b_img(String url) throws FileNotFoundException, IOException {
		BufferedImage img = read_img(url);
		byte[] b_img = return_b_img(img);
		return b_img;
	}
	//图片获取
	public static BufferedImage read_img(String url) throws IOException {
		BufferedImage  img = ImageIO.read(new File(url));
		if(img==null)
		{
			System.out.println("图片读取失败");
			return null;
		}
		System.out.println("图片读取成功");
		return img;
	}
//==========================================================================================
	//图片输出
	public static void write_img(BufferedImage img) throws IOException {
		File file = new File("D:\\z\\tf\\transfer\\out.png");
		if(ImageIO.write(img, "png", file)==false)
		{
			System.out.println("图片输出失败");
			return;
		}
		System.out.println("图片输出成功");
	}
	//二进制图片输出
	public static void write_b_img(byte[] img) throws IOException {
		File file = new File("D:\\z\\tf\\transfer\\out.png");
		FileImageOutputStream imgout=new FileImageOutputStream(file);
		imgout.write(img,0,img.length);
		imgout.close();
		
		System.out.println("图片输出成功");
		
	}
//==========================================================================================

	
//	public static void main(String args[]) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();//读入路径
//		BufferedImage  img = read_img(str);//读入图片
//		if(img!=null)
//			try {
//				write_img(img);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
}//     D:\z\tf\transfer\\portrait.png
