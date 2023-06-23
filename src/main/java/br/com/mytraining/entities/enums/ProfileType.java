package br.com.mytraining.entities.enums;

public enum ProfileType {

    ADMIN(0, "ROLE_ADMIN"), PERSON(1, "ROLE_PERSON"), PERSONAL_TRAINER(2, "ROLE_PERSONAL_TRAINER");

    private Integer code;
    private String description;

    private ProfileType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProfileType valueOf(Integer code) {
        if(code == null) {
            return null;
        }

        for(ProfileType value: ProfileType.values()) {
            if(value.getCode().equals(code)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid ProfileType code");
    }

}
