package weather;


public interface Service<T>{

    public T getForecast(String city) throws Exception;

}