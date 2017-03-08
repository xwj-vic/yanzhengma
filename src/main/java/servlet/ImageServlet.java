package servlet;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by xuweijie on 2017/3/8.
 * 以servlet的形式来实现验证码
 */
public class ImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        BufferedImage bi=new BufferedImage(68,22,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=bi.getGraphics();
        Color c=new Color(121, 255, 108);
        g.setColor(c);
        g.fillRect(0,0,68,22);
        char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r=new Random();
        int len=ch.length,index;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<4;i++){
            index=r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));//产生随机颜色
            g.drawString(ch[index]+"",(i*15)+3,18);//设置图片和宽高
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("piccode",sb.toString());//保存到session
        try {
            ImageIO.write(bi,"JPG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
