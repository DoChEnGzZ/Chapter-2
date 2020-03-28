package chapter.android.aweme.ss.com.homework.widget;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.Exercises3;
import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;


public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder>{

    private int itemlists;
    final List<Message> messages;
    Context context1;
    public TextAdapter(List<Message> messages,Context context)
    {
        this.messages=messages;
        itemlists=messages.size();
        context1=context;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.im_list_item,parent,false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TextViewHolder textViewHolder, final int postion) {
        if(messages.get(postion).isOfficial()){
            textViewHolder.robot_notice.setVisibility(View.VISIBLE);
            Log.d("offcial "+String.valueOf(postion)+":",String.valueOf(messages.get(postion).isOfficial()));
        }
        else{
            textViewHolder.robot_notice.setVisibility(View.INVISIBLE);
        }
        textViewHolder.title.setText(messages.get(postion).getTitle());
        textViewHolder.description.setText(messages.get(postion).getDescription());
        textViewHolder.time.setText(messages.get(postion).getTime());
        switch (messages.get(postion).getIcon()){
            case"TYPE_ROBOT":
                textViewHolder.icon.setImageResource(R.drawable.session_robot);
                break;
            case"TYPE_GAME"  :
                textViewHolder.icon.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case"TYPE_SYSTEM":
                textViewHolder.icon.setImageResource(R.drawable.session_system_notice);
                break;
            case"TYPE_STRANGER":
                textViewHolder.icon.setImageResource(R.drawable.session_stranger);
                break;
            case"TYPE_USER":
                textViewHolder.icon.setImageResource(R.drawable.icon_girl);
                break;
        }
        textViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putInt("postion",postion);
                Intent intent=new Intent(context1,messagesjump.class);
                intent.putExtras(bundle);
                context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemlists;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView icon;
        private ImageView robot_notice;
        private TextView title;
        private TextView description;
        private TextView time;

        public TextViewHolder(View itemview) {
            super(itemview);
            icon=(CircleImageView) itemview.findViewById(R.id.iv_avatar);
            robot_notice=(ImageView)itemview.findViewById(R.id.robot_notice);
            title=(TextView)itemview.findViewById(R.id.tv_title);
            description=(TextView)itemview.findViewById(R.id.tv_description);
            time=(TextView)itemview.findViewById(R.id.tv_time);
        }
    }
}
