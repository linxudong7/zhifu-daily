package lxd.zhihu.message;

/**
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public interface Message {

    /**
     * 返回消息的Json格式字符串
     *
     * @return 消息的Json格式字符串
     */
    String toJsonString();
}
