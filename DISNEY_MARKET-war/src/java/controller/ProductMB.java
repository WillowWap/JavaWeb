
package controller;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessionBeansPackage.ProductFacadeLocal;
import sessionBeansPackage.TranslationproductFacadeLocal;


@Named(value = "productMB")
@RequestScoped
public class ProductMB {
    @EJB
    private TranslationproductFacadeLocal translationproductFacade;
    @EJB
    private ProductFacadeLocal productFacade;
      @Inject
    private InternationalizationManagedBeans lang; 
    private List<Product> listProduct; 
    private ArrayList<model_D.Product> productListModel = new ArrayList<model_D.Product>(); 
    public ArrayList<model_D.Product> getProductListModel() {
        return productListModel;
    }

    public void setProductListModel(ArrayList<model_D.Product> productListModel) {
        this.productListModel = productListModel;
    }
    public ProductFacadeLocal getProductFacade() {
        return productFacade;
    }
    
    public void setProductFacade(ProductFacadeLocal productFacade) {
        this.productFacade = productFacade;
    }
 
    public ProductMB() {
    }
    
    
    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
    
    @PostConstruct
    public void init ()
    {
        String langage = lang.getLocale().getLanguage();
        Short idCat = new Short (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("categoryId"));
        
        listProduct = productFacade.FindAllProductCat(idCat);
       
        
         for(Product product : listProduct)
         {
             
              model_D.Product productModel = new  model_D.Product();
             productModel.setReference(product.getReference());
             productModel.setFilePicture(product.getFilepicture());
             productModel.setLabel(translationproductFacade.findByProductAndLang(product.getReference(), langage));
             productListModel.add(productModel);
         }
         
    }
}
