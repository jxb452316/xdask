package restaurant.management.web.rest;

/**
 * OperationResponse
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/1 - created by zhe.jiang
 */
public class OperationResponse {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OperationResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
