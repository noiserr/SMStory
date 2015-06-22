package first.task.dod.smstory.model;

/**
 * Created by noiser on 18.06.15.
 */
public class Message {


    private String id;
    private String body;
    private String contactName;
    private String contactAddress;
    private String date;
    private int type;

    @Override
    public String toString() {
        return "Id: " + id + ", nr: " + contactAddress + ", name: " + contactName + ", body: " + body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
