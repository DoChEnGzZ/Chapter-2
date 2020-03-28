package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private Button button1,button2;
//    private TextView newtext;
    private int viewnum=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_exersize2);
        View root=(View)getLayoutInflater().inflate(R.layout.acticity_exersize2,null);
        final RelativeLayout relativeLayout;
        relativeLayout=(RelativeLayout)findViewById(R.id.tv_RL);
        viewnum=relativeLayout.getChildCount();
        button1=(Button)findViewById(R.id.center);
//        button2=(Button)findViewById(R.id.btn_left_top);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView newtext=new TextView(this)
//            }
//        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setText(String.valueOf(viewnum));
            }
        });
    }

//    public int getAllChildViewCount(View view) {
//        int num;
//        num=view.get
//        return 0;
//    }
}
