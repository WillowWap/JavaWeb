/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import entity.Translationproduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aude
 */
@Stateless
public class TranslationproductFacade extends AbstractFacade<Translationproduct> implements TranslationproductFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslationproductFacade() {
        super(Translationproduct.class);
    }
    public String findByProductAndLang (Integer refProduct, String languages)
    {
        Query query; 
        query = em.createNamedQuery("Translationproduct.findByProductAndLang");
        query.setParameter("codeLang", languages);
        query.setParameter("refProduct", refProduct);
        return (String) query.getSingleResult();
    }
}
