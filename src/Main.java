import ModelsPack.TableModel;
import PresenterPack.BookingPresenter;
import ViewPack.BookingView;

import java.util.Date;

public class Main {
    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     *
     * Номер брони остается тот же, а номер столика в этой брони меняется.
     *
     */
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);
        bookingPresenter.updateTablesUI();

        view.reservationTable(new Date(), 3, "Станислав");

        view.changeReservationTable(101, new Date(), 1, "Станислав");
    }

}