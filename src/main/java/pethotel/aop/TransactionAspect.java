package pethotel.aop;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class TransactionAspect {

	private static final String AOP_TRANSACTION_METHOD_NAME = "*";
	private static final String AOP_TRANSACTION_EXPRESSION = "execution(* pethotel..service.*Impl.*(..))";
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Bean
	public TransactionInterceptor transactionAdvice() {
		RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
		transactionAttribute.setName(AOP_TRANSACTION_METHOD_NAME);	//⇐ 트랜잭션 이름을 설정
		transactionAttribute.setRollbackRules(				//⇐ 트랜잭션에서 롤백하는 룰을 설정
				Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		
		MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
		source.setTransactionAttribute(transactionAttribute);
		
		return new TransactionInterceptor(transactionManager, source);	
	}
		@Bean
		public Advisor transactionAdviceAdvisor() {
			AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
			pointcut.setExpression(AOP_TRANSACTION_EXPRESSION);		//⇐ AOP의 포인트 컷을 설정
			return new DefaultPointcutAdvisor(pointcut, transactionAdvice());		
		}
	}

