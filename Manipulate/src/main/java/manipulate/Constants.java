package manipulate;



public final class Constants  {

    
    /*View fxml resource path from navigation controller*/

    public static final String  MAIN_VIEW= "/fxml/MainView.fxml";
    public static final String  DECRYPT_VIEW= "/fxml/DecryptView.fxml";
    public static final String  COPY_ACROFIELD_VIEW = "/fxml/CopyAcrofieldView.fxml";
	public static final String FILE_ERROR_LOG_NAME = "errorLog.txt"; 


    private Constants(){
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}
