<%@ page contentType="text/html; charset=UTF-8"%>
<%
  String rowCount = request.getParameter("row_count");
  int    rowCnt   = 0;
  int    col1     = 0;
  int    col2     = 0;
  int    col3     = 0;
  if ( !rowCount.equals("") ) rowCnt = Integer.parseInt(rowCount)/4;

  if (  rowCnt > 0 ) {
	  out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	  out.println("<Excel>");
	  out.println("<Label>");

	  for ( int i = 0 ; i < rowCnt ; i++ ) {
		  col1 = i*4+2;
		  col2 = i*4+4;
		  col3 = i*4+5;

		  out.println("<Range Row1=\""+col1+"\" Col1=\"6\" Row2=\""+col2+"\" Col2=\"end\" RowHeight=\"15\">");
		  out.println("<CellFormat>");
		  out.println("<Format NumberFormatLocal=\"#,##0\"/>");
		  out.println("</CellFormat>");
		  out.println("</Range>");

		  out.println("<Range Row1=\""+col3+"\" Col1=\"6\" Row2=\""+col3+"\" Col2=\"end\" RowHeight=\"15\">");
		  out.println("<CellFormat>");
		  out.println("<Format NumberFormatLocal=\"#,##0.00\"/>");
		  out.println("</CellFormat>");
		  out.println("</Range>");
      }

	  out.println("</Label>");
	  out.println("</Excel>");
  }
%>