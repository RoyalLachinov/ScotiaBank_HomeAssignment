package com.ca.scotiabank_homeassignment.view;

import com.ca.scotiabank_homeassignment.model.RepoDetail;

import java.util.ArrayList;

public interface ViewImpl {

    void showError(Throwable error);

    void loadRepositories(RepoDetail repoDetails);

    void showRepoUserPicture(String pictureUrl);

    void showWarning(String warning);

    void showRepoDetail(String updateDate, int starCount, int forksCount);

}
