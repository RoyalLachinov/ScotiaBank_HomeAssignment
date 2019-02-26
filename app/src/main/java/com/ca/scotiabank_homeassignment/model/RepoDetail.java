package com.ca.scotiabank_homeassignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RepoDetail {



    @SerializedName("items")
    ArrayList<RepoItem>repoItems;

    public ArrayList<RepoItem> getRepoItems() {
        return repoItems;
    }

    public void setRepoItems(ArrayList<RepoItem> repoItems) {
        this.repoItems = repoItems;
    }

    public class RepoItem {

        @SerializedName("name")
        private String repoName;
        @SerializedName("description")
        private String repoDescription;
        @SerializedName("updated_at")
        private String repoUpdateDate;
        @SerializedName("stargazers_count")
        private int repoStarCount;
        @SerializedName("forks_count")
        private int forksCount;
        @SerializedName("owner")
        RepoOwner repoOwner;

        public String getRepoName() {
            return repoName;
        }

        public void setRepoName(String repoName) {
            this.repoName = repoName;
        }

        public String getRepoDescription() {
            return repoDescription;
        }

        public void setRepoDescription(String repoDescription) {
            this.repoDescription = repoDescription;
        }

        public String getRepoUpdateDate() {
            return repoUpdateDate;
        }

        public void setRepoUpdateDate(String repoUpdateDate) {
            this.repoUpdateDate = repoUpdateDate;
        }

        public int getRepoStarCount() {
            return repoStarCount;
        }

        public void setRepoStarCount(int repoStarCount) {
            this.repoStarCount = repoStarCount;
        }

        public int getForksCount() {
            return forksCount;
        }

        public void setForksCount(int forksCount) {
            this.forksCount = forksCount;
        }

        public RepoOwner getRepoOwner() {
            return repoOwner;
        }

        public void setRepoOwner(RepoOwner repoOwner) {
            this.repoOwner = repoOwner;
        }

    }


    public class RepoOwner {

        @SerializedName("avatar_url")
        String repoOwnerImageUrl;

        public String getRepoOwnerImageUrl() {
            return repoOwnerImageUrl;
        }

        public void setRepoOwnerImageUrl(String repoOwnerImageUrl) {
            this.repoOwnerImageUrl = repoOwnerImageUrl;
        }
    }

}
