package Bookings;

import org.openqa.selenium.By;

public class LandingPage {
    public static final By cookie = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    public static final By where_you_going = By.xpath("//input[@id='ss']");
    public static final By calendar_pop_up = By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']");
    public static final By navigation_forward = By.xpath("//div[@class='bui-calendar__control bui-calendar__control--next']");
    public static final By cal_date_left = By.xpath("//div[1]//div[1]/table//tbody//td[@data-bui-ref=\"calendar-date\"]");
    public static final By cal_date_right = By.xpath("//div[1]//div[2]/table//tbody//td[@data-bui-ref=\"calendar-date\"]");
    public static final By guest_filter = By.xpath("//span[@class=\"xp__guests__count\"]");
    public static final By guest_filter_add_button = By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"]");
    public static final By guest_filter_remove_button = By.xpath("//button[@data-bui-ref=\"input-stepper-subtract-button\"]");
    public static final By search = By.xpath("//button[@class=\"sb-searchbox__button \"]");
    public static final By guest_filter_value = By.xpath("//span[@class=\"bui-stepper__display\"]");
}
