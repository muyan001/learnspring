package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * 1.编写后置处理器的实现类
 * 2，将后置处理器注册在配置文件中
 */

public class MyBeanPostProcessor implements BeanPostProcessor{

    /**
     *  初始化方法之前调用
     * @param bean  将要初始化的bean
     * @param beanName  bean的名字
     * @return
     * @throws BeansException
     */

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【"+ beanName +"】bean 将要调用初始化方法。。" + bean);

//        返回传入的bean
        return bean;
    }


    /**
     *
     * 初始化方法之后调用
     * @param bean 初始化完成后的bean
     * @param beanName  bean的名称
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("【"+ beanName +"】bean 初始化调用完了。。" + bean);

//        这里返回的是什么，容器中保存的就是什么
        return bean;
    }
}
