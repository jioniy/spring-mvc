package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
         int age = Integer.parseInt(request.getParameter("age"));

         Member member = new Member(username, age);
         System.out.println("member = " + member);
         memberRepository.save(member);

         //Model에 데이터를 보관한다.
         request.setAttribute("member", member);

         String viewPath = "/WEB-INF/views/save-result.jsp";
         RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
         dispatcher.forward(request, response);
     }
 }