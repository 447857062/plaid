package io.plaidapp;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.plaidapp.ui.recyclerview.FilterTouchHelperCallback;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.filters)
    RecyclerView filters;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    FilterAdapter filtersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //为recycle设置适配器
        filters.setAdapter(filtersAdapter);
        //为recycleview设置触摸事件
        ItemTouchHelper.Callback callback = new FilterTouchHelperCallback(filtersAdapter, this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(filters);
    }

}
