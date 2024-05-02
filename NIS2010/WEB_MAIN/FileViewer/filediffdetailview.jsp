<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%!
// 파일의 내용을 읽어서 반환한다.
public String[] readFile(String filepath) {
	String[] rtnContents = null;
	FileReader srcFr = null;
	BufferedReader srcBr = null;
	try{
		List<Object> contents = new ArrayList<Object>();
		srcFr = new FileReader(new File(filepath));
		srcBr = new BufferedReader(srcFr);
		String srcContents = null;
		int lineCnt = 0;
		String lneCnt = null;
		while( true ) {
			lineCnt++;
			lneCnt = Integer.toString(lineCnt);
			srcContents = srcBr.readLine();
			if ( srcContents == null ) break;	
			contents.add(lneCnt + "^" + srcContents);
		}
		
		rtnContents = new String[contents.size()];
		rtnContents = (String[])contents.toArray(rtnContents);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			srcBr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			srcFr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	return rtnContents;
}

%>
<%
	String filepath=request.getParameter("viewfilepath");
	System.out.println("filepath=>" + filepath);
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>File Contents View</title>
</head>
<body>
<center><h2>File Contents View</h2></center>
<table style="width:95%;">
	<tr>
		<td align="center" style="width:20px;">Line</td>
		<td align="center" style="width:900px;"><font color="blue"><b><%=filepath %></b></font></td>
	</tr>
<%
	String[] fileContents = readFile(filepath);
	String lineCnt = null;
	String srcCnts = null;
	String[] dispCnts = null;
	for ( int i=0; i<fileContents.length; i++){
		StringTokenizer st = new StringTokenizer(fileContents[i], "^");
		if ( st.hasMoreElements() ) lineCnt = (String)st.nextElement();
		if ( st.hasMoreElements() ) srcCnts = (String)st.nextElement();
%>
		<tr>
			<td align="right" style="width:20px;"><%=lineCnt%></td >
			<td align="left" style="width:900px;"><%=srcCnts%></td>
		</tr>
<%
	}
%>
</body>
</html>