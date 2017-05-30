package restaurant.management.aspect;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiang (jiang.taojie@foxmail.com)
 * 2017/4/9 22:55 End.
 */
@ControllerAdvice
public class ResultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ModelAndView handleUnauthorizedException(UnauthorizedException e){
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("/forbidden");
        return modelAndView;
    }

}
