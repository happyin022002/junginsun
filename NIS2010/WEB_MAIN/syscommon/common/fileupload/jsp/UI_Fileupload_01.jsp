<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.file.ModuleMetaData"%>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<html>
<head>
<title>Welcome to nis2010!</title> 
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<%
	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	ModuleMetaData moduleMetaData = (ModuleMetaData)eventResponse.getCustomData("ModuleMetaData");
	
	String comFileMaxCount = (String)eventResponse.getCustomData("ComFileMaxCount");
	String maxFileSize = moduleMetaData.getMax_size();
%>

<script language="javascript">
	function setupPage(){
		loadPage();
	}	
</script>

<body onload="setupPage();"> 
<form name="form" action="/hanjin/FileUpload.do">
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="1" align="center"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

<!--  Button_Sub (S) --> 
   <table width="100%" class="button">  
         <tr><td class="btn2_bg"> 
    <table border="0" cellpadding="0" cellspacing="0"><tr>
      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> 
      <tr><td class="btn2_left"></td> 
      <td class="btn2" name="btn2_Add_File">File Add</td>
      <td class="btn2_right"></td> 
      </tr> 
      </table></td> 
      
      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> 
      <tr><td class="btn2_left"></td> 
      <td class="btn2" name="btn2_Upload_File">Upload</td>
      <td class="btn2_right"></td> 
      </tr> 
      </table></td> 
     </tr></table> 
   </td></tr> 
   </table>
    <!--Button (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table width="100%" class="grid2"> 
					<tr><td>				

						<!-- Grid  (S) -->
						<script language="javascript">ComUploadObject('upload1','obj',480,170);</script>
						<!-- Grid  (E) -->	
					</td></tr>				
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( bottom : email ) (S) -->
<table width="100%" class="popup">
<tr><td  class="bottom">
	<table align="center"><tr><td class="bottom_img" width="460" height="16"></td></tr></table>
</td></tr>
</table>
<!-- : ( bottom : email ) (E) -->	

<input type="hidden" name="subSysCd" id="subSysCd" value='<%=StringUtil.xssFilter(request.getParameter("subSysCd"))%>'>
<input type="hidden" name="maxFileSize" id="maxFileSize" value="<%=maxFileSize%>">
<input type="hidden" name="comFileMaxCount" id="comFileMaxCount" value="<%=comFileMaxCount%>">
<input type="hidden" name="flag" id="flag" value="<%=StringUtil.xssFilter(request.getParameter("flag"))%>">
<input type="hidden" name="usrFileCnt" id="usrFileCnt" value="<%=StringUtil.xssFilter(request.getParameter("usrFileCnt"))%>">
</form>	
</body>
</html>