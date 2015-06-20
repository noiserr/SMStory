package first.task.dod.smstory.model;

import android.content.Context;

import first.task.dod.smstory.entity.MessageCriteria;
import first.task.dod.smstory.service.SmsService;

/**
 * Created by noiser on 19.06.15.
 */
public class FindMessageInteractorImpl implements FindMessageInteractor {
    @Override
    public void findAllMessagesForConversation(Context context, ChatOnFinishListener listener,
                                               MessageCriteria criteria) {
        SmsService smsService = new SmsService(context);
        listener.onChatFinishListener(
                smsService.getAllMessagessForConversation(criteria.getName(), criteria.getThreadID()));
    }
}
