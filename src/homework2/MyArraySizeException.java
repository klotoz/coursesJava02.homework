package homework2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    private String message;

    public MyArraySizeException(String message) {
        super(message);
    }


}
