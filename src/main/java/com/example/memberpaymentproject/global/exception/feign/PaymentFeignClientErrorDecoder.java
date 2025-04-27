package com.example.memberpaymentproject.global.exception.feign;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class PaymentFeignClientErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder decoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus httpStatus = HttpStatus.valueOf(response.status());
        if (httpStatus.is4xxClientError() || httpStatus.is5xxServerError()) {
            return new RetryableException(response.status(), response.reason(), response.request().httpMethod(), (Long) null, response.request());
        }

        return decoder.decode(methodKey, response);
    }
}
