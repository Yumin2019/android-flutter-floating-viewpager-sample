package org.tensorflow.lite.examples.objectdetection;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPage extends RecyclerView.ViewHolder {

    private TextView tv_title;
    private RelativeLayout rl_layout;

    private ImageView imageView;

    DataPage data;

    ViewHolderPage(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        rl_layout = itemView.findViewById(R.id.rl_layout);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void onBind(DataPage data){
        this.data = data;

        tv_title.setText(data.getTitle());
        rl_layout.setBackgroundResource(data.getColor());

        if(data.imageId != -1) {
            imageView.setImageResource(data.imageId);
        }
    }
}
