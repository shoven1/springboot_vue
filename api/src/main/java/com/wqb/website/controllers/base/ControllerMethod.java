package com.wqb.website.controllers.base;

import com.wqb.website.services.base.BaseService;
import com.wqb.website.supports.util.ReflectHelper;
import com.wqb.website.supports.util.SpringContextUtils;
import org.springframework.stereotype.Service;

/**
 * @author Shoven
 * @since 2019-05-17 15:40
 */
public interface ControllerMethod<T> {

    /**
     * 获取服务类的默认实现
     * 通过泛型类型获取参数类型为该类型的服务类 Service<T>，例如通过 User 寻找 UserService<User>
     * 默认只认为每一个泛型只有唯一对应的服务类，因为会返回容器中匹配的第一个
     *
     * @return
     */
    default BaseService<T> getBaseService() {
        Class parameterizedType = ReflectHelper.getInterfaceGenericType(getClass(), 0);
        return SpringContextUtils.getBeanByParameterizedType(parameterizedType, Service.class);
    }
}
