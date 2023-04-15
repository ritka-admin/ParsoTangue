    
  ## Необходимо доделать
  - Дописать часть грамматики в BNF-нотации (почти полностью соответствует выражениям в `ParsoTangueParser.g4`)
  - Дописать `visit`-оров к представителям классов `Stmt` и `Expr`
  - Дописать тесты, проверяющие соответствие построенного `antlr` дерева с действительным деревом. Для этого необходимо закончить трансляцию дерева `antlr` в имеющиеся примитивы (представителей класса `AstNode`, второй пункт из нереализованного)

  ## Грамматика в BNF-нотации
  
  - `<expr> ::= <booleanExpr> | <arithExpr> | <funcExpr> | <primitives> | <name>`
  - `<booleanExpr> ::= <comp> | "true" | "false"`
  - `<arithExpr> ::= <num> "+" <num> | <num> "-" <num> | <num> "*" <num> | <num> "/" <num> | <num> "%" <num>`
  - `<funcExpr> ::= name "(" <expr> ")" | name "(" ")" `
  - `<primitives ::= number | string | "true" | "false"`
  - `comp ::= <num> ">=" <num> | <num> "<" <num> | <num> ">" <num> | <num> "==" <num> | <num> "!=" <num>`
  - `<num> ::= <arithExpr> | <funcExpr> | <number> | <name>`
