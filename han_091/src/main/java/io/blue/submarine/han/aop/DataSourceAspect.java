package io.blue.submarine.han.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(0)
@Aspect
@Component
public class DataSourceAspect {

	@Pointcut("@annotation(io.blue.submarine.han.aop.RouterDataSource)")
	public void dataSourcePointCut() {}

	@Around("dataSourcePointCut() &&  @annotation(routerDataSource)")
	public Object around(ProceedingJoinPoint joinPoint ,RouterDataSource routerDataSource) throws Throwable {
		if (DataSource.MASTER.equals(routerDataSource.value())){
			HintManager.getInstance().setMasterRouteOnly();
		}
		return joinPoint.proceed();
	}
}
