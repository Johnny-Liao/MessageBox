package lsh.messagebox.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String charSet; 	//设置字符编码
	
    public void init(FilterConfig config)throws ServletException{
        this.charSet=config.getInitParameter("charset");	//取得初始化参数
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
                throws IOException,ServletException{		//执行过滤
    	request.setCharacterEncoding(this.charSet);			//设置统一编码
    }
    
    public void destroy(){
    }

}
