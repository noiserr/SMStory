package first.task.dod.smstory.presenter;

import android.content.Context;

import java.util.List;

import de.greenrobot.event.EventBus;
import first.task.dod.smstory.event.ShowDetailsEvent;
import first.task.dod.smstory.model.ConversationOnFinishListener;
import first.task.dod.smstory.model.FindConversationInteractorImpl;
import first.task.dod.smstory.entity.Conversation;
import first.task.dod.smstory.view.MainView;

/**
 * Created by noiser on 19.06.15.
 */
public class MainPresenterImpl implements MainPresenter, ConversationOnFinishListener {

    private MainView mainView;
    private FindConversationInteractorImpl findConversationInteractor;
    private Context context;

    public MainPresenterImpl(MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
        findConversationInteractor = new FindConversationInteractorImpl();
        EventBus.getDefault().register(this);


    }

    @Override
    public void onItemClicked(String name, String threadID) {
        mainView.showDetails(name, threadID);
    }

    @Override
    public void onResume() {
        findConversationInteractor.findAllConversations(context, this);

    }

    @Override
    public void onConversationFinishListener(List<Conversation> conversations) {
        mainView.showConversations(conversations);
    }

    public void onEvent(ShowDetailsEvent event) {
        onItemClicked(event.name, event.threadID);

    }
}
