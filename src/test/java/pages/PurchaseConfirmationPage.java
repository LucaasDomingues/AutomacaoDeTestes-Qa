package pages;

import uimaps.PurchaseConfirmationMap;

public class PurchaseConfirmationPage {
  private PurchaseConfirmationMap purchaseConfirmationMap = new PurchaseConfirmationMap();
  
  public void validateResult(String successMessage, String expiration) throws Exception {
    String message = purchaseConfirmationMap.h1Result.getText();
    if (!message.equals(successMessage)) {
      throw new Exception("Mensagem de sucesso não encontrada. Esperado: '" + successMessage + "', encontrado: '" + message + "'.");
    }
    String expirationText = purchaseConfirmationMap.tdExpiration.getText();
    if (!expirationText.equals(expiration)) {
      throw new Exception("Expiration divergente do esperado. Esperado: '" + expiration + "', encontrado: '" + expirationText + "'.");
    }
  }
}
