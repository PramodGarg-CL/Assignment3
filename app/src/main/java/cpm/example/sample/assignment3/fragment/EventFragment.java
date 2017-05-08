package cpm.example.sample.assignment3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cpm.example.sample.assignment3.R;
import cpm.example.sample.assignment3.adapter.EventRecyclerAdapter;
import cpm.example.sample.assignment3.model.Event;

/*
 * Created by darknight on 20/4/17.
 */

public class EventFragment extends BaseFragment {
    private RecyclerView recyclerView;
    /*
    @code : determines the type fragment represents
     */
    private int code;
    // contains data to be displayed
    private List<Event> eventList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycler_view, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.frag_rv);
        setCode();
        EventRecyclerAdapter eventRecyclerAdapter = new EventRecyclerAdapter(eventList, code);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(eventRecyclerAdapter);
    }

    /**
     * Returns instance of @{@link EventFragment}
     *
     * @param code : determine fragment type
     * @return instance of EventFragment
     */
    public static EventFragment getInstance(int code) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", code);
        EventFragment myFragment = new EventFragment();
        myFragment.setArguments(bundle);
        return myFragment;
    }

    /*
    Retreive the code from the bundle and set to @code
     */
    private void setCode() {
        code = getArguments().getInt("code");
        setData(code);
    }

    /*
    add dummy data to the @eventList
     */
    public void setData(int code) {
        eventList = new ArrayList<>();
        switch (code) {
            /*
            Add dummy data to the list according to the fragment code
             */
            case CODE_FRAGMENT_EVENT_ACCEPTED:
                eventList.add(new Event(getString(R.string.dummy_data_accept_1), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_accept_2), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_accept_3), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                break;
            case CODE_FRAGMENT_EVENT_CANCELLED:
                eventList.add(new Event(getString(R.string.dummy_data_cancel_1), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_cancel_2), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_cancel_3), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                break;
            case CODE_FRAGMENT_EVENT_COMPLETED:
                eventList.add(new Event(getString(R.string.dummy_data_complete_1), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_complete_2), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_complete_3), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                break;
            case CODE_FRAGMENT_EVENT_PENDING:
                eventList.add(new Event(getString(R.string.dummy_data_pending_1), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_pending_2), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                eventList.add(new Event(getString(R.string.dummy_data_pending_3), getString(R.string.dummy_date),
                        getString(R.string.dummy_place), code));
                break;
            default:
                Toast.makeText(getActivity(), R.string.no_data, Toast.LENGTH_SHORT).show();
        }

    }
}
