package restaurant.management.common;

/**
 * Created by jiang (jiang.taojie@foxmail.com)
 * 2017/6/1 23:34 End.
 */
public class ResultDto<T> {

    private String status = Constant.SUCCESS;//状态
    private T object;//内容

    public ResultDto(){
    }

    public ResultDto(String status){
        this(status,null);
    }

    public ResultDto(String status, T object) {
        this.status = status;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
