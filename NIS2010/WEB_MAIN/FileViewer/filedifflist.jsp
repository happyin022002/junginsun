<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Verify Tool</title>
</head>
<%!
	public String formatNumber(long fsize) {
		DecimalFormat dfm = new DecimalFormat("###,##0");
		
		return dfm.format(fsize);
	}
%>
<body>
<form name="form" action="filedifflist.jsp" method="post">
<%
	String frame = request.getParameter("frame");
	String dir = request.getParameter("dir");
%>

<script type="text/javascript">
	var iframetype = "<%=frame%>";
	function setFilePath(filepath){
		if ( iframetype == "src" ) {
			parent.form.srcfilepath.value = filepath;
		} else {
			parent.form.destfilepath.value = filepath;
		}
	}
	
	function getFileList(filepath){
		var frm = document.form;
		frm.dir.value=filepath;
        frm.submit();
	}
</script>
	<input type="hidden" name="frame" value="<%=frame %>"/>
	<table style="width:100%;" border="0" cellspacing="0" cellpadding="1">
		<tr>
	    	<td style="width:300px; valign="top">
	    		<input type="text" name="dir" maxlength="200" size="65" value="<%=dir %>"></input>
	    	</td>
	    	<td>
	    		<input type="submit" value="조회" ></input>
	    	</td>
		</tr>	
	</table>
	<table style="width:100%;" border="0" cellspacing="0" cellpadding="1">
<%
if(dir == null){
    System.out.println("param error");
} else {
	java.io.File f = new java.io.File(dir);
	if(f.exists()){
	    String [] filelist = f.list();	
%>
		<tr>
			<td align="center" style="width:300px;">파일경로</td >
			<td align="center" style="width:100px;">크기</td>
		</tr>
		<tr>
			<td style="width:300px;">
<%
		if(f.getParent() != null){
				String sep = f.getParent().replaceAll("\\\\","/");
	        	out.println("<a href='#' onclick='javascript:getFileList(\""+sep+"\");'> .. parent</a>");
		}
%>
			</td>
			<td></td>
		</tr>		
<%	    
	    for(int i=0;i<filelist.length;i++){
	    	String filepath = dir + "/" + filelist[i];
	        java.io.File f2 = new java.io.File(filepath);
%>
		<tr>
			<td style="width:300px;">
			<input type="radio" name="filepath" value=<%=filepath %> onclick='javascript:setFilePath("<%=filepath %>");'/>
<%          
			if ( f2.isDirectory() ) {
				String sep = dir + "/" + f2.getName().replaceAll("\\\\","/");
	        	out.println("<a href='#' onclick='javascript:getFileList(\""+sep+"\");'>" +f2.getName()+"/</a>");
	        } else {
%>
	        <%=f2.getName() %>
<%
	        }
%>
			</td>
			<td align="right" style="width:100px;" ><%=formatNumber(f2.length()) %> bytes</td>
		</tr>
<%
	    }
	}else{
		System.out.println("No File");
	}
}
%>
</table>
</form>
</body>
</html>