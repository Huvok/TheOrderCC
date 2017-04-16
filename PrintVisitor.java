// Name:PrintVisitor.java
// Author: David Sinclair      Date: 29 Aug 2012
//
// Visitor for "pretty printing" an abstract syntax tree in the ExprLang language
//

public class PrintVisitor implements SyntaxVisitor
{
    public Object visit(SimpleNode node, Object data)
    {
	throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTProgram node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.println(";");
	return(data);
    }

    public Object visit(ASTDecl node, Object data)
    {
	System.out.print(node.value + " ");
	node.jjtGetChild(0).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTStatement node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.println(";");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }
    
    public Object visit(ASTDeclaration node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.println(";");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTPLUS_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }
    
    public Object visit(ASTMINUS_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTAND_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }
    
    public Object visit(ASTOR_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTMULT_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }
    
    public Object visit(ASTDIV_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTNOT_op node, Object data)
    {
	System.out.print("!");
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }

    public Object visit(ASTExp node, Object data)
    {
	System.out.print("(");
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(")");
	return(data);
    }

    public Object visit(ASTID node, Object data)
    {
	System.out.print(node.value);
	return data;
    }

    public Object visit(ASTNumber node, Object data)
    {
	System.out.print(node.value);
	return data;
    }
    
    public Object visit(ASTString node, Object data)
    {
	System.out.print(node.value);
	return data;
    }
}