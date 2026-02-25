public class TemperatureConverter {

    // Celsius conversions
    public static double celsiusToFahrenheit(double c) {
        return (c * 9.0 / 5.0) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    // Fahrenheit conversions
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5.0 / 9.0 + 273.15;
    }

    // Kelvin conversions
    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9.0 / 5.0 + 32;
    }

}