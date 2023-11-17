import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    private boolean error;
    public String result;
    public CustomErrorListener(){
        super();
        error = false;
    }
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {
        this.error = true;
        this.result = "Parsing Error: At Char " + charPositionInLine + ", there is a " + msg;
    }

    public boolean isError() {
        return this.error;
    }
}
