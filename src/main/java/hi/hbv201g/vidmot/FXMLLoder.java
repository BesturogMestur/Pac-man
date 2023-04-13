package hi.hbv201g.vidmot;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Birgir sig
 *  T-póstur: bis46@hi.is
 *
 *  Lýsing  : Þetta forrit býr til FXMLLoader og noirar Object og String til að
 *  gera það.
 *
 *****************************************************************************/
public class FXMLLoder {
    private Object controller;
    private String fileName;

    /**
     * Hér er smið ur sme tokur inn Object og String til að búfa til FXMLLoader
     * @param controller
     * @param fileName
     */
    public FXMLLoder(Object controller, String fileName){
        this.controller=controller;
        this.fileName= fileName;
        load();
    }

    /**
     * Þess að ferð loader FXMLLoader
     */
    private void load(){
        FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(fileName));
        setLoader(loader);

        try{
            loader.load();
        }catch (IOException e){
            throw new RuntimeException();
        }

    }

    /**
     * Þessi að ferð tekur inn loader og tilit hann
     * @param loader er FXMLLoader
     */
    private void setLoader(FXMLLoader loader) {
        loader.setClassLoader(controller.getClass().getClassLoader());
        loader.setRoot(controller);
        loader.setController(controller);
    }


}
