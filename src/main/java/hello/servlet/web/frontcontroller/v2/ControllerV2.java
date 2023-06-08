package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    // ControllerV1 과 다르게 void가 아닌 MyView를 반환함
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
