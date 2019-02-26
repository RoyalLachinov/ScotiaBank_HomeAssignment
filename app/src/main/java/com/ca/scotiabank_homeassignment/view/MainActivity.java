package com.ca.scotiabank_homeassignment.view;

import android.graphics.Color;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ca.scotiabank_homeassignment.R;
import com.ca.scotiabank_homeassignment.api.ApiService;
import com.ca.scotiabank_homeassignment.api.RetroClient;
import com.ca.scotiabank_homeassignment.model.RepoDetail;
import com.ca.scotiabank_homeassignment.presenter.PresenterClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ViewImpl, View.OnClickListener {

    @BindView(R.id.parentLayout)
    ConstraintLayout parentLayout;
    EditText etSearch;
    Button btnSearch;
    ImageView imgUserPicture;
    RecyclerView listViewRepo;

    private PresenterClass presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        presenter = new PresenterClass(this);
    }

    private void initViews() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        imgUserPicture = (ImageView) findViewById(R.id.imgUserPicture);
        listViewRepo = (RecyclerView) findViewById(R.id.listRepo);

        findViewById(R.id.btnSearch).setOnClickListener(this);

    }


    @Override
    public void loadRepositories(RepoDetail repoDetails) {

        imgUserPicture.setVisibility(View.VISIBLE);
        listViewRepo.setVisibility(View.VISIBLE);

        listViewRepo.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        listViewRepo.setAdapter(new AdapterRepo(MainActivity.this, repoDetails.getRepoItems()));
        listViewRepo.setHasFixedSize(true);
        listViewRepo.setItemViewCacheSize(20);
        listViewRepo.setDrawingCacheEnabled(true);
        listViewRepo.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        listViewRepo.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void showError(Throwable t) {
        Log.e("error_hap", t.getMessage());
    }

    @Override
    public void showWarning(String warning) {
        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRepoDetail(String updateDate, int starCount, int forksCount) {

        Toast.makeText(this, "Last Updated: " + updateDate + "\n" +
                "Stars:  " + starCount + "\n" +
                "Forks:  " + forksCount, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRepoUserPicture(String pictureUrl) {

        Glide.with(imgUserPicture.getContext())
                .load(pictureUrl)
                .into(imgUserPicture);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSearch:
                presenter.searchRepositories(etSearch.getText().toString());
                break;
        }
    }
}
