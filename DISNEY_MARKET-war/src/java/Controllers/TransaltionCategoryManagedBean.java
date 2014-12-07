/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EntityPackage.Translationcategory;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBeansPackage.TranslationcategoryFacadeLocal;

@Named(value = "transaltionCategoryManagedBean")
@ApplicationScoped
public class TransaltionCategoryManagedBean {
    
    private TranslationcategoryFacadeLocal translationCat; 
    public TransaltionCategoryManagedBean() {
    }
    
    
}
