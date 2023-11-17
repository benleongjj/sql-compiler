import org.antlr.v4.runtime.tree.ParseTree;

public class SQL_Validate extends SQLBaseVisitor{
    public String prettyPrint;
    @Override public Object visitSqlStatement(SQLParser.SqlStatementContext ctx)
    {
        prettyPrint(ctx);
        return visitChildren(ctx);
    }
    @Override public Object visitSelectStatement(SQLParser.SelectStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitInsertStatement(SQLParser.InsertStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitDeleteStatement(SQLParser.DeleteStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitUpdateStatement(SQLParser.UpdateStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCreateStatement(SQLParser.CreateStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitDropStatement(SQLParser.DropStatementContext ctx) { return visitChildren(ctx); }
    @Override public Object visitColumnList(SQLParser.ColumnListContext ctx) { return visitChildren(ctx); }
    @Override public Object visitValueList(SQLParser.ValueListContext ctx) { return visitChildren(ctx); }
    @Override public Object visitAssignmentList(SQLParser.AssignmentListContext ctx) { return visitChildren(ctx); }
    @Override public Object visitAssignment(SQLParser.AssignmentContext ctx) { return visitChildren(ctx); }
    @Override public Object visitColumnDefinitionList(SQLParser.ColumnDefinitionListContext ctx) { return visitChildren(ctx); }
    @Override public Object visitColumnDefinition(SQLParser.ColumnDefinitionContext ctx) { return visitChildren(ctx); }
    @Override public Object visitCondition(SQLParser.ConditionContext ctx) { return visitChildren(ctx); }
    @Override public Object visitDataType(SQLParser.DataTypeContext ctx) { return visitChildren(ctx); }
    @Override public Object visitComparator(SQLParser.ComparatorContext ctx) { return visitChildren(ctx); }
    @Override public Object visitColumnName(SQLParser.ColumnNameContext ctx) { return visitChildren(ctx); }
    @Override public Object visitTableName(SQLParser.TableNameContext ctx) { return visitChildren(ctx); }
    @Override public Object visitDbName(SQLParser.DbNameContext ctx) { return visitChildren(ctx); }
    @Override public Object visitValue(SQLParser.ValueContext ctx) { return visitChildren(ctx); }
    @Override public Object visitStringLength(SQLParser.StringLengthContext ctx) { return visitChildren(ctx); }
    @Override public Object visitAoOperator(SQLParser.AoOperatorContext ctx) { return visitChildren(ctx); }

    public String prettyPrint(ParseTree ctx)
    {
        if (ctx.getChildCount() == 0)
        {
            return ctx.getText();
        }

        StringBuilder pp = new StringBuilder();
        pp.append("(");
        pp.append(ctx.getClass().getSimpleName());
        for (int i=0; i < ctx.getChildCount(); i++)
        {
            pp.append(" ");
            pp.append(prettyPrint(ctx.getChild(i)));
        }
        pp.append(")");
        this.prettyPrint = pp.toString();
        return this.prettyPrint;
    }

}
