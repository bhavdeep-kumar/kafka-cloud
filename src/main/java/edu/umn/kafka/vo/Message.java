package edu.umn.kafka.vo;

public class Message{

    private Integer id;

    private String message;

    public Message(){}
    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

}
