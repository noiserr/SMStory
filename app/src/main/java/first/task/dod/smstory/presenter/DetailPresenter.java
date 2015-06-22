package first.task.dod.smstory.presenter;

import android.content.Context;

import java.util.List;

import first.task.dod.smstory.interactor.ChatOnFinishListener;
import first.task.dod.smstory.interactor.IFindMessageInteractor;
import first.task.dod.smstory.interactor.FindMessageInteractor;
import first.task.dod.smstory.model.Message;
import first.task.dod.smstory.model.MessageCriteria;
import first.task.dod.smstory.view.DetailView;

/**
 * Created by noiser on 19.06.15.
 */
public class DetailPresenter implements IDetailPresenter, ChatOnFinishListener {

    private DetailView detailView;
    private Context context;
    private IFindMessageInteractor IFindMessageInteractor;
    private MessageCriteria criteria;

    public DetailPresenter(Context context, DetailView detailView, MessageCriteria criteria) {
        this.context = context;
        this.detailView = detailView;
        this.criteria = criteria;
        IFindMessageInteractor = new FindMessageInteractor();
    }

    @Override
    public void onResume() {
        IFindMessageInteractor.findAllMessagesForConversation(context, this, criteria);
    }

    @Override
    public void onChatFinishListener(List<Message> messages) {
        detailView.showMessages(messages);
    }
}
