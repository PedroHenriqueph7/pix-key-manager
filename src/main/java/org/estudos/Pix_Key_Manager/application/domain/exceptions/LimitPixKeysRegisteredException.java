package org.estudos.Pix_Key_Manager.application.domain.exceptions;

public class LimitPixKeysRegisteredException extends RuntimeException {
    public LimitPixKeysRegisteredException() { super("Quantidade de Chaves Pix excedidas!!"); }

}
