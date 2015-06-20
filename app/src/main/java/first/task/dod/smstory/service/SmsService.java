package first.task.dod.smstory.service;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import first.task.dod.smstory.entity.Conversation;
import first.task.dod.smstory.entity.Message;

public class SmsService {
    private static String ADDRESS = "address";
    private static String BODY = "body";

    private Context context;

    public SmsService(Context context) {
        this.context = context;
    }

    public List<Message> getAllMessagessForConversation(String contactName, String threadID) {
        List<Message> messageList = new ArrayList<>();
        Uri sentURI = Uri.parse("content://sms/");
        ContentResolver crS = context.getContentResolver();
        Cursor cursor = crS.query(sentURI, null, "thread_id='" + threadID + "'", null, "date DESC");
        while (cursor.moveToNext()) {
            messageList.add(parseMessage(cursor));
        }
        return messageList;
    }

    public List<Conversation> getAllConversations() {
        List<Conversation> conversations = new ArrayList<>();
        Uri sentURI = Uri.parse("content://mms-sms/conversations/");
        ContentResolver crS = context.getContentResolver();
        Cursor cursor = crS.query(sentURI, null, null, null, "date DESC");
        while (cursor.moveToNext()) {
            conversations.add(parseConversation(cursor));
        }
        return conversations;
    }

    public Message parseMessage(Cursor cursor) {
        String address = cursor.getString(cursor.getColumnIndex("address"));
        String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        String userName = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
        String type = cursor.getString(cursor.getColumnIndexOrThrow("type"));
        String thread = cursor.getString(cursor.getColumnIndexOrThrow("thread_id"));
        String contactName = findContactName(address);

        Message message = new Message();
        message.setContactName(contactName);
        message.setBody(body);
        message.setDate(date);
        message.setType(Integer.valueOf(type));

        return message;
    }

    public Conversation parseConversation(Cursor cursor) {
        String address = cursor.getString(cursor.getColumnIndex("address"));
        String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
        String thread = cursor.getString(cursor.getColumnIndexOrThrow("thread_id"));
        String userName = findContactName(address);

        Conversation conversation = new Conversation();
        conversation.setThread(thread);
        conversation.setContactName(userName);
        conversation.setDateFromUnix(new Long(date));
        conversation.setLastMessage(body);
        conversation.setContactAddress(address);
        return conversation;
    }



    private String findContactName(String address) {
        Uri personUri = Uri.withAppendedPath(
                ContactsContract.PhoneLookup.CONTENT_FILTER_URI, address);
        Cursor cursor = context.getContentResolver().query(personUri,
                new String[] { ContactsContract.PhoneLookup.DISPLAY_NAME },
                null, null, null );
        if( cursor.moveToFirst() ) {
            int nameIdx = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            String name = cursor.getString(nameIdx);
            Log.d("SMSC", name);
            cursor.close();
            return name;

        }
        return "Unknown";
    }
}
