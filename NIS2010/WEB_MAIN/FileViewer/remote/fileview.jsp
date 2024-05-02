<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.zip.*"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.*"%>
<%@ page import="fileviewer.rmi.*" %>
<%@ page import="java.rmi.Naming" %>

<%!
// 파일 다운로드...
private void download(HttpServletRequest request, HttpServletResponse response, byte[] is){
    BufferedOutputStream outs = null;
    String zipFileName = "waslog.zip";
    try {
    	outs = new BufferedOutputStream(response.getOutputStream());
        String strClient = request.getHeader("user-agent");
        // Response 헤더를 설정한다.
        response.reset() ;
    	response.setHeader ("Content-Length", ""+is );
        if ( strClient.indexOf("MSIE 5.5") != -1 ) {
            //response.setHeader("Content-Type", "doesn/matter; charset=utf-8");
            response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "filename=" + zipFileName + "; charset=utf-8");
        } else {
            response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipFileName + ";");
        }
        
        // 파일을 PC 에 전송한다.
		outs.write(is,0,is.length) ;
		
    } catch (IOException e) {
        e.printStackTrace();
    } catch ( Exception e ) {
    	e.printStackTrace();
    } finally {
        if ( outs != null ) {
            try {
                outs.flush();
            } catch ( Exception e ) {
                System.out.print("Exception occured when outputStream was closed\n");
                e.printStackTrace();
            }
        }
    }
}
%>
<%
	String server=request.getParameter("server");
	String port=request.getParameter("port");
    String filepath=request.getParameter("filepath");
    String readPos=request.getParameter("readpos");
    String readbyte=request.getParameter("readbyte");
    String lastFlag=request.getParameter("lastflag");
    String command=request.getParameter("command");
    String dnldSize=request.getParameter("dnldsize");
    
    System.out.print("Read file ==> " + filepath);
    System.out.println("   Read Position ==> " + readPos ) ;
    String contents = null;
    
    String bindName = "rmi://" + server + ":" + port + "/FileViewer";
    FileViewerRmi viewer = (FileViewerRmi)Naming.lookup(bindName);
    
    if ( command.equals("download")){
    	StringBuffer sb = new StringBuffer();
    	byte[] is = viewer.getZipFile(filepath, Integer.parseInt(dnldSize));
    	download(request,response,is);
    } else {
    	contents = viewer.readString(filepath, Integer.parseInt(readPos), Integer.parseInt(readbyte));
    }
       
   	if ( contents != null ) {
   		contents = contents.replaceAll("&","&amp;").replaceAll("<","&lt;")
   		.replaceAll(">","&gt;").replaceAll(" ","&nbsp;").
   		replaceAll("\t","&nbsp;&nbsp;&nbsp;&nbsp;").replaceAll("\\n","<br>");
   	}
        
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileViewer</title>
<script language="javascript">
window.onload=function(){
	document.getElementsByName("dnldsize")[0].focus();
}

function downloadFile(){
	document.form1.target="dlnd";
    document.form1.command.value='download';
    document.form1.readbyte.value='10000';
    document.form1.filepath.value='<%=filepath%>';
    document.form1.submit();
}
</script>
</head>
<body>
<font color="blue"><b> FileName : <%=filepath%></b></font>
<form name="form1" action="fileview.jsp" method="post">
<div style="width:970px;height:500px;overflow-y:scroll;word-wrap:break-word;word-break:break-all;">
<table width="950px" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #dddddd; border-right:1px solid #E0E0E0;">
	<tr>
		<td style="word-wrap:break-word;word-break:break-all;"><%=contents%></td>
	</tr>	
</table>

</div>
<font color="blue"><b>Download : Last <input type="text" size=20 value="20000" name="dnldsize" /> bytes</b></font>
<input type="button" value="DownLoad" name="download" onClick="downloadFile();" />
<input type="hidden" name="server" value="<%=server%>" /> 
<input type="hidden" name="port" value="<%=port%>" /> 
<input type="hidden" name="readpos" /> 
<input type="hidden" name="lastflag" />
<input type="hidden" name="readbyte" /> 
<input type="hidden" name="filepath" />
<input type="hidden" name="command" />
</form>

<iframe name="dlnd" style="display:none;width:1px;height:1px;"></iframe>
</body>
</html>