package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 컨트롤러에서 뷰로 이동해야되죠?? 그떄 사용하는겁니다
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //이걸 사용하면 서블릿에서 jsp를 호출 할 수 있는거임.
        // 다른 서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 재호출이 발생한다.
        dispatcher.forward(request, response);
    }
}