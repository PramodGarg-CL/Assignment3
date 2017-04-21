package cpm.example.sample.assignment3.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cpm.example.sample.assignment3.AppConstants;
import cpm.example.sample.assignment3.R;
import cpm.example.sample.assignment3.activity.ScreenCActivity;
import cpm.example.sample.assignment3.model.Event;

/**
 * Adapter for the RecyclerView
 */


public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.EventRecyclerVH> implements AppConstants {
    private List<Event> mEventList;
    /*
    @code determines in which fragment/ activity the current adapter is to be set
     */
    private int code;

    public EventRecyclerAdapter(List<Event> mEventList, int code) {
        this.code = code;
        this.mEventList = mEventList;
    }

    @Override
    public EventRecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new EventRecyclerVH(view);
    }

    @Override
    public void onBindViewHolder(EventRecyclerVH holder, int position) {
        Event currentEvent = mEventList.get(position);
            /*
            if recycler in activity disable time and place view
             */
        if (code == CODE_RECYCLER_LIST_EVENTS) {
            holder.place.setVisibility(View.INVISIBLE);
            holder.time.setVisibility(View.INVISIBLE);
        } else {
            /*
            if recycler is fragment make place and time view visible
             */
            holder.place.setVisibility(View.VISIBLE);
            holder.time.setVisibility(View.VISIBLE);
            holder.time.setText(currentEvent.getTitle());
            holder.place.setText(currentEvent.getPlace());
        }
        holder.title.setText(currentEvent.getTitle());

    }

    /*
    returns no of items in the recycler view
     */
    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    class EventRecyclerVH extends RecyclerView.ViewHolder {
        TextView title, place, time;

        public EventRecyclerVH(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_tv_title);
            place = (TextView) itemView.findViewById(R.id.item_tv_place);
            time = (TextView) itemView.findViewById(R.id.item_tv_time);
            if (code == 0) {
                /*
                enable onClick on recycler if in activity
                 */
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(),
                                ScreenCActivity.class);
                        intent.putExtra("position", getAdapterPosition());
                        itemView.getContext().startActivity(intent);
                    }
                });

            }
        }
    }
}
