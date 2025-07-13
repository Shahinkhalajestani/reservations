package com.shahinkhalajestani.reservations.base.exception;


import com.shahinkhalajestani.reservations.base.model.ResultStatus;

public class DuplicateRecordException extends ServiceBasicException {
	public DuplicateRecordException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.DUPLICATE_RECORD;
	}
}
