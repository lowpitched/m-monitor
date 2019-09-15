package com.example.monitor.common;

import com.example.monitor.inum.CommonResultEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
@EqualsAndHashCode
public class CommonResult {

    private boolean isSuccess = true;

    private String errorCode;

    private String message;

    private Object data;

    public static CommonResult instance(Object data){
        CommonResult result = new CommonResult();
        result.data = data;
        result.errorCode = CommonResultEnum.CODE_SUCCESS.getCode();
        result.message = CommonResultEnum.CODE_SUCCESS.getCode();
        return result;
    }

    public static CommonResult instance(PaginationVo data){
        CommonResult result = new CommonResult();
        result.data = data;
        result.errorCode = CommonResultEnum.CODE_SUCCESS.getCode();
        result.message = CommonResultEnum.CODE_SUCCESS.getCode();
        return result;
    }

    public static CommonResult instance(CommonResultEnum resultEnum){
        Assert.notNull(resultEnum,"结果参数不能为空");
        CommonResult result = new CommonResult();
        if("0000".equals(resultEnum.getCode())){
            result.isSuccess = true;
        }else{
            result.isSuccess = false;
        }
        result.setErrorCode(resultEnum.getCode());
        result.setMessage(resultEnum.getDesc());
        return result;
    }

    public static CommonResult instance(CommonResultEnum resultEnum,String message){
        Assert.notNull(resultEnum,"结果参数不能为空");
        CommonResult result = new CommonResult();
        if("0000".equals(resultEnum.getCode())){
            result.isSuccess = true;
        }else{
            result.isSuccess = false;
        }
        result.setErrorCode(resultEnum.getCode());
        result.setMessage(message);
        return result;
    }

}
