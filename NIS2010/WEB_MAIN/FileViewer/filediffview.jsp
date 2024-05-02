<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%!
// 파일의 내용을 읽어서 반환한다.
public String[] readFile(String srcFileName, String destFileName) {
	String[] rtnContents = null;
	FileReader srcFr = null;
	BufferedReader srcBr = null;
	FileReader destFr = null;
	BufferedReader destBr = null;
	try{
		List<Object> contents = new ArrayList<Object>();
		srcFr = new FileReader(new File(srcFileName));
		srcBr = new BufferedReader(srcFr);
		destFr = new FileReader(new File(destFileName));
		destBr = new BufferedReader(destFr);
		String srcContents = null;
		String destContents = null;
		int lineCnt = 0;
		String lneCnt = null;
		while( true ) {
			lineCnt++;
			lneCnt = Integer.toString(lineCnt);
			srcContents = srcBr.readLine();
			destContents = destBr.readLine();
			if ( srcContents == null && destContents == null ) break;	
			
			if ( srcContents == null || destContents == null ) {
				lneCnt = "<font color=red>" + lneCnt + "</font>";
				srcContents = "<font color=red>" + srcContents  + "</font>";
				destContents = "<font color=red>" + destContents + "</font>";
				contents.add(lneCnt + "^" + srcContents + "^" + destContents);
				continue;
			}
			
			if ( !srcContents.equals(destContents) ){
				lneCnt = "<font color=red>" + lneCnt + "</font>";
				srcContents = "<font color=red>" + srcContents + "</font>";
				destContents = "<font color=red>" + destContents + "</font>";
			}
			
			contents.add(lneCnt + "^" + srcContents + "^" + destContents);
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
		try{
			destBr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			destFr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	return rtnContents;
}

%>
<%
	String srcFileName=request.getParameter("srcFilePath");
	String destFileName=request.getParameter("destFilePath");
	System.out.println("srcFileName=>" + srcFileName);
	System.out.println("destFileName=>" + destFileName);
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>File Verification Result View</title>
</head>
<body>
<center><h2>Verification Result View</h2></center>
<table style="width:95%;">
	<tr>
		<td align="center" style="width:20px;">Line</td >
		<td align="center" style="width:470px;"><font color="blue"><b><%=srcFileName %></b></td>
		<td align="center" style="width:470px;"><font color="blue"><b><%=destFileName %></b></td>
	</tr>
<%
	String[] fileContents = readFile(srcFileName, destFileName);
	String lineCnt = null;
	String srcCnts = null;
	String destCnts = null;
	String[] dispCnts = null;
	for ( int i=0; i<fileContents.length; i++){
		StringTokenizer st = new StringTokenizer(fileContents[i], "^");
		if ( st.hasMoreElements()) lineCnt = (String)st.nextElement();
		if ( st.hasMoreElements()) srcCnts = (String)st.nextElement();
		if ( st.hasMoreElements()) destCnts = (String)st.nextElement();
%>
		<tr>
			<td align="right" style="width:20px;"><%=lineCnt %></td >
			<td align="left" style="width:470px;"><%=srcCnts%></td>
			<td align="left" style="width:470px;"><%=destCnts%></td>
		</tr>
<%
	}
%>
</body>
</html>