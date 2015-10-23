package org.voiddog.recyclewheelview.test;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.voiddog.recyclewheelview.RecycleWheelView;
import org.voiddog.recyclewheelview.TextWheelAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecycleWheelView rv_wheel;
    TextWheelAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAdapter = new TextWheelAdapter<>(this);
        mAdapter.setTextPadding(dp2px(this, 15));
        mAdapter.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        rv_wheel = (RecycleWheelView) findViewById(R.id.rv_wheel);
        rv_wheel.setOnSelectListener(new RecycleWheelView.OnSelectItemListener() {
            @Override
            public void onSelectChanged(int position) {
                Toast.makeText(MainActivity.this, String.format("select at: %d", position), Toast.LENGTH_SHORT).show();
            }
        });
        setupWheel();
    }

    void setupWheel(){
        rv_wheel.setAdapter(mAdapter);

        List<String> dataList = new ArrayList<>();
        for(int i = 0 ; i  < 30; i++){
            dataList.add(String.format("傻逼%d号", i));
        }
        mAdapter.setData(dataList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 输入dp 转换为 px
     * @param context 上下文
     * @param dp 要转换的dp的数值
     * @return dp 转换成 px 后的数值
     */
    public static int dp2px(Context context, float dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
