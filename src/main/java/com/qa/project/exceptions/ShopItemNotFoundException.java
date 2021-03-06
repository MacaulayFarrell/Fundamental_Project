package com.qa.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Shop Item with this ID exists")
public class ShopItemNotFoundException extends EntityNotFoundException {
}
