<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1127.jsp
*@FileTitle : Transmit / Receive History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.11.17 김경섭
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="p_vvd" value='<%= request.getParameter("p_vvd")%>'>
<input type="hidden" name="p_cstms_port_cd" value='<%= request.getParameter("p_cstms_port_cd")%>'>

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Transmit / Receive History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	
	<!--biz page (S)-->
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="" border="0">
					<tr class="h23">
						<td width="60">&nbsp;&nbsp;BL/No</td>
						<td width="120"><input type="text" style="width: 100;" class="input" name="p_bl_no" value="<%= request.getParameter("p_bl_no")%>" maxlength='12'	dataformat='engupnum' style="ime-mode:disabled" readonly>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--  biz_1   (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>	
		
			<!--Grid (s)-->
	<table class="search"> 
       	<tr><td class="bg">						
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!--Grid (E)-->
		</td></tr>
	</table>		
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
		<td class="">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
       	<tr><td class="" align="middle">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
					<td class="btn1_right"></td>
					<!-- 
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					 -->
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
		
		</td></tr>
		</table>
    <!--Button (E) -->	

	</td></tr>
		</table>

</form>	
</div>
<br>
<br>
</body>
</html>
