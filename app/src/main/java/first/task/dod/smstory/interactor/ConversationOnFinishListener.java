package first.task.dod.smstory.interactor;

import java.util.List;

import first.task.dod.smstory.model.Conversation;

/**
 * Created by noiser on 19.06.15.
 */
public interface ConversationOnFinishListener {

    void onConversationFinishListener(List<Conversation> conversations);
}
