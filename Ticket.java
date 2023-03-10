import java.util.ArrayList;


public class Ticket {

    int row;
    int seat;
    float price;
    person person_new;

    ArrayList<Ticket> ticket_list_sort = new ArrayList<Ticket>();


    Ticket( int row, int seat, float price, person person_new) {

        this.row = row;
        this.price = price;
        this.seat = seat;
        this.person_new = person_new;

    }


    int print() {
        System.out.println("\nname:" + person_new.name + "\n" + "surname:" + person_new.sur_name +
                "\n" + "email:" + person_new.email + "\n" + "row:" + row + "\n" + "seat:" + seat + "\n" + "price:" + price + "\n"
                );


        return 0;


    }

    public float getPrice() {
        return price;
    }




   /* @Override
    public int compareTo(Ticket o) {
        if (getPrice() == o.getPrice()) {
            return (int) (getPrice() - o.getPrice());
        } else
            return (int) (getPrice() - o.getPrice());
    }

    }*/
}


