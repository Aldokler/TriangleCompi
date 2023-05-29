/*
 * @(#)ArrayTypeDenoter.java                        2.1 2003/10/07
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

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class StringTypeDenoter extends TypeDenoter {

  public StringTypeDenoter (IntegerLiteral ilAST, TypeDenoter tAST,
                    SourcePosition thePosition) {
    super (thePosition);
    IL = ilAST;
    T = tAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitStringTypeDenoter(this, o);
  }

  public boolean equals (Object obj) {
    if (obj != null && obj instanceof ErrorTypeDenoter)
      return true;
    else if (obj != null && obj instanceof StringTypeDenoter)
      return this.IL.spelling.compareTo(((StringTypeDenoter) obj).IL.spelling) == 0 &&
             this.T.equals(((StringTypeDenoter) obj).T);
    else
      return false;
  }

  public IntegerLiteral IL;
  public TypeDenoter T;
}
