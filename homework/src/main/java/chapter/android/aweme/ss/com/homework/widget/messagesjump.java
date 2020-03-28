package chapter.android.aweme.ss.com.homework.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import chapter.android.aweme.ss.com.homework.R;

public class messagesjump extends AppCompatActivity {

    private TextView textView;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagesjump);
        textView=(TextView)findViewById(R.id.jump);
        bundle=getIntent().getExtras();
        textView.setText("当前itemview排序是"+String.valueOf(bundle.getInt("postion")+1));
    }
}
