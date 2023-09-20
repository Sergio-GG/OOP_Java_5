package ViewPack;

import ModelsPack.Table;
import PresenterPack.ViewObserver;
import PresenterPack.View;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View{
    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo, int tableNo) {
        if (reservationNo > 0)
            System.out.println("Столик успешно забронирован. Номер вашей брони: " + reservationNo + ". Столик №: " + tableNo );
        else
            System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
    }

    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }
}
