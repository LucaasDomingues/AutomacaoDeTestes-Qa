package exceptions;

import enums.ByValue;

public class ElementException extends Exception {
  private static final long serialVersionUID = 2550142486472691858L;
  private static String FOUND_ERROR = "Ocorreu um erro ao executar uma ação no elemento: ";
  
  /**
   * Constructor - Dado um elemento, retorna uma excecao com a mensagem
   * informada e o elemento nao encontrado.
   * 
   * @param e
   *          Exception
   * @param by
   *          xpath, id ou class
   * @param value
   *          Mapeamento
   */
  public ElementException(Exception e, ByValue by, String value) {
    super(FOUND_ERROR + by.name() + " " + value + "\n" + e.getMessage());
  }
}