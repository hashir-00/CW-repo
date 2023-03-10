import java.util.Comparator;

public class Sort_ticket implements Comparator<Ticket> {
        public int compare(Ticket ticket1, Ticket ticket2) {
            if (ticket1.getPrice()<( ticket2.getPrice())) {
                return 0;
            } else {
                return -1;
            }



        }
}

