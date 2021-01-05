package GAAAA.AccountBook.Models;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

public class Record extends LitePalSupport {
    private int id;
    private String category_1;
    private String category_2;
    private String content;
    private double money;
    private Date date;
    private int state;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_1(String category_1) {
        this.category_1 = category_1;
    }

    public void setCategory_2(String category_2) {
        this.category_2 = category_2;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getCategory_1() {
        return category_1;
    }

    public String getCategory_2() {
        return category_2;
    }

    public String getContent() {
        return content;
    }

    public double getMoney() {
        return money;
    }

    public Date getDate() {
        return date;
    }

    public int getState() {
        return state;
    }
}
