// Name:TypeCheckVisitor.java
// Author: David Sinclair      Date: 29 Aug 2012
//
// Visitor for basic type checking expressions in an abstract syntax tree in the ExprLang language
//

import java.util.*;

public class TypeCheckVisitor implements SyntaxVisitor
{
    public Object visit(SimpleNode node, Object data)
    {
	throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTProgram node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	return DataType.Program;
    }

    public Object visit(ASTDecl node, Object data)
    {
	return DataType.Declaration;
    }

    public Object visit(ASTStatement node, Object data)
    {
	PrintVisitor pv = new PrintVisitor();

	if ((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeUnknown)
	    {
		System.out.print("Type error: ");
		node.jjtGetChild(0).jjtAccept(pv, null);
		System.out.println();
	    }

	return (node.jjtGetChild(1).jjtAccept(this, data));
    }
    
    public Object visit(ASTDeclaration node, Object data)
    {
	PrintVisitor pv = new PrintVisitor();

	if ((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeUnknown)
	    {
		System.out.print("Type error: ");
		node.jjtGetChild(0).jjtAccept(pv, null);
		System.out.println();
	    }

	return (node.jjtGetChild(1).jjtAccept(this, data));
    }
    
    public Object visit(ASTAssignation node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }

    public Object visit(ASTPLUS_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTLESSTHAN_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTMORETHAN_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTEQUALS_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTNOTEQUALS_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTMINUS_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }

    public Object visit(ASTAND_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeBoolean)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeBoolean))
	    return DataType.TypeBoolean;
	else
	    return DataType.TypeUnknown;
    }
    
    public Object visit(ASTOR_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeBoolean)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeBoolean))
	    return DataType.TypeBoolean;
	else
	    return DataType.TypeUnknown;
    }

    public Object visit(ASTMULT_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }
    
     public Object visit(ASTDIV_op node, Object data)
    {
	if (((DataType)node.jjtGetChild(0).jjtAccept(this, data) == DataType.TypeInteger)
            && ((DataType)node.jjtGetChild(1).jjtAccept(this, data) == DataType.TypeInteger))
	    return DataType.TypeInteger;
	else
	    return DataType.TypeUnknown;
    }

    public Object visit(ASTNOT_op node, Object data)
    {
	if ((DataType)node.jjtGetChild(0).jjtAccept(this, data) != DataType.TypeBoolean)
	    return DataType.TypeUnknown;
	else
	    return DataType.TypeBoolean;
    }

    public Object visit(ASTExp node, Object data)
    {
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }
    
    public Object visit(ASTWrite node, Object data)
    {
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }
    
    public Object visit(ASTIf node, Object data)
    {
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }
    
    public Object visit(ASTElse node, Object data)
    {
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }

    public Object visit(ASTID node, Object data)
    {
	Hashtable ST = (Hashtable) data;
	STC hashTableEntry;

        hashTableEntry = (STC)ST.get(node.value);
	if (hashTableEntry.type == "int")
	    {
		return DataType.TypeInteger;
	    }
	else if (hashTableEntry.type == "boolean")
	    {
		return DataType.TypeBoolean;
	    }
    else if (hashTableEntry.type == "String")
	    {
		return DataType.TypeBoolean;
	    }
	else
	    {
		return DataType.TypeUnknown;
	    }
    }

    public Object visit(ASTNumber node, Object data)
    {
	return DataType.TypeInteger;
    }
    
    public Object visit(ASTString node, Object data)
    {
	return DataType.TypeInteger;
    }
}