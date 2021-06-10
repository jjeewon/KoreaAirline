package com.gomdolstudio.travelkorea.ui.ticket;

import com.gomdolstudio.travelkorea.data.entity.Ticket;

public class TicketItem {
    private Ticket ticket;
    private EventListener eventListener;

    public TicketItem(Ticket ticket, EventListener eventListener){
        this.ticket = ticket;
        this.eventListener = eventListener;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getVihicleId() {
        return ticket.getVihicleId();
    }

    public String getAirlineNm() {
        return ticket.getAirlineNm();
    }

    public String getDepPlandTime() {
        return Long.toString(ticket.getDepPlandTime());
    }

    public String getArrAirportNm() {
        return ticket.getArrAirportNm();
    }

    public String getArrPlandTime() {
        return Long.toString(ticket.getArrPlandTime());
    }

    public String getDepAirportNm() {
        return ticket.getDepAirportNm();
    }

    public String getEconomyCharge() {
        return Long.toString(ticket.getEconomyCharge());
    }

    public String getPrestigeCharge() {
        return Long.toString(ticket.getPrestigeCharge());
    }

    public EventListener getEventListener(){
        return eventListener;
    }

    public interface EventListener{
        void onTicketClick(TicketItem ticket);
    }
}
