package org.estudos.Pix_Key_Manager.domain.pix;

import java.util.regex.Pattern;

public enum TypeKey {
    TELEFONE("^\\+[1-9][0-9]\\d{1,14}$"),
    CPF("^[0-9]{11}$"),
    EMAIL("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
    ALEATORIA("^[0-9a-f]{8}-[0-9a-f]{4}-[4][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");

    private final Pattern pattern;


    TypeKey(String regex) {
        this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

    public boolean isValidFormat(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }

        return this.pattern.matcher(value).matches();
    }
}
