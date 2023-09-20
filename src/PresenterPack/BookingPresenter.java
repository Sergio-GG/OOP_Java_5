package PresenterPack;


import ModelsPack.Table;
import ModelsPack.TableModel;
import ViewPack.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model tableModel;
    private final View bookingView;

    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    public Collection<Table> loadTables(){
        return tableModel.loadTables();
    }
    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }

    public void updateReservationResultUI(int reservationId, int tableNo){
        bookingView.printReservationTableResult(reservationId, tableNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
        updateReservationResultUI(reservationNo, tableNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = tableModel.changeReservationTable(oldReservation,reservationDate, tableNo, name);
        updateReservationResultUI(reservationNo, tableNo);
    }
}

