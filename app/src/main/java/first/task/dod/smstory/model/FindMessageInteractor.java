package first.task.dod.smstory.model;

import android.content.Context;

import first.task.dod.smstory.entity.MessageCriteria;

/**
 * Created by noiser on 19.06.15.
 */
public interface FindMessageInteractor {

    void findAllMessagesForConversation(Context context, ChatOnFinishListener listener, MessageCriteria criteria);
}
