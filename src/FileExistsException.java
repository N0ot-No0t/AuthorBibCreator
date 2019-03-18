public class FileExistsException extends Exception{


    /**
     * Default Constructor
     */
    public FileExistsException() {

        super("Exception: THere is already an existing file for that author. File will be renamed as BU, and older BU files" +
                "will be deleted!");

    }

    /**
     * Parameterized Constructor
     * @param message
     */
    public FileExistsException(String message){

        super(message);

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
