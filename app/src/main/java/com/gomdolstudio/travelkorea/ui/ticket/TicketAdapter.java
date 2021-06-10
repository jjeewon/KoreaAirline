package com.gomdolstudio.travelkorea.ui.ticket;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.data.entity.Item;
import com.gomdolstudio.travelkorea.data.entity.Response;
import com.gomdolstudio.travelkorea.data.entity.Ticket;
import com.gomdolstudio.travelkorea.data.entity.TicketResponse;
import com.gomdolstudio.travelkorea.util.ViewBindingHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TicketAdapter extends RecyclerView.Adapter<ViewBindingHolder> {
    // 뷰 홀더용 뷰 모델 리스트 변수
    private final List<TicketItem> items = new ArrayList<>();

    // 생성자 인젝션
    @Inject
    public TicketAdapter(){ }

    // 레이아웃 종류
    @Override
    public int getItemViewType(int position){
        return R.layout.view_ticket;
    }

    // 뷰 홀더 생성
    @NonNull
    @Override
    public ViewBindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewBindingHolder(parent.getContext(), viewType);
    }

    // 뷰 홀더와 뷰 모델 바인딩
    @Override
    public void onBindViewHolder(@NonNull ViewBindingHolder holder, int position) {
        holder.getBinding().setVariable(BR.item, items.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setTickets(TicketResponse response, TicketViewModel viewModel){
        List<Item> responseItems = response.getItems();
        List<TicketItem> ticketItems = new ArrayList<>();
        for(Item item : responseItems){
            Ticket ticket = new Ticket(item.getVihicleId(), item.getAirlineNm(), item.getDepPlandTime(),
                    item.getArrPlandTime(), item.getEconomyCharge(), item.getPrestigeCharge()
                    , item.getDepAirportNm(), item.getArrAirportNm());
            TicketItem ticketItem = new TicketItem(ticket,viewModel);
            ticketItems.add(ticketItem);

        }


        this.items.clear();
        this.items.addAll(ticketItems);
        this.notifyDataSetChanged();
    }

    public void getError(Throwable error){
        String a = error.getStackTrace().toString();
    }



}
