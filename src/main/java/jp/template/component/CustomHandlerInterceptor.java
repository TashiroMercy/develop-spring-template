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
        // Handler���\�b�h���Ăяo�����O�ɍs����������������
        // (�����͏ȗ�)
    	
    	
    	
        // Handler���\�b�h���Ăяo���ꍇ��true��ԋp����
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Handler���\�b�h������I��������ɍs����������������(��O�����������ꍇ�́A���̃��\�b�h�͌Ăяo����Ȃ�)
        // (�����͏ȗ�)
    	
    	logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Handler���\�b�h�̌Ăяo��������������ɍs����������������(��O���������Ă��A���̃��\�b�h�͌Ăяo�����)
        // (�����͏ȗ�)

    }
}
