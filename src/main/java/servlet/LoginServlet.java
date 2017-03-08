package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xuweijie on 2017/3/8.
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String piccode= (String) request.getSession().getAttribute("piccode");
        String checkcode=request.getParameter("checkcode");
        checkcode=checkcode.toUpperCase();
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out=response.getWriter();
            if(checkcode.equals(piccode)){
                out.print("验证码输入正确");
            }else {
                out.print("验证码输入错误");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
