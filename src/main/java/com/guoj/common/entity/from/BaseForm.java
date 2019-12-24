package com.guoj.common.entity.from;

import com.guoj.common.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@ApiModel
@Data
public class BaseForm<T extends BasePo> {

    private String username;

    /**
     * From转化为Po，进行后续业务处理
     *
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        BeanUtils.copyProperties(this, t);
        return t;
    }


}
