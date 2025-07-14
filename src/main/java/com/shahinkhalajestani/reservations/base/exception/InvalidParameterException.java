package com.shahinkhalajestani.reservations.base.exception;


import com.shahinkhalajestani.reservations.base.model.ResultStatus;

public class InvalidParameterException extends ServiceBasicException {
	public InvalidParameterException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.INVALID_PARAMETER;
	}
}
