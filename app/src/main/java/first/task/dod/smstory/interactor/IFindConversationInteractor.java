package first.task.dod.smstory.interactor;

import android.content.Context;

/**
 * Created by noiser on 19.06.15.
 */
public interface IFindConversationInteractor {

    void findAllConversations(Context context, ConversationOnFinishListener listener);
}
