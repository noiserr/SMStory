package first.task.dod.smstory.presenter;

import android.content.Context;

import java.util.List;

import first.task.dod.smstory.model.ChatOnFinishListener;
import first.task.dod.smstory.model.FindMessageInteractor;
import first.task.dod.smstory.model.FindMessageInteractorImpl;
import first.task.dod.smstory.entity.Message;
import first.task.dod.smstory.entity.MessageCriteria;
import first.task.dod.smstory.view.DetailView;

/**
 * Created by noiser on 19.06.15.
 */
public class DetailPresenterImpl implements DetailPresenter, ChatOnFinishListener {

    private DetailView detailView;
    private Context context;
    private FindMessageInteractor findMessageInteractor;
    private MessageCriteria criteria;

    public DetailPresenterImpl(Context context, DetailView detailView, MessageCriteria criteria) {
        this.context = context;
        this.detailView = detailView;
        this.criteria = criteria;
        findMessageInteractor = new FindMessageInteractorImpl();
    }

    @Override
    public void onResume() {
        findMessageInteractor.findAllMessagesForConversation(context, this, criteria);
    }

    @Override
    public void onChatFinishListener(List<Message> messages) {
        detailView.showMessages(messages);
    }
}
