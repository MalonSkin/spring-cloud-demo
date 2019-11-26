package com.zhangzz.hello.publish;

/**
 * 推送到光栅使用的参数实体类
 */
public class PublishParam {

    private Auth auth;
    /**
     * 传输内容，字符串，具体待传输的内容，非空，最大长度 4K
     */
    private String content;

    public PublishParam() {
    }

    /**
     * 返回一个Auth对象
     */
    public static Auth getAuthInstance(String channel_name, String channel_password, String channel_ip) {
        return new Auth(channel_name, channel_password, channel_ip);
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static class Auth {
        /**
         * 任务名称，光码系统中创建的 rest 类型任务的任务名，非空，对应的任务必须存在
         */
        private String channel_name;
        /**
         * 任务密码，字符串
         */
        private String channel_password;
        /**
         * 限制 IP，字符串
         */
        private String client_ip;

        Auth(String channel_name, String channel_password, String channel_ip) {
            this.channel_name = channel_name;
            this.channel_password = channel_password;
            this.client_ip = channel_ip;
        }

        public String getChannel_name() {
            return channel_name;
        }

        public void setChannel_name(String channel_name) {
            this.channel_name = channel_name;
        }

        public String getChannel_password() {
            return channel_password;
        }

        public void setChannel_password(String channel_password) {
            this.channel_password = channel_password;
        }

        public String getClient_ip() {
            return client_ip;
        }

        public void setClient_ip(String client_ip) {
            this.client_ip = client_ip;
        }
    }
}
