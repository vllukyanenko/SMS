package ua.lukianenko.ums.controllers.responses;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
    @Getter
    @AllArgsConstructor
    public class PageResponse<T> {

        private final List<T> content;
        private final Long totalElements;
        private final Integer pageNumber;
        private final Integer pageSize;
    }
