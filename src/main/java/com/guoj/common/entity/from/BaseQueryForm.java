package com.guoj.common.entity.from;

import com.guoj.common.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@ApiModel
public class BaseQueryForm<P extends BaseParam> extends BaseForm {

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum == null ? 0 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum == null ? 0 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize == null ? 10 : pageSize;
    }

    /**
     * Form转化为Param
     *
     * @param clazz
     * @return
     */
    public P toParam(Class<P> clazz) {
        P p = null;
        try {
            p = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        BeanUtils.copyProperties(this, p);
        return p;
    }

}
