package com.shahinkhalajestani.reservations.base.exception;

import com.shahinkhalajestani.reservations.base.model.ResultStatus;
import lombok.Getter;

@Getter
public class ServiceBasicException extends RuntimeException {

	private final ResultStatus status;

	public ServiceBasicException(String message) {
		super(message);
		this.status = ResultStatus.FAILURE;
	}
}
