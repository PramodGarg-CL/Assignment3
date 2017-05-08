package cpm.example.sample.assignment3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cpm.example.sample.assignment3.R;
import cpm.example.sample.assignment3.adapter.EventRecyclerAdapter;
import cpm.example.sample.assignment3.model.Event;

/**
 * Displays the items
 */

public class ScreenBActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.frag_rv);
        List<Event> listEvent = new ArrayList<>();
        /*
        Dummy items to be displayed in the Recycler View
         */
        listEvent.add(new Event("ItemName1", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName2", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName3", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName4", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName5", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName6", null, null, CODE_RECYCLER_LIST_EVENTS));
        listEvent.add(new Event("ItemName7", null, null, CODE_RECYCLER_LIST_EVENTS));
        recyclerView.setAdapter(new EventRecyclerAdapter(listEvent, CODE_RECYCLER_LIST_EVENTS));
        recyclerView.setLayoutManager(new LinearLayoutManager(ScreenBActivity.this));
    }
}
