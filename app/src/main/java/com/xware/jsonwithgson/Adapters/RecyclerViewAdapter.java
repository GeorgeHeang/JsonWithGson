package com.xware.jsonwithgson.Adapters;


import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.xware.jsonwithgson.Models.User;
import com.xware.jsonwithgson.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private static final String TAG = "CustomAdapter";

    private List<User> Users;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvUserName, tvDateAdded;
        private Button btComplain, btSendComplain;
        private LinearLayout complainPart;
        private ToggleButton tbtLove;
        private ImageView ivPhoto, ivUser;
        private EditText etComplain;

        public TextView getTvUserName()
        {
            return tvUserName;
        }

        public TextView getTvDateAdded()
        {
            return tvDateAdded;
        }

        public Button getBtSendComplain()
        {
            return btSendComplain;
        }

        public LinearLayout getComplainPart()
        {
            return complainPart;
        }

        public ToggleButton getTbtLove()
        {
            return tbtLove;
        }

        public ImageView getIvPhoto()
        {
            return ivPhoto;
        }

        public ImageView getIvUser()
        {
            return ivUser;
        }

        public EditText getEtComplain()
        {
            return etComplain;
        }

        ViewHolder(View v)
        {
            super(v);

            tvUserName = (TextView) v.findViewById(R.id.tvUser);
            tvDateAdded = (TextView) v.findViewById(R.id.tvDateAdded);
            btSendComplain = (Button) v.findViewById(R.id.btSendComplain);
            btComplain = (Button) v.findViewById(R.id.btComplain);
            complainPart = (LinearLayout) v.findViewById(R.id.complainPart);
            tbtLove = (ToggleButton) v.findViewById(R.id.tbtLove);
            ivPhoto = (ImageView) v.findViewById(R.id.ivPhoto);
            ivUser = (ImageView) v.findViewById(R.id.ivUser);
            etComplain=(EditText)v.findViewById(R.id.etComplain);

            btComplain.setOnClickListener(this::ButtonComplainClicked);
        }

        private void ButtonComplainClicked(View view)
        {
            if (complainPart.getVisibility() == View.VISIBLE)
                complainPart.setVisibility(View.GONE);
            else
                complainPart.setVisibility(View.VISIBLE);
        }
    }

    public RecyclerViewAdapter(List<User> users)
    {
        Users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_layout, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position)
    {
        viewHolder.getBtSendComplain().setOnClickListener(v -> SendComplainClicked(viewHolder.getEtComplain(), viewHolder.getComplainPart()));
        viewHolder.getTvUserName().setText(Users.get(position).getName());
        viewHolder.getTvDateAdded().setText(new SimpleDateFormat("'On' dd-MMMM-yyyy 'at' hh:mm aaa").format(Users.get(position).getDateOfBirth()));
    }

    private void SendComplainClicked(EditText etComplain, LinearLayout complainPart)
    {
        if (etComplain.getText().toString().trim() != "")
        {
            Log.i(TAG, "SendComplainClicked: "+etComplain.getText());
        }
        complainPart.setVisibility(View.GONE);
        etComplain.setText("");
    }


    @Override
    public int getItemCount()
    {
        return Users.size();
    }
}