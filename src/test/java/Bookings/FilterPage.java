package Bookings;

import org.openqa.selenium.By;

public class FilterPage {
    public static final By star = By.xpath("//*[@id=\"filter_class\"]/div/a");
    public static final By facilities_button = By.xpath("//*[@id=\"filter_facilities\"]/div[2]/button[1]");
    public static final By facilities_filter = By.xpath("//*[@id=\"filter_facilities\"]/div/a");
    public static final By hotels_list = By.xpath("//*[@id=\"hotellist_inner\"]//a[@class=\"hotel_name_link url\"]/span[1]");
}
