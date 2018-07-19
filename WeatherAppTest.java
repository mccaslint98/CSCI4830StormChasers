package ;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTablePresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextInTable;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTableEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleNotEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;

public class WeatherAppTest{
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("https://stormchaserweather.herokuapp.com/");
    }

    @Test
    public void testIndexPage() {
        beginAt("index.html"); 
        
        assertTitleEquals("stormchaserweather.herokuapp.com");
        assertLinkPresentWithText("FAQ/About");
        assertLinkPresentWithText("Current");
        
        clickLink("FAQ/About");
        assertTitleEquals("FAQ!");
        clickLink("current");
        assertTitleEquals("current");
    }
    
    @Test
    public void testCurrentPage() {
        beginAt("Current.html"); 
        assertTitleEquals("Current");
        assertLinkPresent("");
        clickLink("");
        assertTitleEquals("");
    }
    
    @Test
    public void testFAQPage() {
        beginAt("FAQ.html"); 
        assertTitleEquals("FAQ!");
        
        assertLinkPresent("Source1");
        clickLink("Source1");
        assertTitleEquals("");
        
        assertLinkPresent("Source2");
        clickLink("Source2");
        assertTitleEquals("");
        
        assertLinkPresent("Source3");
        clickLink("Source3");
        assertTitleEquals("");
        }
    
        @Test
        public void testRadioButton() {
        beginAt("index.html");
        assertRadioOptionPresent("City","Omaha");
        assertRadioOptionPresent("City","Lincoln");
        assertRadioOptionPresent("Source","Source1");
        assertRadioOptionPresent("Source","Source2");
        assertRadioOptionPresent("Source","Source3");
        assertRadioOptionSelected("City","Omaha");
        assertRadioOptionSelected("Source","Source1");
        submit();
    }
}
