package structural.facade;

/**
 * facade implementation
 * */
public class ControllerLicenseOperations {

    private VerifyPayment verifyPayment;
    private CheackCheats cheackCheats;
    private ValidateLicenseFields validateLicenseFields;
    private ActivationLicense activationLicense;

    public ControllerLicenseOperations(VerifyPayment verifyPayment, CheackCheats cheackCheats, ValidateLicenseFields validateLicenseFields, ActivationLicense activationLicense) {
        this.verifyPayment = verifyPayment;
        this.cheackCheats = cheackCheats;
        this.validateLicenseFields = validateLicenseFields;
        this.activationLicense = activationLicense;
    }

    public void activateLicense(License license){

        boolean resultVerifyField = validateLicenseFields.verifyFields(license);
        boolean resultVerifyCheats = cheackCheats.verifyCheats(license);
        boolean resultVerifyPayment = verifyPayment.verify(license);

        if(
                resultVerifyField &&
                resultVerifyCheats &&
                resultVerifyPayment
        ){
            activationLicense.activate(license);

            System.out.println("Сообщаем клиенту о том, что лицензия успешно активирована.");
        }
    }
}
