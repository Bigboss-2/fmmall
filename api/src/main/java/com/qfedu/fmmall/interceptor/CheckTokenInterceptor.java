package com.qfedu.fmmall.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.fmmall.vo.ResStatus;
import com.qfedu.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class CheckTokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }

        String token = request.getHeader("token");
        System.out.println("--------------------------------" + token);
        if(token == null){
            //提示请先登录
            ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录", null);
            doResponse(response,resultVO);
            return false;
        }else{
            try{
                //验证token
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("QIANfeng6666");  //解析token的SigningKey必须和生成token时密码设置一致
                //如果token正确(密码正确，有效期内)则正常执行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                ResultVO resultVO = new ResultVO(ResStatus.OK, "success", null);
                doResponse(response,resultVO);
                return true;
            }catch (ExpiredJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "登录过期，请重新登录!", null);
                doResponse(response,resultVO);

            }catch (UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "Token不合法，请自重", null);
                doResponse(response,resultVO);
            }catch(Exception e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录!", null);
                doResponse(response,resultVO);
            }
            return false;
        }
    }

    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }
}
