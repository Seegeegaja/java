package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductDTO {
    private int p_id;
    private String product;
    private int price;
    private int stock;
    private boolean status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public String toString() {
        String createDate = created_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String updateDate = "";
        if (updated_at != null) {
            updateDate = updated_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
        String str = String.format("%d \t %s \t %d \t %d \t %b \t %s \t %s"
                , p_id, product, price, stock, status, createDate, updateDate);

        return str;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
