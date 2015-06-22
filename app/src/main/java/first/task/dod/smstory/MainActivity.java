package first.task.dod.smstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import first.task.dod.smstory.adapter.ConversationAdapter;
import first.task.dod.smstory.presenter.IMainPresenter;
import first.task.dod.smstory.presenter.MainPresenter;
import first.task.dod.smstory.model.Conversation;
import first.task.dod.smstory.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.conversation_recyclerview)
    RecyclerView recyclerView;
    private IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        mainPresenter = new MainPresenter(this, getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showConversations(List<Conversation> conversations) {
        setupRecyclerView();
        recyclerView.setAdapter(new ConversationAdapter(conversations));
    }

    @Override
    public void showDetails(String name, String threadID) {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("THREAD_ID", threadID);
        startActivity(intent);
    }

    public void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
