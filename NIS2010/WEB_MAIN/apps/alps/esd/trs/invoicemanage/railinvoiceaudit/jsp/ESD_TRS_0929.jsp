<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0929.jsp
*@FileTitle : USA Rail Invoice 등록 및 Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-10-13 chkong
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0929Event"%>
<%
	EsdTrs0929Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String userId = "";
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   
		event = (EsdTrs0929Event)request.getAttribute("Event");

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
<title>USA Rail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("inv_curr_cd", "", "CD00884", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<!-- OUTER - POPUP (S)tart -->
<table width="755" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="735" border="0">
			<tr>
				<td height="79" class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Payment History </td>
			</tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg_a">
					<table class="search" border="0" style="width:717;">
						<tr class="h23">
							<td width="12%">Container  No. </td>
						<td width="38%"><input name="cntr_no" type="text" style="width:243;" readOnly></td>
						<td width="15%">&nbsp;</td>
						<td width="38%">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_15"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg_a">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
				    </table>
					<!-- : ( Grid ) (E) -->
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->


		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr>
			<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>

</body>
</html>
