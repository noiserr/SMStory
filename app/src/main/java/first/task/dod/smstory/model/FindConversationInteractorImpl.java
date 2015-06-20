package first.task.dod.smstory.model;

import android.content.Context;

import first.task.dod.smstory.service.SmsService;

/**
 * Created by noiser on 19.06.15.
 */
public class FindConversationInteractorImpl implements FindConversationInteractor {


    @Override
    public void findAllConversations(Context context, ConversationOnFinishListener listener) {
        SmsService smsService = new SmsService(context);
        listener.onConversationFinishListener(smsService.getAllConversations());
    }
}
