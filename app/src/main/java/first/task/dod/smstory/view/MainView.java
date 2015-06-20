package first.task.dod.smstory.view;

import java.util.List;

import first.task.dod.smstory.entity.Conversation;

/**
 * Created by noiser on 19.06.15.
 */
public interface MainView {

    public void showConversations(List<Conversation> conversations);

    public void showDetails(String name, String thredID);
}
