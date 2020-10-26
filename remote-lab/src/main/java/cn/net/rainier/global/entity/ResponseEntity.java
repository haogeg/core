package cn.net.rainier.global.entity;

import lombok.Data;

/**
 * 接口返回统一定义类
 */
@Data
public class ResponseEntity<T> {

    public static final Integer CODE_SUCCESSED = 200;
    public static final Integer CODE_ERROR = 500;

    /**
     * 是否成功
     */
    private boolean status;

    /**
     * 结果信息
     */
    private String msg;

    /**
     * 结果返回的数据
     */
    private T data;

    /**
     * 结果返回状态码
     */
    private Integer  code;

    public ResponseEntity(boolean  status, Integer code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功返回Data
     * @param data
     */
    public ResponseEntity(T data) {
        setData(data);
        this.status = true;
        this.code = CODE_SUCCESSED;
        this.msg = "success";
    }

    public static ResponseEntity successed() {
        return new ResponseEntity(true, CODE_SUCCESSED, "success");
    }

    public static ResponseEntity error() {
        return new ResponseEntity(false, CODE_ERROR, "运行时出错.");
    }

    public ResponseEntity setDataAndThen(T data) {
        setData(data);
        return this;
    }
}
