package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDTO {
    private int u_id;
    private String uu_id;
    private String password;
    private String phone;
    private int money;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public String toString() {
        String createDate = created_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String updateDate = "";
        if (updated_at != null) {
            updateDate = updated_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        }
        String str = String.format("%d \t %s \t %s \t %s \t %d \s %b  \t %s"
                , u_id, uu_id, password, phone, money, createDate, updateDate);
        return str;
    }

    public int getId() {
        return u_id;
    }

    public void setId(int u_id) {
        this.u_id = u_id;
    }

    public String getuu_Id() {
        return uu_id;
    }

    public void setUsId(String uu_id) {
        this.uu_id = uu_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
