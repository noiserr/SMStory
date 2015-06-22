package first.task.dod.smstory.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import first.task.dod.smstory.R;
import first.task.dod.smstory.model.Message;

/**
 * Created by noiser on 18.06.15.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }


    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new SentViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.sent_message_layout, parent, false));
        } else {
            return new RecivedViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recived_message_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messages.get(position);

        Date time = new Date(Long.valueOf(message.getDate()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        holder.message.setText(message.getBody());
        holder.date.setText(dateFormat.format(time));
        if (message.getType() == 1) {
            RecivedViewHolder recivedViewHolder = (RecivedViewHolder) holder;
            recivedViewHolder.iconLetter.setText(message.getContactName().substring(0,1));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).getType();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        protected TextView message;
        protected TextView date;


        public MessageViewHolder(View itemView) {
            super(itemView);
        }
    }

    class SentViewHolder extends MessageViewHolder {


        public SentViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.sent_message_textview);
            date = (TextView) itemView.findViewById(R.id.sent_message_time_textview);
        }
    }

    class RecivedViewHolder extends MessageViewHolder{

        TextView iconLetter;
        public RecivedViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.recived_message_textview);
            date = (TextView) itemView.findViewById(R.id.recived_time_textview);
            iconLetter = (TextView) itemView.findViewById(R.id.recived_image_letter);
        }
    }
}
