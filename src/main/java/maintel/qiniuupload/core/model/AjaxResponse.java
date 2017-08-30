package maintel.qiniuupload.core.model;

/**
 * AjaxResponse
 * ajax请求返回类
 *
 * @author maintel
 * @create 2017-08-18 10:03
 */
public class AjaxResponse {

    /** Field date 返回的数据 */
    private Object data;

    /** Field retCode 返回代码 */
    private String retCode;

    private String error;

    /** Field retInfo 返回信息 */
    private String retInfo;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

