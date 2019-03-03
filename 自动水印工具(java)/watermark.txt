import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
public class watermark {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
	}
	public static void bigImgAddSmallImgAndText(String Img1Path,String Img2Path,String outPathWithFile) throws IOException{

		File pic1=new File(Img1Path);
		File pic2=new File(Img2Path);
		BufferedImage sou1=ImageIO.read(new FileInputStream(pic1));
		BufferedImage sou2=ImageIO.read(new FileInputStream(pic2));
		int bx=sou1.getWidth();int by=sou1.getHeight();
		int sx=sou2.getWidth();int sy=sou2.getHeight();
		InputStream fileimg =new FileInputStream(Img1Path);
		JPEGImageDecoder jpegDecoder =JPEGCodec.createJPEGDecoder(fileimg);
		BufferedImage buffImg=jpegDecoder.decodeAsBufferedImage();
		Graphics g=buffImg.getGraphics();
		ImageIcon imgIcon=new ImageIcon(Img2Path);
		Image img =imgIcon.getImage();
		g.drawImage(img, bx-sx,by-sy, null);
		g.setColor(Color.WHITE);
		g.dispose();
		OutputStream os =new FileOutputStream(outPathWithFile);
		JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
		en.encode(buffImg);
		fileimg.close();
		os.close();
	}
}