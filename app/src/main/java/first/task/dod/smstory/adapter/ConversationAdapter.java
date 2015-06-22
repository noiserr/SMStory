package first.task.dod.smstory.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import first.task.dod.smstory.R;
import first.task.dod.smstory.event.ShowDetailsEvent;
import first.task.dod.smstory.model.Conversation;

/**
 * Created by noiser on 18.06.15.
 */
public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {


    List<Conversation> conversationList;

    public ConversationAdapter(List<Conversation> conversationList) {
        this.conversationList = conversationList;

    }

    @Override
    public ConversationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversation_cardview, parent, false);
        return new ConversationViewHolder(viewItem);

    }

    @Override
    public void onBindViewHolder(ConversationViewHolder holder, int position) {

        Conversation conversation = conversationList.get(position);

        if (conversation.getContactName().toLowerCase().equals("unknown")) {
            holder.contactName.setText(conversation.getContactAddress());
        }else{
            holder.contactName.setText(conversation.getContactName());
        }
        holder.lastMessage.setText(conversation.getLastMessage());
        Date date = conversation.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        holder.date.setText(dateFormat.format(date));
        holder.iconLetter.setText(conversation.getContactName().substring(0, 1));

    }

    @Override
    public int getItemCount() {
        return conversationList.size();
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @InjectView(R.id.date_textview)
        TextView date;
        @InjectView(R.id.contact_name_textview)
        TextView contactName;
        @InjectView(R.id.last_message_textview)
        TextView lastMessage;
        @InjectView(R.id.conversation_icon_letter)
        TextView iconLetter;

        public ConversationViewHolder(View itemView) {

            super(itemView);
            ButterKnife.inject(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ShowDetailsEvent event = new ShowDetailsEvent();
            Conversation conversation = conversationList.get(getAdapterPosition());
            if (conversation.getContactName().toLowerCase().equals("unknown")) {
                event.name = conversation.getContactAddress();
            }else{
                event.name = conversation.getContactName();
            }
            event.threadID = conversationList.get(getAdapterPosition()).getThread();
            EventBus.getDefault().post(event);
        }
    }
}
