<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ees_cim_1030.jsp
*@FileTitle : Cargo Flow Map Detail
*Open Issues :	
*Change history :
*@LastModifyDate : 2014.03.17
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.03.17 김종옥
* 1.0 Creation	
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1030Event"%>
<%@ page import="org.apache.log4j.Logger" %>	
<%
		EesCim1030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//서버에서 발생한 에러
		String strErrMsg = "";						//에러메세지
		int rowCount	 = 0;						//DB ResultSet 리스트의 건수
		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";
		String strUsr_id		= "";
		String strUsr_nm		= "";
		Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
		try {		
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id =	account.getUsr_id();
			strUsr_nm = account.getUsr_nm();
			event = (EesCim1030Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			if (serverException != null) {	
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}	
			
		} catch(Exception e) {	
			out.println(e.toString());	
		}
	%>
<html>
<head>		
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {	
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}	
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">		
<input type="hidden" name="pagerows">	
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Flow Map Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
			<table class="search"> 
       		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 

       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>