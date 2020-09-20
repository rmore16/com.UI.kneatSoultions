import Bookings.FilterPage;
import Bookings.LandingPage;
import Entities_UI.SeleniumBasicMethods;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test extends LandingPage {
    public static void main(String[] args) throws InterruptedException {
        SeleniumBasicMethods reuseable = new SeleniumBasicMethods();
        reuseable.launchUrl("http://booking.com");
        reuseable.clickonElement(cookie);
        reuseable.sendtext(where_you_going, "Limerick");
        calendar_input(reuseable, 2, 2);
        reuseable.clickonElement(search);
        selectStars(reuseable);
        selectFacilities(reuseable);
        System.exit(0);
    }

    public static void calendar_input(SeleniumBasicMethods reuseable, int num_days, int num_months) {
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

    public static void cal_date_selection(SeleniumBasicMethods reuseable, String date_today, int num_days) {
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

    public static void guests(int num_adults, int num_children, int num_room) {
        if (num_adults == 2 && num_children == 0 && num_room == 1) {
            System.out.println("Default selection of guests and room");
        } else {

        }
    }

    public static void selectStars(SeleniumBasicMethods reuseable) throws InterruptedException {
        List<WebElement> elements = reuseable.driver.findElements(FilterPage.star);
        for (WebElement ele : elements) {
            if (ele.getText().contains("5 stars")) {
                ele.click();
            }
        }
        Thread.sleep(10000);
        //hotel_List(reuseable);
        System.out.println(hotel_List(reuseable));
    }

    public static void selectFacilities(SeleniumBasicMethods reuseable) throws InterruptedException {
        reuseable.clickonElement(FilterPage.facilities_button);
        List<WebElement> elements = reuseable.driver.findElements(FilterPage.facilities_filter);
        for (WebElement ele : elements) {
            if (ele.getText().contains("Spa and wellness centre")) {
                ele.click();
            }
        }
        Thread.sleep(10000);
        //hotel_List(reuseable);
        System.out.println(hotel_List(reuseable));
    }

    public static List<String> hotel_List(SeleniumBasicMethods reuseable) {
        List<WebElement> hotelName = reuseable.driver.findElements(FilterPage.hotels_list);
        List<String> hotelNameList = new ArrayList<>();
        for (WebElement hotel : hotelName) {
            hotelNameList.add(hotel.getText());
        }
        return hotelNameList;
    }

}