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
    ATOMIC              = 6,
    BEGIN		= 7,
    CASE                = 8,
    CONST		= 9,
    DO			= 10,
    ELSE		= 11,
    END			= 12,
    FOR                 = 13,
    FROM                = 14,
    FUNC		= 15,
    IF			= 16,
    IN			= 17,
    LET			= 18,
    OF			= 19,
    PROC		= 20,
    RECORD		= 21,
    REPEAT		= 22,
    SPAWN               = 23,
    THEN		= 24,
    TO                  = 25,
    TYPE		= 26,
    UNTIL		= 27,
    VAR			= 28,
    WHILE		= 29,
    // punctuation...
    DOT			= 30,
    COLON		= 31,
    SEMICOLON	        = 32,
    COMMA		= 33,
    BECOMES		= 34,
    IS			= 35,

    // brackets...
    LPAREN		= 36,
    RPAREN		= 37,
    LBRACKET	        = 38,
    RBRACKET	        = 39,
    LCURLY		= 40,
    RCURLY		= 41,

    // special tokens...
    EOT			= 42,
    ERROR		= 43;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<String>",
    "<identifier>",
    "<operator>",
    "array",
    "atomic",
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
