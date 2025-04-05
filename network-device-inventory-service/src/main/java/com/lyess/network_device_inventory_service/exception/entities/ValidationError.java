package com.lyess.network_device_inventory_service.exception.entities;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:35 p.m.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ValidationError(String object, String field, Object rejectedValue,
                              String message) implements ErrorResponse {

    public static final class Builder {
        String object;
        String field;
        Object rejectedValue;
        String message;

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder rejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ValidationError build() {
            return new ValidationError(object, field, rejectedValue, message);
        }
    }
}
