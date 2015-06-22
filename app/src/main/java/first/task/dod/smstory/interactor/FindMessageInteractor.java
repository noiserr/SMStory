package first.task.dod.smstory.interactor;

import android.content.Context;

import first.task.dod.smstory.model.MessageCriteria;
import first.task.dod.smstory.service.SmsService;

/**
 * Created by noiser on 19.06.15.
 */
public class FindMessageInteractor implements IFindMessageInteractor {
    @Override
    public void findAllMessagesForConversation(Context context, ChatOnFinishListener listener,
                                               MessageCriteria criteria) {
        SmsService smsService = new SmsService(context);
        listener.onChatFinishListener(
                smsService.getAllMessagessForConversation(criteria.getName(), criteria.getThreadID()));
    }
}
