<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0930.jsp
*@FileTitle : Office Transfer Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-10-16 z_kim_sang_geun
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
<%@ page import="com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event"%>
<%
String strErrMsg = ""; //에러메세지
SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT); //Session 정보
%>
<html>
<head>
<title>Office Transfer Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
//-->
</script>
</head>




<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="480" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" width="9" height="9" hspace="5">Office Transfer</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<table class="search" border="0">
			<tr class="h23">
				<td width="24%">Transfer To</td>
				<td width="76%"><input name="new_trns_rqst_ofc_cd" type="text" style="width:100" value="" maxlength="6" onBlur="javascript:officeCheck(this);">
				<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search"></td>
			</tr>
			<tr class="h23">
				<td>Transfer Reason</td>
				<td><input name="new_trns_rqst_rsn" type="text" style="width:360" value=""></td>
			</tr>
			</table>


			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->


<table class="height_10"><tr><td></td></tr></table>
<script language="javascript">ComSheetObject('sheet');</script>



</td></tr>





<td class="button_valign">


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton" border="0">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0">
        <tr><td class="btn3_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr>

                        <!-- Repeat -->
                        <td width="90"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_transfer" name="btn_transfer">Transfer</td><td class="btn1_right"></td></tr></table></td>
                        <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_close" name="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
                        <!-- Repeat -->


                </tr></table>


        </td></tr></table>
</td></tr></table>
<!-- : ( Button : Sub ) (E) -->





</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->




</form>
</body>
</html>