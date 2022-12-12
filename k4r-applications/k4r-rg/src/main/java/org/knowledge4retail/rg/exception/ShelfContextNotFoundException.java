package org.knowledge4retail.rg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ShelfContext not found")
public class ShelfContextNotFoundException extends RuntimeException {
}