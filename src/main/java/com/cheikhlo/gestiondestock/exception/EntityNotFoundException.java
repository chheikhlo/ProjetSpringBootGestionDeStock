package com.cheikhlo.gestiondestock.exception;

import lombok.Getter;

//Si je cherche un article par son code et que je le trouve pas cette article , je dois envoyé une exception de type EntityNotFound
public class EntityNotFoundException extends RuntimeException {

  @Getter
  private ErrorCodes errorCode;

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String message, Throwable cause /*pour logger la cause*/ ) {
    super(message, cause);
  }

  public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public EntityNotFoundException(String message, ErrorCodes errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

}
