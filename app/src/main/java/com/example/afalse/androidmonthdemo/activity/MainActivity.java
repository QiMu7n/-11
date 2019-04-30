package com.example.afalse.androidmonthdemo.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.afalse.androidmonthdemo.PortService.DynastyService;
import com.example.afalse.androidmonthdemo.R;
import com.example.afalse.androidmonthdemo.SQLite.SQLiteHelper;
import com.example.afalse.androidmonthdemo.adapter.MyBeanTextAdapter;
import com.example.afalse.androidmonthdemo.bean.DynastyBean;
import com.example.afalse.androidmonthdemo.bean.DynastyText;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private List<DynastyBean.ResultBean> list=new ArrayList<>();
    private MyBeanTextAdapter myBeanTextAdapter;
    private String pager="";
    private int path=1;
    private SQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private List<DynastyText> dynastyTextList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new SQLiteHelper(this);
        db=helper.getWritableDatabase();
        initView();
        initrefresh();
        initretrofit();
        initCursor();
    }

    //数据库遍历方法
    private void initCursor() {
        db=helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from poetry",null);
        while(cursor.moveToNext()){
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String count=cursor.getString(cursor.getColumnIndex("count"));
            dynastyTextList.add(new DynastyText(title,count));
        }
        Log.i("hh",dynastyTextList.toString());
    }

    //数据库插入方法
    private void initinsert() {
        for(int i=0;i<list.size();i++){
            db.execSQL("insert into poetry values(?,?)",
                    new String[]{list.get(i).getTitle(),list.get(i).getContent()});
        }
    }
    //刷新
    private void initrefresh() {
        swipeRefresh.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        path++;
                        initretrofit();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        },2000);
    }
    //retrofit请求
    private void initretrofit() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        DynastyService service = retrofit.create(DynastyService.class);
        Call<DynastyBean> call = service.getDynasty(pager+path, "10");
        call.enqueue(new Callback<DynastyBean>() {
            @Override
            public void onResponse(Call<DynastyBean> call, Response<DynastyBean> response) {
                list=response.body().getResult();
                myBeanTextAdapter.refresh(list);
                initinsert();
            }

            @Override
            public void onFailure(Call<DynastyBean> call, Throwable t) {

            }
        });

    }
    //数据初始化
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        myBeanTextAdapter=new MyBeanTextAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myBeanTextAdapter);
    }
}
