package com.example.myapplication.ui.authority;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.di.AppComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthorityActivity extends AppCompatActivity implements AuthorityContract.View {

    private static final String TAG = "AuthorityActivityTAG_";

    private static final String KEY_EXTRA_ID = "EXTRA_ID";
    private static final String KEY_EXTRA_NAME = "EXTRA_NAME";
    private static final String KEY_EXTRA_NUMBER = "EXTRA_NUMBER";

    private static final int DEFAULT_ID = 177;
    private static final int DEFAULT_NUMBER = 953;

    @BindView(R.id.a_authority_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.a_authority_progress)
    ProgressBar progressBar;
    @BindView(R.id.a_authority_text)
    TextView textView;

    @Inject
    AuthorityContract.Presenter presenter;

    private TreeMap<String, Double> map;
    private AuthorityAdapter authorityAdapter;

    private int establishmentId;
    private int numberEstablishments;

    public static void newActivity(Context context, int id, String name, int numberEstablishments) {
        Intent intent = new Intent(context, AuthorityActivity.class);
        intent.putExtra(KEY_EXTRA_ID, id);
        intent.putExtra(KEY_EXTRA_NAME, name);
        intent.putExtra(KEY_EXTRA_NUMBER, numberEstablishments);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority);

        ButterKnife.bind(this);

        setupDaggerComponent();
        getInfoFromIntent(getIntent());
        setupRecyclerView();

        presenter.attachView(this);
        presenter.loadEstablishments(establishmentId, numberEstablishments);
    }

    private void setupRecyclerView() {
        map = new TreeMap<>();
        authorityAdapter = new AuthorityAdapter(map);

        recyclerView.setAdapter(authorityAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void getInfoFromIntent(Intent intent) {
        establishmentId = intent.getIntExtra(KEY_EXTRA_ID, DEFAULT_ID);
        numberEstablishments = intent.getIntExtra(KEY_EXTRA_NUMBER, DEFAULT_NUMBER);

        String name = intent.getStringExtra(KEY_EXTRA_NAME);
        setupToolbar(name);
    }

    private void setupToolbar(String name) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(name);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("Loading " + numberEstablishments + " establishments");
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateEstablishments(TreeMap<String, Double> map) {
        Map<String, Double> tmp = new HashMap<>(map);
        tmp.keySet().removeAll(this.map.keySet());
        this.map.putAll(tmp);

        authorityAdapter.notifyDataSetChanged();
    }

    private void setupDaggerComponent() {
        AppComponent appComponent = ((App) getApplication()).getAppComponent();

        DaggerAuthorityComponent.builder()
                .appComponent(appComponent)
                .authorityModule(new AuthorityModule())
                .build()
                .inject(this);
    }
}
