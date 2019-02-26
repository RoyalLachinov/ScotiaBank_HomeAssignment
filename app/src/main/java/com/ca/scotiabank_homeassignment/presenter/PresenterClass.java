package com.ca.scotiabank_homeassignment.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ca.scotiabank_homeassignment.api.RetroClient;
import com.ca.scotiabank_homeassignment.model.RepoDetail;
import com.ca.scotiabank_homeassignment.view.AdapterRepo;
import com.ca.scotiabank_homeassignment.view.MainActivity;
import com.ca.scotiabank_homeassignment.view.ViewImpl;

import java.util.ArrayList;
import java.util.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PresenterClass implements PresenterImpl {

    private ViewImpl view;


    public PresenterClass(ViewImpl view) {
        this.view = view;

    }

    @Override
    public void searchRepositories(String repoUserName) {

        if (repoUserName == null || repoUserName.isEmpty() || repoUserName.equals("")) {
            view.showWarning("Enter userName");
            return;
        }

        RetroClient.getApiService().getGithubUserRepositores("user:" + repoUserName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RepoDetail>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e);
                    }

                    @Override
                    public void onNext(RepoDetail repoDetails) {
                        if (repoDetails != null) {
                            view.loadRepositories(repoDetails);

                            view.showRepoUserPicture(repoDetails.getRepoItems().get(0).getRepoOwner().getRepoOwnerImageUrl());

                        } else {
                            view.showWarning("No repository found.");
                        }
                    }
                });
    }

}
