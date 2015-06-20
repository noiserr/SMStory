package first.task.dod.smstory.model;

import java.util.List;

import first.task.dod.smstory.entity.Message;

/**
 * Created by noiser on 19.06.15.
 */
public interface ChatOnFinishListener {

    void onChatFinishListener(List<Message> messages);
}
