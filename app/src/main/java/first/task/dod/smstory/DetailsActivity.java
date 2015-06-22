package first.task.dod.smstory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import first.task.dod.smstory.adapter.MessageAdapter;
import first.task.dod.smstory.presenter.IDetailPresenter;
import first.task.dod.smstory.presenter.DetailPresenter;
import first.task.dod.smstory.model.Message;
import first.task.dod.smstory.model.MessageCriteria;
import first.task.dod.smstory.view.DetailView;

public class DetailsActivity extends AppCompatActivity implements DetailView {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.messages_recyclerview)
    RecyclerView recyclerView;
    String contactName;
    String threadId;
    private IDetailPresenter IDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.inject(this);

        Bundle bundle= getIntent().getExtras();

        contactName = bundle.getString("NAME");
        threadId = bundle.getString("THREAD_ID");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(contactName);
        MessageCriteria criteria = new MessageCriteria();
        criteria.setThreadID(threadId);
        criteria.setName(contactName);
        IDetailPresenter = new DetailPresenter(getApplicationContext(),this, criteria);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IDetailPresenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessages(List<Message> messages) {
        setupRecyclerView();
        recyclerView.setAdapter(new MessageAdapter(messages));
    }

    public void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
