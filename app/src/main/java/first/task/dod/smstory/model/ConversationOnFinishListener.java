package first.task.dod.smstory.model;

import java.util.List;

import first.task.dod.smstory.entity.Conversation;

/**
 * Created by noiser on 19.06.15.
 */
public interface ConversationOnFinishListener {

    void onConversationFinishListener(List<Conversation> conversations);
}
