package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.data.ratings.entities.authority.Authority;
import com.example.myapplication.di.AppComponent;
import com.example.myapplication.ui.authority.AuthorityActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivityTAG_";

    @BindView(R.id.a_main_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.a_main_progress)
    ProgressBar progressBar;

    @Inject
    MainContract.Presenter presenter;

    private List<Authority> authorities;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupDaggerComponent();
        setupRecyclerView();

        presenter.attachView(this);
        presenter.loadAuthorities();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    public void updateAuthorities(List<Authority> authorities) {
        this.authorities.clear();
        this.authorities.addAll(authorities);
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void setupRecyclerView() {
        authorities = new ArrayList<>();
        mainAdapter = new MainAdapter(authorities, authority ->
                AuthorityActivity.newActivity(MainActivity.this,
                        authority.getLocalAuthorityId(),
                        authority.getName(),
                        authority.getEstablishmentCount()));

        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void setupDaggerComponent() {
        AppComponent appComponent = ((App) getApplication()).getAppComponent();

        DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .appComponent(appComponent)
                .build()
                .inject(this);
    }
}
