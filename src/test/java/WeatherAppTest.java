package weather;

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
import static net.sourceforge.jwebunit.junit.JWebUnit.assertRadioOptionPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresentWithText;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertRadioOptionSelected;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;

public class WeatherAppTest{
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("https://stormchaserweather.herokuapp.com/");
    }

    @Test
    public void testIndexPage() {
        beginAt("index.html"); 
        
        assertTitleEquals(" My Webpage");
        assertLinkPresentWithText("FAQ/About");
        assertLinkPresentWithText("Weather Predictions - Single Source");
        assertLinkPresentWithText("Weather Predictions - Source Comparison");
        assertLinkPresentWithText("Weather History");
        
        clickLink("FAQ/About");
        assertTitleEquals("FAQ!");
        clickLink("Weather History");
        assertTitleEquals("My Webpage!");
    }
    
    @Test
    public void testHistoryPage() {
        beginAt("history.html"); 
        
        assertTitleEquals("My Webpage!");
        assertLinkPresentWithText("FAQ/About");
        assertLinkPresentWithText("Weather Predictions - Single Source");
        assertLinkPresentWithText("Weather Predictions - Source Comparison");
        assertLinkPresentWithText("Weather History");
        
        clickLink("FAQ/About");
        assertTitleEquals("FAQ!");
        clickLink("Weather Predictions - Source Comparison");
        assertTitleEquals("My Webpage!");
    }
    
    @Test
    public void testFAQPage() {
        beginAt("FAQ.html"); 
        assertTitleEquals(" FAQ!");
        
        assertLinkPresent("Open Weather Map");
        clickLink("Open Weather Map");
        assertTitleEquals("Current weather and forecast - OpenWeatherMap");
        
        assertLinkPresent("NOAA");
        clickLink("NOAA");
        assertTextPresent("Numerical Weather Prediction");
        
        assertLinkPresent("Dark Sky");
        clickLink("Dark Sky");
        assertTitleEquals("Dark Sky - 260 Broadway, New York City, NY");
        }
    
        @Test
        public void testRadioButton() {
        beginAt("index.html");
        assertRadioOptionPresent("City","Omaha");
        assertRadioOptionPresent("City","Lincoln");
        assertRadioOptionPresent("Source","OWM");
        assertRadioOptionPresent("Source","DarkSky");
        assertRadioOptionPresent("Source","NOAA");
        assertRadioOptionSelected("City","Omaha");
        assertRadioOptionSelected("Source","OWM");
        submit();
    }
}
