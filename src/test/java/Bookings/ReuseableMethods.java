package Bookings;

import Entities_UI.SeleniumBasicMethods;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static Bookings.LandingPage.*;

public class ReuseableMethods {

    public void calendar_input(SeleniumBasicMethods reuseable, int num_days, int num_months) {
        reuseable.clickonElement(calendar_pop_up);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toInstant());
        String date_today = cal.toInstant().toString();
        if (num_months == 1) {
            cal_date_selection(reuseable, date_today, num_days);
        } else if (num_months == 2) {
            reuseable.clickonElement(navigation_forward);
            cal_date_selection(reuseable, date_today, num_days);
        } else if (num_months == 3) {
            reuseable.clickonElement(navigation_forward);
            reuseable.clickonElement(navigation_forward);
            cal_date_selection(reuseable, date_today, num_days);
        }
    }

    public void cal_date_selection(SeleniumBasicMethods reuseable, String date_today, int num_days) {
        List<WebElement> elements = reuseable.driver.findElements(cal_date_right);
        for (WebElement ele : elements) {
            if (ele.getText().equals(date_today.substring(8, 10))) {
                ele.click();
                int index = elements.indexOf(ele);
                index = index + num_days;
                elements.get(index).click();
            }
        }
    }

    public List<String> selectStars(SeleniumBasicMethods reuseable) throws InterruptedException {
        List<WebElement> elements = reuseable.driver.findElements(FilterPage.star);
        for (WebElement ele : elements) {
            if (ele.getText().contains("5 stars")) {
                ele.click();
            }
        }
        Thread.sleep(10000);
        return hotel_List(reuseable);
    }

    public List<String> selectFacilities(SeleniumBasicMethods reuseable) throws InterruptedException {
        reuseable.clickonElement(FilterPage.facilities_button);
        List<WebElement> elements = reuseable.driver.findElements(FilterPage.facilities_filter);
        for (WebElement ele : elements) {
            if (ele.getText().contains("Spa and wellness centre")) {
                ele.click();
            }
        }
        Thread.sleep(10000);
        return hotel_List(reuseable);
    }

    public List<String> hotel_List(SeleniumBasicMethods reuseable) {
        List<WebElement> hotelName = reuseable.driver.findElements(FilterPage.hotels_list);
        List<String> hotelNameList = new ArrayList<>();
        for (WebElement hotel : hotelName) {
            hotelNameList.add(hotel.getText());
        }
        return hotelNameList;
    }

    public void guests(SeleniumBasicMethods reuseable, int num_adults, int num_children, int num_room) {
        List<WebElement> ele = reuseable.driver.findElements(guest_filter_value);
        int numAdults = Integer.parseInt(ele.get(0).getText());
        int numChildren = Integer.parseInt(ele.get(1).getText());
        int numRooms = Integer.parseInt(ele.get(2).getText());

        if (num_adults == numAdults && num_children == numChildren && num_room == numRooms) {
            System.out.println("Default guest value is set");
        } else {
            System.out.println("code is yet to be implemented");
        }
    }
}
