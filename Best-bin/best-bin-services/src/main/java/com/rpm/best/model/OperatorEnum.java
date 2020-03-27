package com.rpm.best.model;

public enum OperatorEnum {

	eq("eq"), gte("gte"), lte("lte"), regex("regex") , in("in");

	private String operation;

	private OperatorEnum(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

}
