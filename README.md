    
  ## Необходимо доделать
  - Дописать `visit`-оров к представителям классов `Stmt` и `Expr`
  - Дописать тесты, проверяющие соответствие построенного `antlr` дерева с действительным деревом. Для этого необходимо закончить трансляцию дерева `antlr` в имеющиеся примитивы (представителей класса `AstNode`, второй пункт из нереализованного)

  ## Грамматика в BNF-нотации
  
  - `<program> ::= <func> | <program> <func>`
  - `<func> ::= "let" <type> <name> "(" <type> <name> ")" "{" <stmt> "}" | "let" <type> <name> "(" ")" "{" <stmt> "}"`
  - `<stmt> ::= <initializerStmt> ";" | <IfStmt> | <assignmentStmt> ";"| <returnStmt> ";"| <funcExpr> ";"`
  - `<initializerStmt> ::= <type> <name> ":=" <expr>`
  - `<IfStmt> ::= if "(" <expr> ")" "{" <stmt> "}" | if "(" <expr> ")" "{" <stmt> "}" else "{" <stmt> "}"`
  - `<assignmentStmt> ::= <name> ":=" <expr>`
  - `<returnStmt> ::= "return" <expr>`
  - `<expr> ::= <expr> ">=" <expr> | <expr> "<" <expr> | <expr> ">" <expr> | <expr> "==" <expr> | <expr> "!=" <expr> | <expr> "+" <expr> | <expr> "-" <expr> | <expr> "*" <expr> | <expr> "/" <expr> | <expr> "%" <expr> | <funcExpr> | <atom>`
  - `<funcExpr> ::= name "(" <expr> ")" | name "(" ")" `
  - `<atom> ::= primitives | <name> | "(" <expr> ")"` 
  - `<primitives ::= number | string | "true" | "false"`
  - `<type> ::= "Integer" | "String" | "Boolean" | "void"`
  - `<name> ::= <letter> | "_" | <name> <letter>`
  - `<number> ::= <digit> | <number> <digit>`
  - `<letter> ::= "A" | "B" | "C" | "D" | "E" | "F" | "G" | "H" | "I" | "J" | "K" | "L" | "M" | "N" | "O" | "P" | "Q" | "R" | "S" | "T" | "U" | "V" | "W" | "X" | "Y" | "Z" | "a" | "b" | "c" | "d" | "e" | "f" | "g" | "h" | "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z"`
  - `<digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"`
