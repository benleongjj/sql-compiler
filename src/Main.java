import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter SQL Statement: ");
        String line = in.nextLine();
        CharStream charStream = CharStreams.fromString(line);
        CustomErrorListener errorListener = new CustomErrorListener();

        SQLLexer lexer = new SQLLexer(charStream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream token = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        SQL_Validate validator = new SQL_Validate();
        validator.visitSqlStatement(parser.sqlStatement());

        if(errorListener.isError())
        {
            System.out.println("Validity: SQL Statement is not valid!");
            System.out.println(errorListener.result);
        } else
        {
            System.out.println("Validity: SQL Statement is valid!");
            System.out.println("Pretty Print: " + validator.prettyPrint);
        }
    }

}