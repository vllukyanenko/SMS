package ua.lukianenko.ums.converter.impl;
import ua.lukianenko.ums.converter.Converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverterImpl<S, T> implements Converter<S, T> {

    protected abstract T generateTarget();

    @Override
    public T convert(S source) {
        T target = generateTarget();
        convert(source, target);
        return target;
    }

    @Override
    public List<T> convert(Collection<S> source) {
        return source.stream().map(this::convert).collect(Collectors.toList());
    }
}
