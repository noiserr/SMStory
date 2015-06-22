package first.task.dod.smstory.model;

import java.util.Date;

/**
 * Created by noiser on 18.06.15.
 */
public class Conversation {

    String contactName;
    String lastMessage;
    String thread;
    Date date;
    String contactAddress;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDateFromUnix(long unixTime) {
        Date time = new Date(unixTime);
        this.date = time;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "contactName='" + contactName + '\'' +
                ", lastMessage='" + lastMessage + '\'' +
                ", thread='" + thread + '\'' +
                ", date=" + date +
                '}';
    }
}
