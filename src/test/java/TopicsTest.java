import app.AppConfig;
import app.pages.BasePage;
import app.pages.HomePage;
import app.pages.TopicsPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Topics Page Links")
public class TopicsTest extends BaseTest {
    private static final char [] MENU_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Test
    @Description("Clicks on top-left NASA logo to assure correct linking to the Home Page")
    public void shouldGetToHomePageAfterClickingOnLogo() {
        var topicsPage = app.toTopicsPage();

        String currentUrl = topicsPage.clickOnNasaLogo().getCurrentUrl();

        assertThat(HomePage.PAGE_URL).isEqualTo(currentUrl);
        //Assertions.assertEquals(AppConfig.BASE_URL + AppConfig.HOME_PAGE_PATH, currentUrl);
    }

    @Test
    @Description("Checks in URL each time if path now contains a link to an appropriate section in of a page")
    public void shouldVerifyCorrectMenuLettersPointing() {
        var topicsPage = app.toTopicsPage();


        for (Character letter: MENU_LETTERS) {
            topicsPage.clickOnMenuLetter(letter);

            assertThat(TopicsPage.PAGE_URL + "/#letter-" + letter).isEqualTo(topicsPage.getCurrentUrl());
//            Assertions.assertEquals((AppConfig.BASE_URL + AppConfig.TOPICS_PAGE_PATH + "/#letter-" + letter),
//                    topicsPage.getCurrentUrl());
        }

    }

}
