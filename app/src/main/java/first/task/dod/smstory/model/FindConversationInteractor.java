package first.task.dod.smstory.model;

import android.content.Context;

/**
 * Created by noiser on 19.06.15.
 */
public interface FindConversationInteractor {

    void findAllConversations(Context context, ConversationOnFinishListener listener);
}
