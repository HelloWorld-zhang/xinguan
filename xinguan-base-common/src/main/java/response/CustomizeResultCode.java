package response;

public interface CustomizeResultCode {
    /**
     * 获取错误的状态码
     * @return 错误的状态码
     */
    Integer getCode();

    /**
     * 获取错误信息
     * @return取错误信息
     */
    String getMessage();
}
