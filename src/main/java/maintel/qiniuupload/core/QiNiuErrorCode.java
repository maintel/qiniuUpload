package maintel.qiniuupload.core;

import java.util.EnumSet;

/**
 * 七牛云上传错误码
 *
 * @author Maintel
 * @create 2017-08-20 0:51
 **/
public enum QiNiuErrorCode {


    BAD_TOKEN("401", "认证授权失败,包括密钥信息不正确；数字签名错误；授权已超时。"),
    NO_ACCOUNT("9999", "七牛云账号未设置"),
    FORM_ERROR("400", "请求报文格式错误,包括上传时，上传表单格式错误。"),
    ACCESS_DENIED("403", "拒绝访问"),
    REQUEST_ERROR("405", "请求方式错误"),
    CRC32_ERROR("406", "上传的数据 CRC32 校验错误"),
    SIZE_TOO_BIG("413", "请求资源大小大于指定的最大值"),
    ACCOUNT_BLOCKED("419", "用户账号被冻结"),
    SERVER_UNAVAILABLE("503", "服务端不可用"),
    TIME_OUT("504", "服务端操作超时"),
    CALLBACK_FAIL("579", "上传成功但是回调失败"),
    BUCKET_NULL("631", "指定空间不存在"),
    UNKNOWN_ERROR("9009", "发生了一个未知错误");

    private String code;
    private String msg;

    QiNiuErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsgByCode(String code) {
        EnumSet<QiNiuErrorCode> qiNiuErrorCodeEnumSet = EnumSet.allOf(QiNiuErrorCode.class);
        String msg = "发生了一个未知错误,请检查 AccessKey 和 SecretKey 是否正确！";
        for (QiNiuErrorCode qiNiuError : qiNiuErrorCodeEnumSet) {
            if (qiNiuError.getCode().equals(code)) {
                msg = qiNiuError.getMsg();
            }
        }
        return msg;
    }
}
