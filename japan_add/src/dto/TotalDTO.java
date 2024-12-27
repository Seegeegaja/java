package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TotalDTO {
    private int t_id;
    private int u_id;
    private int p_id;
    private int price;
    private LocalDateTime insert_date;

    @Override
    public String toString() {
        String insertDate = insert_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String str = String.format("%d \t %d \t %d \t %d \t %s "
                , t_id, u_id, p_id, price, insertDate);
        return str;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(LocalDateTime insert_date) {
        this.insert_date = insert_date;
    }
}
