package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MethodConvertingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//
		chain.doFilter(wrapRequest((HttpServletRequest) req), resp);
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		//
		
	}
	
	private static HttpServletRequestWrapper wrapRequest(HttpServletRequest request) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public String getMethod() {
                return "POST";
            }
        };
    }
}