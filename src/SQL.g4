grammar SQL;

sqlStatement: (selectStatement | insertStatement | deleteStatement | updateStatement | createStatement | dropStatement) SEMI;

selectStatement: SELECT columnList FROM tableName (WHERE condition (aoOperator condition)*)?;
insertStatement: INSERT INTO tableName (LPAREN columnList RPAREN)? VALUES LPAREN valueList RPAREN;
deleteStatement: DELETE FROM tableName (WHERE condition)?;
updateStatement: UPDATE tableName SET assignmentList (WHERE condition)?;
createStatement: CREATE DATABASE dbName | CREATE TABLE tableName LPAREN columnDefinitionList RPAREN ;
dropStatement: DROP DATABASE dbName | DROP TABLE tableName;

columnList: columnName (COMMA columnName)* | ASTERISK;
valueList: value (COMMA value)*;
assignmentList: assignment (COMMA assignment)*;
assignment: columnName EQUAL value;
columnDefinitionList: columnDefinition (COMMA columnDefinition)*;
columnDefinition: columnName dataType (LPAREN stringLength RPAREN)?;
condition: (NOT)? columnName comparator value;

dataType: 'int' | 'varchar' | 'date' | 'float';
comparator: EQUAL | '<' | '>' | '<=' | '>=' | '<>';
columnName: ID;
tableName: ID;
dbName: ID;
value: INT | STRING;
stringLength: INT;
aoOperator: AND | OR;

SELECT: 'SELECT';
INSERT: 'INSERT';
DELETE: 'DELETE';
UPDATE: 'UPDATE';
CREATE: 'CREATE';
DROP: 'DROP';
FROM: 'FROM';
INTO: 'INTO';
WHERE: 'WHERE';
VALUES: 'VALUES';
TABLE: 'TABLE';
DATABASE: 'DATABASE';
SET: 'SET';
AND: 'AND';
OR: 'OR';
NOT: 'NOT';
EQUAL: '=';
LPAREN: '(';
RPAREN: ')';
COMMA: ',';
SEMI: ';';
ASTERISK: '*';
ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '\'' .*? '\'';

WS: [ \t\r\n]+ -> skip;



