package first.task.dod.smstory.view;

import java.util.List;

import first.task.dod.smstory.model.Message;

/**
 * Created by noiser on 19.06.15.
 */
public interface DetailView {
    void showMessages(List<Message> messages);
}
