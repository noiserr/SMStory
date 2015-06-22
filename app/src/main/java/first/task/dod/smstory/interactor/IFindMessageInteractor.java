package first.task.dod.smstory.interactor;

import android.content.Context;

import first.task.dod.smstory.model.MessageCriteria;

/**
 * Created by noiser on 19.06.15.
 */
public interface IFindMessageInteractor {

    void findAllMessagesForConversation(Context context, ChatOnFinishListener listener, MessageCriteria criteria);
}
