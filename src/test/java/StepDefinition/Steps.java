package StepDefinition;

import Bookings.LandingPage;
import Bookings.ReuseableMethods;
import Entities_UI.SeleniumBasicMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    SeleniumBasicMethods reuseable = new SeleniumBasicMethods();
    ReuseableMethods methods = new ReuseableMethods();
    List<String> hotels = new ArrayList<>();

    @Given("User launches the website {string}")
    public void launch_url(String string) {
        reuseable.launchUrl(string);
        reuseable.clickonElement(LandingPage.cookie);
    }

    @Given("types location for stay is {string}")
    public void the_location_for_stay_is(String string) {
        reuseable.sendtext(LandingPage.where_you_going, string);
    }

    @Given("The booking is to be done for {string} months from today and for {string} night")
    public void the_booking_is_to_be_done_for_and_for_night(String string, String string2) {
        methods.calendar_input(reuseable, Integer.parseInt(string2), Integer.parseInt(string));
        reuseable.clickonElement(LandingPage.search);
    }

    @Given("The Number of People are {int} with number of rooms being {int}")
    public void the_number_of_people_are(int adult,int room)  {
        reuseable.clickonElement(LandingPage.guest_filter);
        methods.guests(reuseable,adult,0,room);
    }

    @When("the filter applied is for {string}")
    public void the_filter_applied_is_for(String string) throws InterruptedException {
        if (string.contains("Sauna")) {
            hotels = methods.selectFacilities(reuseable);
            reuseable.quitDriver();
        }
        if (string.contains("5 Star")) {
            hotels = methods.selectFacilities(reuseable);
            reuseable.quitDriver();
        }
    }

    @Then("Expect {string} to be listed is {string}")
    public void expect_to_be_listed_is(String string,String str1) {
        String str2 = " ";
        System.out.println(hotels);
        for (String str : hotels) {
            if (str.equals(string)) {
                str2 = str;
                break;
            }
        }
        if (str2.equalsIgnoreCase(string)) {
            assert (true);
        } else {
            assert (false);
        }
    }
}
