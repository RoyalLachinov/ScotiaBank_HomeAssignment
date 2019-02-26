package com.ca.scotiabank_homeassignment.view;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ca.scotiabank_homeassignment.R;
import com.ca.scotiabank_homeassignment.model.RepoDetail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterRepo extends RecyclerView.Adapter<AdapterRepo.ViewHolder> {

    private ViewImpl viewImpl;
    private ArrayList<RepoDetail.RepoItem> repoDetails;


    public AdapterRepo(ViewImpl viewImpl, ArrayList<RepoDetail.RepoItem> repoDetails) {

        this.viewImpl = viewImpl;
        this.repoDetails = repoDetails;
    }

    @Override
    public int getItemCount() {
        return repoDetails.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder contactViewHolder, final int i) {

        contactViewHolder.txtRepoName.setText(repoDetails.get(i).getRepoName());
        contactViewHolder.txtRepoDescription.setText(repoDetails.get(i).getRepoDescription());

        contactViewHolder.repoItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImpl.showRepoDetail(repoDetails.get(i).getRepoUpdateDate(), repoDetails.get(i).getRepoStarCount(), repoDetails.get(i).getForksCount());

            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_repo, viewGroup, false);

        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repoItemLayout)
        protected LinearLayout repoItemLayout;

        @BindView(R.id.txtRepoName)
        protected TextView txtRepoName;

        @BindView(R.id.txtRepoDescription)
        protected TextView txtRepoDescription;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}

