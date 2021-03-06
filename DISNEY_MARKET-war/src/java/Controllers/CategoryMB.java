package Controllers;

import EntityPackage.Category;
import EntityPackage.Translationcategory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import sessionBeansPackage.CategoryFacadeLocal;
import sessionBeansPackage.TranslationcategoryFacadeLocal;

@Named(value = "categoryMB")
@RequestScoped
public class CategoryMB {
    @EJB
    private TranslationcategoryFacadeLocal translationcategoryFacade;
    @EJB
    private CategoryFacadeLocal categoryFacade;
    @Inject
    private InternationalizationManagedBeans lang; 
    
    public CategoryMB() {
    }
     public ArrayList<model_D.Category> findAll ()
    {
        String label;
        Translationcategory translate;
        String langage;
        langage = lang.getLocale().getLanguage();
        
        ArrayList <model_D.Category> modelCat = new ArrayList <model_D.Category>();
        List<Category> entityCat = categoryFacade.findAll();
        
        for(Category cat : entityCat)
        {
            model_D.Category category = new model_D.Category(); 
            category.setIdCategory(cat.getIdcategory());
            category.setFilPicture(cat.getFilepicture());
            category.setDiscountRef(null);
            label= translationcategoryFacade.findLabel(cat.getIdcategory(), langage);
            category.setLabel(label);
            modelCat.add(category);
        }
        return modelCat;
    }
   
}
