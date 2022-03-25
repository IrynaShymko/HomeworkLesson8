package AutoTesting1;

import Base.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutomationSiteNameTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("AutomationSiteNameTest.class");

    @Tag("regression")
    @DisplayName("Testing site title")
    @ParameterizedTest
    @CsvFileSource(resources = "/siteTitle.csv", delimiter = ';')
    void seleniumTestSiteTitle(String siteUrl, String expectedTitle) {
        driver.get(siteUrl);
        logger.info("<<<<<Testing of {}", siteUrl);
        logger.info("<<<<<Expected title: " + expectedTitle);
        assertThat("Title of site " + siteUrl + " is not correct", driver.getTitle(), equalTo(expectedTitle));
    }
}
