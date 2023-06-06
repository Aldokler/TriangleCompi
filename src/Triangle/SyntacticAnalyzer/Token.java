/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    STRING      = 2,
    IDENTIFIER	= 3,
    OPERATOR	= 4,

    // reserved words - must be in alphabetical order...
    ARRAY		= 5,
    BEGIN		= 6,
    CASE                = 7,
    CONST		= 8,
    DO			= 9,
    ELSE		= 10,
    END			= 11,
    FOR                 = 12,
    FROM                = 13,
    FUNC		= 14,
    IF			= 15,
    IN			= 16,
    LET			= 17,
    OF			= 18,
    PROC		= 19,
    RECORD		= 20,
    REPEAT		= 21,
    SPAWN               = 22,
    THEN		= 23,
    TO                  = 24,
    TYPE		= 25,
    UNTIL		= 26,
    VAR			= 27,
    WHILE		= 28,
    // punctuation...
    DOT			= 29,
    COLON		= 30,
    SEMICOLON	        = 31,
    COMMA		= 32,
    BECOMES		= 33,
    IS			= 34,

    // brackets...
    LPAREN		= 35,
    RPAREN		= 36,
    LBRACKET	        = 37,
    RBRACKET	        = 38,
    LCURLY		= 39,
    RCURLY		= 40,

    // special tokens...
    EOT			= 41,
    ERROR		= 42;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<String>",
    "<identifier>",
    "<operator>",
    "array",
    "begin",
    "case",
    "const",
    "do",
    "else",
    "end",
    "for",
    "from",
    "func",
    "if",
    "in",
    "let",
    "of",
    "proc",
    "record",
    "repeat",
    "spawn",
    "then",
    "to",
    "type",
    "until",
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
