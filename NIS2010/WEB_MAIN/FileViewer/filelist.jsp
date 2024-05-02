<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function getFileList(filepath, clickParent){
		var frm = parent.document.form;
        frm.filepath.value=filepath;
        if ( clickParent==true ){
        	//frm.reg_name.value="";
        }
        
        parent.doAction();
	}

    function getFileContents(filepath){
        var frm = document.form;
        frm.filepath.value=filepath;
        frm.action = "fileview.jsp";
        //frm.action = "logfileview.jsp";
        //frm.action = "logfileviewscreen.jsp";
        frm.submit();
    }
</script>
<%!
	public String formatDate(long date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		Date dt = cal.getTime();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  HH: mm: ss");
		return ft.format(dt);
	}
%>
<%!
	public String formatNumber(long fsize) {
		DecimalFormat dfm = new DecimalFormat("###,##0");
		
		return dfm.format(fsize);
	}
%>
<body>
<form name="form" action="filelist.jsp" method="post">
<%
try{
	String dir = request.getParameter("filepath");
    String regexStr = request.getParameter("reg_name");
    if ( regexStr == null ) regexStr = "";
    if(dir == null){
        System.out.println("param error");
    }
	java.io.File f = new java.io.File(dir);
	if(f.exists()){
	    String [] filelist = f.list();
        Arrays.sort(filelist);
%>
	<table name="fileLstTbl" style="width:100%;">
		<tr>
			<td align="center" style="width:50%;">파일경로</td >
			<td align="center" style="width:5%;">권한</td>
			<td align="center" style="width:15%;">크기</td>
			<td align="center" style="width:20%;">날짜</td>
		</tr>
		<tr>
			<td align="left" style="width:50%;">
<%
		if(f.getParent() != null){
				String sep = f.getParent().replaceAll("\\\\","/");
	        	out.println("<a href='#' onclick='javascript:getFileList(\""+sep+"\",true);'> .. parent</a>");
		}
%>
			</td>
			<td style="width:5%;"></td>
			<td style="width:15%;"></td>
			<td style="width:20%;"></td>
		</tr>
<%
        String filepath = null;
        java.io.File f2 = null;
        String separator = "/";

        String regexStr2 = null;    // 정규표현식
        boolean iswild = regexStr != null && !regexStr.equals("");   // 와일드카드 적용여부
        java.util.regex.Pattern p = null;
        java.util.regex.Matcher m = null;

        if (iswild) {
            // 와일드카드를 정규표현식으로 변환
            regexStr2 = regexStr
            //.toUpperCase()    // 대소문자 구분 안할 경우
            .replaceAll("\\.","\\\\.").replaceAll("\\^","\\\\^").replaceAll("\\$","\\\\$")
            .replaceAll("\\(","\\\\(").replaceAll("\\)","\\\\)").replaceAll("\\[","\\\\[")
            .replaceAll("\\]","\\\\]").replaceAll("\\{","\\\\{").replaceAll("\\}","\\\\}")
            .replaceAll("\\+","\\\\+").replaceAll("\\|","\\\\|")
            .replaceAll("\\*","[\\\\w\\\\W]*").replaceAll("\\?","\\.");

            p = java.util.regex.Pattern.compile(regexStr2);
        }
        String[] fPerm = null;
	    for(int i=0;i<filelist.length;i++){
	    	filepath = dir + separator + filelist[i];
	        f2 = new java.io.File(filepath);
	        
	        fPerm = new String[3];
	        fPerm[0] = "- ";
	        fPerm[1] = "- ";
	        fPerm[2] = "- ";
	        
	        
			if ( f2.canRead()) fPerm[0] = "r ";
			if ( f2.canWrite()) fPerm[1] = "w ";
			if ( f2.canExecute()) fPerm[2] = "x ";
			
			String permission = fPerm[0] + fPerm[1] + fPerm[2];
			
	        if (iswild) {
	            //m = p.matcher(f2.getName().toUpperCase());   // 대소문자 구분 안할 경우
	            m = p.matcher(f2.getName());
	            if (!m.matches() || f2.getParent()==null) {
	                continue;
	            }
	        }
%>
		<tr>
			<td align="left" style="width:50%;">
<%
            if ( f2.isDirectory() ) {
                out.println("<img src='./img/btns_file.gif' width='15' height='15' border='0' align='absmiddle'> <a href='#' onclick='javascript:getFileList(\""+filepath+"\");'>" +f2.getName()+"/</a>");
            } else if (f2.isFile()) {
                out.println("<img src='./img/btns_note.gif' width='15' height='15' border='0' align='absmiddle'> <a href='#' onclick='javascript:getFileContents(\""+filepath+"\");'>"+f2.getName()+"</a><BR>");
            }
%>
			</td>
			<td align="center" style="width:5%;"><%=permission %> </td>
			<td align="right" style="width:15%;"><%=formatNumber(f2.length()) %> bytes</td>
			<td align="center" style="width:20%;"><%=formatDate(f2.lastModified()) %></td>
		</tr>
<%
	    }
	}else{
		System.out.println("No File");
	}
}catch(Exception e){
	
}
%>
</table>
<input type="hidden" name="filepath">
<input type="hidden" name="readpos" value="0" /> 
<input type="hidden" name="command" value="last" /> 
<input type="hidden" name="readbyte" value="10000" />
</form>
</body>
</html>