package AutoTesting2;

import Base.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherSIteTitlesTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("OtherSIteTitlesTest.class");

    @Tag("regression")
    @DisplayName("Testing other sites")
    @ParameterizedTest
    @CsvFileSource(resources = "/otherSites.csv", delimiter = ';')
    void seleniumTestOtherSite(String siteUrl, String expectedTitle) {
        driver.get(siteUrl);
        logger.info("<<<<<Testing of {}", siteUrl);
        logger.info("<<<<<Expected title: " + expectedTitle);
        assertThat("Title of site " + siteUrl + " is not correct", driver.getTitle(), equalTo(expectedTitle));
    }


}
