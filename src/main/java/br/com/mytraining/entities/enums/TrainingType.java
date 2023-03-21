package br.com.mytraining.entities.enums;

public enum TrainingType {
	
	
	A(1),
	B(2),
	C(3),
	D(4),
	E(5);
	
	private int code;
	
	private TrainingType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static TrainingType valueOf(int code) {
		for(TrainingType value : TrainingType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid TrainingType code");
	}

}
