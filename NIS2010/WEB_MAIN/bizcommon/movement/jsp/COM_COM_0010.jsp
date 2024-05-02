<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0010.jsp
*@FileTitle  : Movement Status Code Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.movement.event.ComCom0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCom0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BizCommon.Account");
	
	String mdm_yn = request.getParameter("mdm_yn") != null ? request.getParameter("mdm_yn") : "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (ComCom0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.toString());
	}
%>
<html>
<head>
<title>Movement Status Code Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="mdm_yn" id="mdm_yn" value="<%=mdm_yn%>">
<table width="100%" class="popup" cellpadding="10">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Movement Status Code Inquiry
					</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<!-- : ( Scenario ID ) (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td>Code</td>
								<td><input type="text" name="mvmt_sts_cd" id="mvmt_sts_cd" dataformat="engup" style="width:50px;ime-mode:disabled" maxlength="2" class="input" value="<%=(request.getParameter("mvmt_sts_cd") == null) ? "" : request.getParameter("mvmt_sts_cd") %>"></td>
								<td>Description</td>
								<td><input type="text" name="mvmt_sts_nm" id="mvmt_sts_nm" dataformat="" otherchar=" " style="width:280px;ime-mode:disabled" maxlength="50" class="input"  value=""></td>
								<%
									if(!"".equals(mdm_yn) && mdm_yn.length() > 0){
								%>
								<td>Status</td>
								<td>
									<select style="width:85px;" name="delt_flg" id="delt_flg">
											<option value="ALL">ALL</option>
											<option value="N" selected="selected">Active</option>
											<option value="Y">Delete</option>
										</select>
								</td>
								<%
									}
								%>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>	
							</tr>		
						</table>
					</td>
				</tr>
			</table>	
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			<table class="height_5"><tr><td></td></tr></table>		
		</td>
	</tr>
</table>				
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_select">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>			
								<td class="btn1_line"></td>	
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>	
							</tr>
						</table>
					</td>
				</tr>			
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%@include file="../../include/common_alps.jsp"%>