package io.plaidapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.plaidapp.ui.recyclerview.FilterSwipeDismissListener;

/**
 * Created by ${kelijun} on 2018/5/15.
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>  implements FilterSwipeDismissListener {
    final List<String> filters;
    private final Context context;
    public FilterAdapter(List<String> filters, @NonNull Context context) {
        this.filters = filters;
        this.context = context;
    }

    @Override
    public FilterAdapter.FilterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final FilterViewHolder holder = new FilterViewHolder(LayoutInflater.from(viewGroup
                .getContext()).inflate(R.layout.filter_item, viewGroup, false));
        holder.itemView.setOnClickListener(v -> {
            final int position = holder.getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) return;
            final String filter = filters.get(position);
            /*if (isAuthorisedDribbbleSource(filter) &&
                    !DribbblePrefs.get(holder.itemView.getContext()).isLoggedIn()) {
                authoriser.requestDribbbleAuthorisation(holder.filterIcon, filter);
            } else {
                filter.active = !filter.active;
                holder.filterName.setEnabled(filter.active);
                notifyItemChanged(position, filter.active ? FilterAnimator.FILTER_ENABLED
                        : FilterAnimator.FILTER_DISABLED);
                SourceManager.updateSource(filter, holder.itemView.getContext());
                dispatchFiltersChanged(filter);
            }*/
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FilterAdapter.FilterViewHolder holder, int position) {
        final String filter = filters.get(position);
       // holder.isSwipeable = filter.isSwipeDismissable();
        holder.filterName.setText(filter);
       // holder.filterName.setEnabled(filter.active);
       /* if (filter.iconRes > 0) {
            holder.filterIcon.setImageDrawable(
                    holder.itemView.getContext().getDrawable(filter.iconRes));
        }
        holder.filterIcon.setImageAlpha(filter.active ? FILTER_ICON_ENABLED_ALPHA :
                FILTER_ICON_DISABLED_ALPHA);*/
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public static class FilterViewHolder extends RecyclerView.ViewHolder {

        public TextView filterName;
        public ImageView filterIcon;
        public boolean isSwipeable;

        public FilterViewHolder(View itemView) {
            super(itemView);
            filterName = itemView.findViewById(R.id.filter_name);
            filterIcon = itemView.findViewById(R.id.filter_icon);
        }
    }
}
