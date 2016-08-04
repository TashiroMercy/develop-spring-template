package jp.template.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class CustomHandlerInterceptor  implements HandlerInterceptor{

	 private static final Logger logger = LoggerFactory.getLogger(CustomHandlerInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Handlerメソッドが呼び出される前に行う処理を実装する
        // (実装は省略)
    	
    	
    	
        // Handlerメソッドを呼び出す場合はtrueを返却する
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Handlerメソッドが正常終了した後に行う処理を実装する(例外が発生した場合は、このメソッドは呼び出されない)
        // (実装は省略)
    	
    	logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Handlerメソッドの呼び出しが完了した後に行う処理を実装する(例外が発生しても、このメソッドは呼び出される)
        // (実装は省略)

    }
}
