package ua.lukianenko.ums.converter;

import java.util.Collection;

public interface Converter<S, T> {

    T convert(S source);

    void convert(S source, T target);

    Collection<T> convert(Collection<S> source);
}
