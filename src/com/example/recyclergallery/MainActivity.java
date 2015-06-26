package com.example.recyclergallery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.recyclergallery.GalleryAdapter.OnItemClickLitener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RecyclerView mRecyclerView;
	private GalleryAdapter mAdapter;
	private List<Integer> mDatas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initDatas();
		// 得到控件
		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
		// 设置布局管理器
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mRecyclerView.setLayoutManager(linearLayoutManager);

		// 设置适配器
		mAdapter = new GalleryAdapter(this, mDatas);
		mAdapter.setOnItemClickLitener(new OnItemClickLitener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(MainActivity.this, position + "",
						Toast.LENGTH_SHORT).show();
			}
		});
		mRecyclerView.setAdapter(mAdapter);

	}

	private void initDatas() {
		mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.head1,
				R.drawable.head2, R.drawable.head3, R.drawable.head4,
				R.drawable.head5, R.drawable.head6, R.drawable.head7,
				R.drawable.head8));
	}

}
