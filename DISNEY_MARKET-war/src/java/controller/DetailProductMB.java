
package controller;

import entity.Product;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import sessionBeansPackage.ProductFacadeLocal;

@Named(value = "detailProductMB")
@RequestScoped
public class DetailProductMB {
    @EJB
    private ProductFacadeLocal productFacade;
    private Product productEntity = new Product(); 
   private model_D.Product productModel = new model_D.Product();
    public DetailProductMB() {
    }

    public Product getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(Product productEntity) {
        this.productEntity = productEntity;
    }

    public model_D.Product getProductModel() {
        return productModel;
    }

    public void setProductModel(model_D.Product productModel) {
        this.productModel = productModel;
    }
    
    
    @PostConstruct
       public void init ()
       {      
            Integer idProduct = new Integer (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProduct"));
            //idProduct = 1;
             productEntity = productFacade.find(idProduct);

            productModel.setReference(productEntity.getReference());
            productModel.setFilePicture(productEntity.getFilepicture());
            productModel.setPrice(productEntity.getPrice());

            if(productEntity.getAge() != null)
             productModel.setAge(productEntity.getAge());
            if(productEntity.getAuthor() != null)
             productModel.setAuthor(productEntity.getAuthor());
            if(productEntity.getRuntime() != null)
                 productModel.setRuntine(productEntity.getRuntime());
            if(productEntity.getNbtrack() != null)
                 productModel.setNbTrack(productEntity.getNbtrack());
            if(productEntity.getNbcd() != null)
             productModel.setNbCd(productEntity.getNbcd());
        }
}
