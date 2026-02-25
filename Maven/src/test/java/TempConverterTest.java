import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TempConverterTest {

        private static final double DELTA = 1e-6; // acceptable floating-point error


    @Test
    void testClassInitializesCorrectly() {
        TemperatureConverter converter = new TemperatureConverter();
        assertNotNull(converter);
    }

    @Test
        void testCelsiusToFahrenheit() {
            assertEquals(77.0, TemperatureConverter.celsiusToFahrenheit(25.0), DELTA);
        }

        @Test
        void testCelsiusToKelvin() {
            assertEquals(298.15, TemperatureConverter.celsiusToKelvin(25.0), DELTA);
        }

        @Test
        void testFahrenheitToCelsius() {
            assertEquals(25.0, TemperatureConverter.fahrenheitToCelsius(77.0), DELTA);
        }

        @Test
        void testFahrenheitToKelvin() {
            assertEquals(298.15, TemperatureConverter.fahrenheitToKelvin(77.0), DELTA);
        }

        @Test
        void testKelvinToCelsius() {
            assertEquals(26.85, TemperatureConverter.kelvinToCelsius(300.0), DELTA);
        }

        @Test
        void testKelvinToFahrenheit() {
            assertEquals(80.33, TemperatureConverter.kelvinToFahrenheit(300.0), 0.01);
            // small tolerance because Fahrenheit conversion has more decimals
        }
    }

