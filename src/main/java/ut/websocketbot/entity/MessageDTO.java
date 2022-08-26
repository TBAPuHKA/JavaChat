package ut.websocketbot.entity;

public class MessageDTO {

    private String id;
    private String content;
    private String userId;
    private String userName;

    public MessageDTO() {
    }

    public MessageDTO(String id, String content, String userId, String userName) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}
