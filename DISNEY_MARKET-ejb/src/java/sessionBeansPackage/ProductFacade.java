
package sessionBeansPackage;

import EntityPackage.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    @Override
    public List<Product> FindAllProductCat (short idCat)
    {
        Query query; 
        query = em.createNamedQuery("Product.FindAllProductCat");
        query.setParameter("idCategory", idCat);
        return (List<Product>) query.getResultList(); 
    }
    
}
