package com.shahinkhalajestani.reservations.base.model;

import lombok.Getter;

@Getter
public enum ResultStatus {

	SUCCESS(0, "success"),

	FAILURE(-1, "failure"),

	DUPLICATE_RECORD(1001, "duplicate.record.exception"),

	RECORD_NOT_FOUND(1002, "record.not.found"),
	INVALID_PARAMETER(1003, "invalid.parameter"),
	PRODUCT_NOT_ENOUGH(1004, "product.not.enough"),
	;

	private final int code;

	private final String description;

	ResultStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
}
