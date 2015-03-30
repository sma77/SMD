/***********************************************************
 *      This software is part of the ProM package          *
 *             http://www.processmining.org/               *
 *                                                         *
 *            Copyright (c) 2003-2006 TU/e Eindhoven       *
 *                and is licensed under the                *
 *            Common Public License, Version 1.0           *
 *        by Eindhoven University of Technology            *
 *           Department of Information Systems             *
 *                 http://is.tm.tue.nl                     *
 *                                                         *
 **********************************************************/

package org.prom5.analysis.ltlchecker.parser;

import java.util.List;

/* Generated By:JJTree: Do not edit this line. ASTformulaDefinition.java */

public class ASTformulaDefinition extends SimpleNode {

	String description;

	public void setDescription(String d) {
		this.description = d;
	}

	public String getDescription() {
		return this.description;
	}

	public ASTformulaDefinition(int id) {
		super(id);
	}

	public ASTformulaDefinition(LTLParser p, int id) {
		super(p, id);
	}

    public String toString(boolean verbose) {
        return super.toString() + ": desc=" + description;
    }
    
	public String prettyPrint(String proposition) {
		return proposition.replace('\r', ' ').replace('\n', ' ').replaceAll("  ", " ");	}
	
	@Override
	public String asParseableString(List<FormulaParameter> args, int type) {
		String result = (type == SUBFORMULA ? "subformula " : "formula ") + getName() + "( ";
		
		boolean first = true;
		for (FormulaParameter arg : args) {
			if (!first) {
				result += ", ";
			} else {
				first = false;
			}
			result += arg.getParam().asParseableArgument();
			
			if (arg.hasDefaultValue()) {
				result += " : " + arg.getDefaultValue();
			}
		}
		result += " ) :=\n{" + 
			description + "}\n  ";
		if (children != null) {
			assert(children.length == 1 || children.length == 2);
			for (int i = 0; i < children.length; ++i) {
				SimpleNode n = (SimpleNode) children[i];
				if (n != null && n.getType() == PROPOSITION) {
					result += prettyPrint(n.asParseableString());
				}
			}
		}
		result += "\n;\n";
		return result;
	}
}
