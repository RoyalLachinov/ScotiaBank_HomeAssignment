package com.ca.scotiabank_homeassignment.presenter;

import com.ca.scotiabank_homeassignment.model.RepoDetail;
import com.ca.scotiabank_homeassignment.view.ViewImpl;

import java.util.ArrayList;

public class PresenterClass implements PresenterImpl {

    private ViewImpl view;


    public PresenterClass(ViewImpl view) {
        this.view = view;

    }

    @Override
    public void loadRepositories(String repoUserName) {

        if (repoUserName == null || repoUserName.isEmpty() || repoUserName.equals("")) {
            view.showWarning("No repository found.");
            return;
        }

        view.showRepositories(repoUserName);

    }
}
