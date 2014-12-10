
package controller;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionBeansPackage.CustomerFacadeLocal;

@Named(value = "registrationMB")
@Dependent
public class RegistrationMB {
    @EJB
    private CustomerFacadeLocal customerFacade;

    public RegistrationMB() {
    }
    
}
