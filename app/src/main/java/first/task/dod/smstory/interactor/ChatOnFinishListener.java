package first.task.dod.smstory.interactor;

import java.util.List;

import first.task.dod.smstory.model.Message;

/**
 * Created by noiser on 19.06.15.
 */
public interface ChatOnFinishListener {

    void onChatFinishListener(List<Message> messages);
}
