package com.lyp.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;

/**
 * @author Liu Yanping
 * @date 2021/9/18 23:04
 */
public class SpelDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(MyFunction.class);
//        context.registerFunction("IF",MyFunction.class.getDeclaredMethod("IF", Boolean.class, String.class, String.class));
        context.setVariable("PARAMS",new ArrayList<>());
        String expression = parser.parseExpression("IF(isEmpty(#PARAMS)||isEmpty('123'),IF(false,\"a\",\"c\"),'b')").getValue(context, String.class);
        System.out.println(expression);

    }
}
