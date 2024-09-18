package org.common.aspect;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-09-15 23:27
 */
@Aspect
@Component
public class PaginationAspect {

    private int defaultPageNum = 1;

    private int defaultPageSize = 10;

    @Around("execution(* org.application.service.*.*Page*(..))")
    public Object aroundPagination(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        if (args.length > 1 && args[0] instanceof Page<?> page) {
            page.setSize(defaultPageSize);
            page.setPages(defaultPageNum);
        }

        return joinPoint.proceed(args);
    }


}
