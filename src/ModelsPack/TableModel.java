package ModelsPack;

import PresenterPack.Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class TableModel implements Model{
    private Collection<Table> tables;

    /**
     * Получить список всех столиков
     * @return коллекция столиков
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }


    /**
     * Бронирование столика
     * @param reservationDate дата
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */


    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }


    // Метод замены номера столика
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            for (Reservation reservation : table.getReservations()) {
                if (oldReservation == reservation.getId()) {
                    return reservation.getId();
                }
            }
        }
        return  -1;
    }
}

